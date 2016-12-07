package game;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import game.AudioInit;

public class Music
{
	private String audioPath;
	private Clip audioClip;
	
	public Clip createClip (String audioPath)
	{	
		audioClip = null;
		
		try
		{
			//initialization of things necessary for playing music
			File audioFile = new File(audioPath);
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
			AudioFormat format = audioStream.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format);
			audioClip = (Clip) AudioSystem.getLine(info);
			audioClip.open(audioStream);
		}
		
		catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) 
		{
			System.out.println("There was a problem with playing the file");
			e.printStackTrace();
		}
		
		return audioClip;
	}
	
	public String getAudioPath()
	{
		return audioPath;
	}
	
	public static void stopClip(Clip audioClip)
	{
		audioClip.stop();                
		audioClip.flush();               
		audioClip.setFramePosition(0);
	}
	public static void startClip(Clip audioClip)
	{
		audioClip.loop(Clip.LOOP_CONTINUOUSLY);
	}
}
