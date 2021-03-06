package gameEngine;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ListIterator;

import background.CameraScrollLevel;
import dofa.Dofa;
import gameObject.GameObject;
import gameObject.Handler;
import gameObject.Wall;
import image.Assets;
import input.KeyInput;
import spawner.Spawner;
import sprite.AnimationSprite;
import sprite.SpriteBuilder;
import window.Window;

// Clase principal para que el juego corra
/*
 * Implementa la clase Runnable, la cual corre al m�todo run() 
 * cuando se inicia el thread princilal 
 */
public class Game implements Runnable{
	// Variables que determinan el ancho, el alto y el t�tulo del juego
	public static int width, height;
	public String title;
	
	// �ste es el thread principal sobre el cu�l va a correr el juego
	public Thread thread;
	
	// Se crean variables de las clases que creamos
	private Window window;
	private Handler handler;
	private KeyInput keyInput;
	private Spawner spawner;
	private CameraScrollLevel back;
	private AnimationSprite bat;
	private AnimationSprite bat1;
	private AnimationSprite bat2;
	
	// �stas 2 variables nos van a ayudar a hacer el renderizado en el juego
	private BufferStrategy bs;
	private Graphics g;
	
	// Con la variable booleana
	private boolean running = false;
	
	// Se crea el constructor de la clase, recibe el tama�o de la ventana y su t�tulo
	public Game(String title, int width, int height)
	{
		this.title = title;
		Game.width = width;
		Game.height = height;
	}
	
	// M�todo que inicializa los recursos que ser�n utilizados a lo largo del juego
	public void init()
	{
		// Inicializa todas las im�genes (se encuentran en Assets)
		/*
		 * Hacer uso de Assets nos da la ventaja de no tener que estar cargando
		 * las im�genes cada que sean ocupadas, sino que solo se cargan una vez
		 * y son referenciadas cuando se requieran usar.
		 */
		Assets.init();
		
		// Se crea la ventana, d�ndole su width, height y el t�tulo del juego
		window = new Window(title, width, height);
		// Se crea el Handler 
		/*
		 * Handler nos ayuda a manejar los updates y renderizados de los objetos
		 * contenidos en el juego
		 */
		handler = new Handler();
		// Se crea el spawner
		/*
		 * El Spawner revisa constantemente en qu� momento es necesario crear 
		 * nuevos enemigos y en �ste caso, lleva el tracking del nivel.
		 */
		spawner = new Spawner(handler);
		
		// Se crea al jugador
		//Dofa player = new Dofa(100, 200, 50, 50, handler);
		Dofa.createInstance(100, 200, 50, 50, handler);
		back=new CameraScrollLevel(width,height);
		
		SpriteBuilder builder=new SpriteBuilder(29,17);
		SpriteBuilder builder1=new SpriteBuilder(29,17);
		SpriteBuilder builder2=new SpriteBuilder(29,17);
		SpriteBuilder builder4=new SpriteBuilder(29,17);
        builder.addImage(8,0);
        builder.addImage(9,0);
        builder.addImage(10,0);
        builder.addImage(9,0);
        builder1.addImage(1,0);
        builder1.addImage(2,0);
        builder1.addImage(3,0);
        builder1.addImage(2,0);
        builder2.addImage(7,0);
        builder4.addImage(1,0);
        bat=new AnimationSprite(100,100,builder.build());
        bat.setAnimSpd(5);
        bat1=new AnimationSprite(100,100,builder1.build());
        bat1.setAnimSpd(5);
        bat2=new AnimationSprite(100,100,builder2.build());
        bat2.setAnimSpd(5);
		// Se crea el KeyInput
		/*
		 * En nuestro caso, qui�n se har� cargo de escuchar los inputs recibidos
		 * por el usuario, es el jugador.
		 */
		keyInput = new KeyInput(Dofa.getInstance());
		// A�ade el KeyInput a la ventana, para que �sta sea la intermediaria
		window.getFrame().addKeyListener(keyInput);
		
		// Se le a�aden los objetos pared y jugador al Handler
		handler.addObj(Dofa.getInstance());
		handler.addObj(new Wall(0, 725, 3000, 50, handler));
	}
	
