package game;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Audio extends Thread
{
	private String audioPath;
	private audioFormat type;
	
	private long effectLength;
	private Clip audioClip;
	private File audioFile;
	private AudioInputStream audioStream;
	private AudioFormat format;
	private DataLine.Info info;
	
	public long getEffectTickLength()
	{
		File file = new File(audioPath);
		AudioInputStream audioInputStream = null;
		try 
		{
			audioInputStream = AudioSystem.getAudioInputStream(file);
		} 
		catch (UnsupportedAudioFileException e) 
		{
			e.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		AudioFormat format = audioInputStream.getFormat();
		long frames = audioInputStream.getFrameLength();
		double durationInSeconds = (frames+0.0) / format.getFrameRate();  
		long effectTickLength = (long) durationInSeconds * 60;
		return effectTickLength;
	}
	
	public enum audioFormat
	{
		MUSIC,EFFECT
	}
	
	public Audio (String audioPath, audioFormat type)
	{
		this.audioPath = audioPath;
		this.type = type;
	}
	
	public void run()
	{	
		try
		{
			//initialization of things necessary for playing music
			audioFile = new File(audioPath);
			audioStream = AudioSystem.getAudioInputStream(audioFile);
		    format = audioStream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			audioClip = (Clip) AudioSystem.getLine(info);
			audioClip.open(audioStream);
			effectLength = audioClip.getMicrosecondLength();
			
			//loop map music indefinitely until new Audio() thread instantiated
			if (type == audioFormat.MUSIC)
			{
				audioClip.loop(Clip.LOOP_CONTINUOUSLY);
			}
			else if (type == audioFormat.EFFECT)
			{
				audioClip.start();
				//because time is in microseconds, convert to milliseconds
				Thread.sleep(effectLength/1000);
			}
		}
		catch (IOException | UnsupportedAudioFileException | LineUnavailableException | InterruptedException e) 
		{
			System.out.println("There was a problem with playing the file");
			e.printStackTrace();
		}
	}
	
	public void stopMusic()
	{
		audioClip.close();
	}
	
	public void restartMusic(String audioPath)
	{
		try 
		{
			audioFile = new File(audioPath);
			audioStream = AudioSystem.getAudioInputStream(audioFile);
		    format = audioStream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			audioClip = (Clip) AudioSystem.getLine(info);
			audioClip.open(audioStream);
			audioClip.loop(Clip.LOOP_CONTINUOUSLY);
		}
		catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) 
		{
			System.out.println("There was a problem with playing the file");
			e.printStackTrace();
		}
	}
}