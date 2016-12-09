package game;

import java.util.Hashtable;
import javax.sound.sampled.Clip;

//initializes things necessary for audio; also organizes audio things
public class AudioInit {

	static public Hashtable <Integer, String> musicPaths = new Hashtable <Integer, String>();
	static public Hashtable <Integer, String> effectPaths = new Hashtable <Integer, String>();
	
	static public Clip newBarkTown;
	static public Clip elmLab;
	static public Clip route29;
	static public Clip titleScreen;
	static public Clip cherryGrove;
	static public Clip pokeCenter;
	
	static public Clip bump;
	static public Effect door;
	static public Clip menuSelect;
	
	public AudioInit()
	{
		assignMusicPaths(musicPaths);
		assignEffectPaths(effectPaths);
		
		Music music = new Music();
		
		newBarkTown = music.createClip(musicPaths.get(1));
		elmLab = music.createClip(musicPaths.get(2));
		route29 = music.createClip(musicPaths.get(3));
		titleScreen = music.createClip(musicPaths.get(5));
		cherryGrove = music.createClip(musicPaths.get(6));
		pokeCenter = music.createClip(musicPaths.get(7));
	}
	
	private void assignMusicPaths (Hashtable <Integer, String> musicPaths)
	{
		musicPaths.put(1,"/newBarkTown.wav");
		musicPaths.put(2,"/elmLab.wav");
		musicPaths.put(3,"/route29.wav");
		musicPaths.put(4,"/wildPokemonBattle.wav");
		musicPaths.put(5,"/titleScreen.wav");
		musicPaths.put(6,"/cherryGrove.wav");
		musicPaths.put(7,"/pokeCenter.wav");
		return;
	}
	private void assignEffectPaths (Hashtable <Integer, String> effectPaths)
	{
		effectPaths.put(1,"/bump.wav");
		effectPaths.put(2,"/doorEnter.wav");
		effectPaths.put(3,"/doorLeave.wav");
		effectPaths.put(4,"/menuSelect.wav");
		effectPaths.put(5,"/openMenu.wav");
		return;
	}
}
