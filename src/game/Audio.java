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
	
	public Audio (String audioPath, audioFormat type)
	{
		this.audioPath = audioPath;
		this.type = type;
	}
	
	//type used to distinguish between music and sound effects
	public enum audioFormat
	{
		MUSIC,EFFECT
	}
	
	public void run()
	{	
		try
		{
			//initialization of things necessary for playing music
			File audioFile = new File(audioPath);
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
			AudioFormat format = audioStream.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format);
			audioClip = (Clip) AudioSystem.getLine(info);
			audioClip.open(audioStream);
			
			//loop map music indefinitely until audioClip is stopped (stopAudio())
			if (type == audioFormat.MUSIC)
			{
				audioClip.loop(Clip.LOOP_CONTINUOUSLY);
			}
			else if (type == audioFormat.EFFECT)
			{
				audioClip.start();
				//because time is in microseconds, convert to milliseconds
				effectLength = audioClip.getMicrosecondLength();
				Thread.sleep(effectLength/1000);
			}
		}
		catch (IOException | UnsupportedAudioFileException | LineUnavailableException | InterruptedException e) 
		{
			System.out.println("There was a problem with playing the file");
			e.printStackTrace();
		}
	}
	
	private void playNewSong(String audioPath)
	{
		try 
		{
			this.audioPath = audioPath;
			File audioFile = new File(audioPath);
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
			AudioFormat format = audioStream.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format);
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
	
	public void switchSong(String audioPath)
	{
		boolean sameSong = checkSameSong(audioPath);
		if (sameSong)
		{
			return;
		}
		stopAudio();
		playNewSong(audioPath);
	}
	
	private boolean checkSameSong(String audioPath)
	{
		boolean sameSong = false;
		if (this.audioPath == audioPath)
		{
			return sameSong = true;
		}
		return sameSong;
	}
	
	public String getAudioPath()
	{
		return audioPath;
	}
	
	public void stopAudio()
	{
		if(audioClip != null)
			audioClip.close();
	}
	
	//gets the length in ticks of sound effects
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
	
	/*public void restartEffect()
	{
		audioClip.setFramePosition(0);
		audioClip.start();
	}
	*/
}
