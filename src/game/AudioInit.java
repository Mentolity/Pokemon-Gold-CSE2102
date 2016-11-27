package game;

import java.util.Hashtable;

//initializes things necessary for audio; also organizes audio things
public class AudioInit {

	static public Hashtable <Integer, String> musicPaths = new Hashtable <Integer, String>();
	static public Hashtable <Integer, String> effectPaths = new Hashtable <Integer, String>();
	
	static public Audio musicThread;
	
	public AudioInit()
	{
		assignMusicPaths(musicPaths);
		assignEffectPaths(effectPaths);
	}
	
	private void assignMusicPaths (Hashtable <Integer, String> musicPaths)
	{
		musicPaths.put(1,"./res/newBarkTown.wav");
		musicPaths.put(2,"./res/elmLab.wav");
		musicPaths.put(3,"./res/route29.wav");
		musicPaths.put(4,"./res/wildPokemonBattle.wav");
		musicPaths.put(5,"./res/continue.wav");
		return;
	}
	private void assignEffectPaths (Hashtable <Integer, String> effectPaths)
	{
		effectPaths.put(1,"./res/bump.wav");
		effectPaths.put(2,"./res/doorEnter.wav");
		return;
	}

	public void initMusicThread()
	{
		musicThread = new Audio(AudioInit.musicPaths.get(5), Audio.audioFormat.MUSIC);
		musicThread.start();
	}
}
