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

public class Effect extends Thread
{
	private String audioPath;
	private Clip audioClip;
	
	public Effect (String audioPath)
	{
		this.audioPath = audioPath;
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
			audioClip.start();
			long effectLength = audioClip.getMicrosecondLength();
			Thread.sleep(effectLength/1000);

		}
		catch (IOException | UnsupportedAudioFileException | LineUnavailableException | InterruptedException e) 
		{
			System.out.println("There was a problem with playing the file");
			e.printStackTrace();
		}
	}
}
