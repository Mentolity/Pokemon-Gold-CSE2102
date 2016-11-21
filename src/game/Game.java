package game;
import gfx.Map;
import gfx.Screen;
import gfx.SpriteSheet;
import items.Antidote;
import items.Pokeball;
import items.Potion;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import pokemon.Bulbasaur;
import pokemon.Charmander;
import pokemon.Squirtle;
import save.Player;
import save.Save;
import maps.MainMap;
import menu.ItemOption;
import menu.PokemonOption;
import menu.SaveOption;
import menu.TitleMenu;

import java.util.Hashtable;

// extends the canvas to the class and implements runnables
// not exactly sure what this means but its required to use JFrames I think
public class Game extends Canvas implements Runnable{
	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 160; //width of the game
	public static final int HEIGHT = 144; //height of the game
	public static final int SCALE = 4; //allows you to scale the game
	public static final String NAME = "Definitely Not Pokemon"; //name of the game
	public static SpriteSheet sheet = new SpriteSheet("/spritesheet.png");

	private JFrame frame;
	
	public boolean running = false;
	public int tickCount = 0;
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB); //Creates a new buffered image object
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();//Represents how many pixels are inside the image
	
	public static Screen screen;
	public InputHandler input;
	public Controller cont;
	public TitleMenu titlemenu;
	public Save saves[];
	
	Map map = new MainMap();
	
	static public Hashtable <Integer, String> musicPaths = new Hashtable <Integer, String>();
	static public Hashtable <Integer, String> effectPaths = new Hashtable <Integer, String>();
	
	public static Audio musicThread;

	//constructor
	public Game(){
		//sets the canvas to within these bounds
		setMinimumSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		setMaximumSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		
		frame = new JFrame(NAME); //creates the JFrame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //when the games down running just get rid of it
		frame.setLayout(new BorderLayout()); //makes sure the sizing is okay by changing the way it sets up the JFrame by centering it
		frame.add(this, BorderLayout.CENTER);	
		frame.pack(); //pack it so that it sets the frame so that its at or above the correct size keeps everything sized correctly	
		frame.setResizable(false); //not resizable	
		frame.setLocationRelativeTo(null); //not relative to anything just centered	
		frame.setVisible(true); //makes the frame visable
		
		assignEffectPaths (effectPaths);
		assignMusicPaths (musicPaths);
		
		music = new Audio(musicPaths.get(1), audioFormat.MUSIC);
		musicThread.start();
	}
	
	//adds a new screen
	public void init(){
		screen = new Screen(WIDTH, HEIGHT, new SpriteSheet("/spritesheet.png"));
		input = new InputHandler(this);
		saves = new Save[]{
				new Save(new Player("Owen", new ItemOption[]{
					new ItemOption(new Potion(), 10),
					new ItemOption(new Antidote(), 1),
					new ItemOption(new Pokeball(), 5),
			},		new PokemonOption[]{
					new PokemonOption(new Charmander(5)),
					new PokemonOption(new Squirtle(6)),
					new PokemonOption(new Bulbasaur(7)),
		})),	new Save(new Player("Ian", new ItemOption[]{
					new ItemOption(new Potion(), 10),
					new ItemOption(new Antidote(), 1),
					new ItemOption(new Pokeball(), 5),
			},		new PokemonOption[]{
					new PokemonOption(new Charmander(5)),
					new PokemonOption(new Squirtle(6)),
					new PokemonOption(new Bulbasaur(7)),
		})),	new Save(new Player("Vova", new ItemOption[]{
					new ItemOption(new Potion(), 10),
					new ItemOption(new Antidote(), 1),
					new ItemOption(new Pokeball(), 5),
			},		new PokemonOption[]{
					new PokemonOption(new Charmander(5)),
					new PokemonOption(new Squirtle(6)),
					new PokemonOption(new Bulbasaur(7)),
		})),	new Save(new Player("Kyle", new ItemOption[]{
					new ItemOption(new Potion(), 10),
					new ItemOption(new Antidote(), 1),
					new ItemOption(new Pokeball(), 5),
			},		new PokemonOption[]{
					new PokemonOption(new Charmander(5)),
					new PokemonOption(new Squirtle(6)),
					new PokemonOption(new Bulbasaur(7)),
		}))};
		titlemenu = new TitleMenu(saves);
		titlemenu.open();
		for(int x=0;x<saves.length;x++){
			titlemenu.options[x] = new SaveOption(saves[x]).setPos(16, (x*9)+9);
		}
	}	
	
	//start method
	private synchronized void start() {
		running = true;
		new Thread(this).start();
	}
	
	//stop method
	private synchronized void stop(){
		running = false;
	}
	
	public void run() {
		//main game loop is in this function
		
		long lastTime = System.nanoTime(); //gets the time when it is called	
		double nsPerTick = 1000000000D/60D; //how many nanoSecounds per Tick
		int frames = 0; //how many frames have occured
		int ticks = 0; //how many ticks have occured
		long lastTimer = System.currentTimeMillis(); //gets the current system time
		double delta = 0; //how many nano-secounds have gone by so far;	
		
		init();
		
		while(running){
			long now = System.nanoTime(); //current time
			delta+=(now - lastTime)/nsPerTick; //how much time has past between each tick
			lastTime = now; //updates lastTime each tick
			boolean shouldRender = true; //should render is to limit the frames that can be render per tick
			//runs for one tick
			while(delta>=1){
				ticks++;
				tick();
				delta--;
				shouldRender = true; //render every time a tick passes
			}
			
			//if not limiting through should render it keeps the thread from overloading
			try{
				Thread.sleep(10);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
			if (shouldRender){
				frames++;
				render();
			}
			//if the current time minus the last time is greater than 1000 update
			//this is so that it updates once per tick instead of as fast as my computer can handle
			if(System.currentTimeMillis() - lastTimer >= 1000){
				lastTimer+=1000;
				System.out.println(frames + " frames, " + ticks + " ticks");
				frames = 0;
				ticks = 0;
			}
		}
	}
	
	//tick is going to update the game *the logic
	public void tick(){
		tickCount++;
		if(titlemenu.isOpen()) titlemenu.navigate(input);
		else if(cont==null){
			SaveOption so = (SaveOption) titlemenu.options[titlemenu.loc];
			cont = new Controller(so.save);
		}
		else cont.tick(this, screen);
	}

	
	//will render the game

	public void render(){
		if(titlemenu.isOpen()) titlemenu.render(screen);
		else{
			if(cont!=null){
				map.render(screen, cont.mc);
				cont.menu.render(screen);
			}
		}
		/*
		String msg = "This is my game!";
        Fonts.render(msg, screen, screen.xOffset + screen.width / 2 - (msg.length() * 8 / 2), screen.yOffset + screen.height / 2);
		 */		
		
		BufferStrategy bs = getBufferStrategy(); //An object that allows us to organize the data on the canvas
		if(bs == null){
			createBufferStrategy(3); 	//if its not already buffering buffer it
										//number of times the images are buffered 
			return;
		}	
		
		for(int y=0; y<screen.height;y++){
			for(int x=0; x<screen.width;x++){
				pixels[x + y * WIDTH] = screen.pixels[(x) + (y * screen.width)];
			}
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null); //gets whatever the content of image is and puts it on the screen
		
		g.dispose();//frees up memory that the graphics object isn't using
		bs.show(); // shows the content of the buffer
	}
	
	private void assignMusicPaths (Hashtable <Integer, String> musicPaths)
	{
		musicPaths.put(1,"./res/newBarkTown.wav");
		musicPaths.put(2,"./res/elmLab.wav");
		musicPaths.put(3,"./res/route29.wav");
		return;
	}
	private void assignEffectPaths (Hashtable <Integer, String> effectPaths)
	{
		effectPaths.put(1,"./res/bump.wav");
		effectPaths.put(2,"./res/doorEnter.wav");
		return;
	}
	
	public static void main(String[] args){
		new Game().start();
	}
}
