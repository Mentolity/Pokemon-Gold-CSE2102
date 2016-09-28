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

public class Music extends Thread
{
	String audioPath;
	public Music (String audioPath)
	{
		this.audioPath = audioPath;
	}
	public void run()
	{
		try
		{
			File audioFile = new File(audioPath);
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
	
			AudioFormat format = audioStream.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format);
	
			Clip audioClip = (Clip) AudioSystem.getLine(info);
	
			audioClip.open(audioStream);
							
			long songLength = audioClip.getMicrosecondLength();
			
			//loop map music indefinitely
			while(true){
				audioClip.start();
				System.out.println("Song Started.");
				System.out.println("Length: " + songLength);
				Thread.sleep(songLength/1000);
				System.out.println("Song Ended");
				audioClip.close();
				audioClip.open();
			}
		}
	
		catch(IOException exception)
		{
			System.out.println("There was a problem with playing the file");
			exception.printStackTrace();
		}
		catch(UnsupportedAudioFileException exception)
		{
			System.out.println("The audio file is of an unsupported type");
			exception.printStackTrace();
		} 
		catch (LineUnavailableException e) {
			e.printStackTrace();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}