	// El m�todo start se encarga de iniciar al juego
	public synchronized void start()
	{
		// Si el juego se est� corriendo, no hace nada
		if (running) return;
		// Hace que running pase al estado de true e inicia el thread principal
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	// El m�todo stop se encarga de detener al juego
	public synchronized void stop()
	{
		// Si el juego no est� corriendo, no hace nada
		if (!running) return;
		// Hace que running pase al estado de false y termina el thread principal
		running = false;
		try
		{
			thread.join();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	// El m�todo tick() se encarga de realizar el update del juego
	public void tick()
	{
		// Se llama al m�todo tick del Handler y del Spawner
		handler.tick();
		spawner.tick();
		ListIterator <GameObject> itr = handler.obj.listIterator();
		while (itr.hasNext()) {
			GameObject aux=itr.next();
			if(aux instanceof Dofa) {
				Dofa aux1=(Dofa)aux;
				if(aux1.getFlagDir()==1) {
					back.setSpeed(3);
				}else if(aux1.getFlagDir()==-1) {
					back.setSpeed(-3);
				}
				else if(aux1.getFlagDir()==0) {
					back.setSpeed(0);
				}
				bat.update(aux1.getX(),aux1.getY());
				bat1.update(aux1.getX(),aux1.getY());
				bat2.update(aux1.getX(),aux1.getY());
			}
		}
		back.tick();
	}
	
	// El m�todo render() se encarga de hacer el renderizado del juego
	public void render(){
		String level=spawner.toString();
		// Se obtiene el BufferStrategy que tiene el Canvas de Window
		bs = window.getCanvas().getBufferStrategy();
		// Si Canvas no tiene un BufferStrategy
		if (bs == null)
		{
			// Se le crea uno de 3 Buffers y retorna
			window.getCanvas().createBufferStrategy(3);
			return;
		}
		// Graphics obtiene lo que est� dibujado en el BufferStrategy
		g = bs.getDrawGraphics();
		// Se limpia el Buffer para dibujar en blanco
		g.clearRect(0, 0, width, height);
		// Dibuja el fondo
		back.draw(g);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Helvetica", Font.PLAIN, 30));
		g.drawString(level, 0,25);
		//g.drawImage(Assets.flag,100,425,150,300,null);
		ListIterator <GameObject> itr = handler.obj.listIterator();
		/*while (itr.hasNext()) {
			GameObject aux=itr.next();
			if(aux instanceof Player) {
				Player aux1=(Player)aux;
				bat.render(g,aux1.getWidth(),aux1.getHeight());
			}
		}*/
		while (itr.hasNext()) {
			GameObject aux=itr.next();
			if(aux instanceof Dofa) {
				Dofa aux1=(Dofa)aux;
				if(aux1.getFlagDir()==1) {
					bat.render(g,aux1.getWidth(),aux1.getHeight());
				}else if(aux1.getFlagDir()==-1) {
					bat1.render(g,aux1.getWidth(),aux1.getHeight());
				}
				else if(aux1.getFlagDir()==0) {
					bat2.render(g,aux1.getWidth(),aux1.getHeight());
				}
			}
		}
		handler.render(g);
		g.dispose();
		bs.show() ;
		
	}
				/*bat.update(aux1.getX(),aux1.getY());
				bat1.update(aux1.getX(),aux1.getY());/*
			}
		}
		//g.drawImage(Assets.background, 0, 0, width, height, null);
		//g.drawImage(Assets.player, 200, 400, 200, 200, null);
		//g.drawImage(Assets.ufo, 500, 100, 100, 100, null);
		
		// Pinta los objetos contenidos en el handler
		handler.render(g);
		
		// Deja de hacer uso del "pincel" para no consumir los recursos todo el tiempo
		g.dispose();
		// Muestra lo que Graphics dibuj� en los Buffers
		bs.show();
	}
	
	/*
	 * Los m�todos clamp() ayudan a establecer l�mites y revisar si alguna variable
	 * (la que sea, siempre y cuando sea num�rica) se sali� de esos bordes.
	 * */
	public static double clamp(double var, double min, double max)
	{
		if (var >= max) return var = max;
		else if (var <= min) return var = min;
		else return var;
	}
	
	public static boolean clampBool(double var, double min, double max)
	{
		if (var >= max) return true;
		else if (var <= min) return true;
		else return false;
	}
	
	// �ste es el m�todo primordial para el GameLoop
	public void run()
	{
		// Llama a init() para inicializar lo que es requerido en el juego
		init();
		// Se declara un target de actualizaciones por segundo con fps
		// Con ticks se hace tracking de las actualizaciones que se hacen por segundo
		int fps = 60, ticks = 0;
		// timePerTick nos muestra cu�nto tiempo debe pasar entre cada update
		// timePerTick es 1000000000 porque se manejar� el tiempo en nano segundos
		// delta nos ayuda a saber si el tiempo de timePerTick ya ha pasado
		double timePerTick = 1000000000 / fps, delta = 0;
		// now nos da el tiempo actual y lastTime el tiempo anterior
		// timer da seguimiento al tiempo que ha pasado desde el �ltimo ciclo
		long now, lastTime = System.nanoTime(), timer = 0;
		
		// Mientras el juego se encuentre corriendo...
		while (running)
		{
			// Se obtiene el tiempo actual
			now = System.nanoTime();
			// Se le suma a delta para ver si es momento de hacer un update
			delta += (now-lastTime) / timePerTick;
			// Se le suma a timer el tiempo que se lleva
			timer += now - lastTime;
			// lastTime avanza a ser el actual
			lastTime = now;
			
			// Si el delta es mayor o igual a uno
			if (delta >= 1)
			{
				// Se realiza el update y el pintado
				tick();
				render();
				// Se le suma uno a ticks para dar seguimiento a las actualizaciones que
				// se llevan en �ste segundo
				ticks ++;
				// Se reduce delta en uno para que se pueda volver a realizar el update
				delta --;
			}
			
			// �sto significa que si ha pasado ya un segundo
			if (timer >= 1000000000)
			{
				// Imprime el n�mero de actualizaciones que se hicieron en ese segundo
				System.out.println("Ticks and frames: " + ticks);
				// Reinicia los contadores
				ticks = 0;
				timer = 0;
			}
		}
		// Cuando el juego ya no est� corriendo, se detiene
		stop();
	}
		
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	
}
