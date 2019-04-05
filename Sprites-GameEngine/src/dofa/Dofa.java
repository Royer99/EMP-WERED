package dofa;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ListIterator;

import character.Chracter;
import enemy.Enemy;
import gameEngine.Game;
import gameObject.GameObject;
import gameObject.Handler;
import gameObject.Wall;
import image.Assets;
import spawner.SpawnerB;

// Clase que define el comportamiento del jugador
public class Dofa extends Chracter{

	// Tiene una velocidad al rebotar
	private static Dofa instance;
	private int velBounce;
	private BufferedImage image;
	private SpawnerB spb;
	private int flagDir;
	// Constructor que recibe los atributos de un GameObject
	public Dofa(double x, double y, int width, int height,Handler handler) {
		super(x, y, width, height, handler);
		flagDir=0;
		image=Assets.dofa;
		// La velocidad al rebotar por defecto es de -8
		// Es -8 dado a que al rebotar, la pelota se mueve a arriba (negativo)
		velBounce = -8;			
	}
	public Dofa() {
		super();
	}
	
	public static void createInstance(double x, double y, int width, int height,Handler handler) {
		if(instance==null) {
			instance=new Dofa(100, 200, 50, 50, handler);
		}
	}
	
	public static Dofa getInstance() {
		return instance;
	}
	// M�todo que nos avctrh09yuda a actualizar al jugador
	@Override
	public void tick() 
	{	
		// Si la velocidad en y llega a ser menor a 10, entonces se le resta la gravedad para que caiga
		if (velY < 10) velY += gravity;
		// Se revisan las colisiones
		colision();
		
		// Se revisa que no se salga de los l�mites de la ventana
		//if (Game.clampBool(x, 0, Game.width - width - 6)) velX *= -1;
		if (Game.clampBool(y, 0, Game.height - height * 1.9)) {
			//velY *= -1;
		}
		
		// Se actualiza la posici�n en x y en y con respecto a su velocidad
		x += velX;
		y += velY;
	}
	
	// M�todo que se encarga de detectar las colisiones
	@Override
	public void colision() 
	{	
		// Se genera un iterador para revisar todos los objetos
		ListIterator <GameObject> iterator = handler.obj.listIterator();
		while (iterator.hasNext())
		{
			// Se crea un objeto auxiliar
			GameObject aux = iterator.next();
			
			// Si el auxiliar es una pared
			if (aux instanceof Wall)
			{
				// Si hace contacto con la pared en el eje de las x al sumarle la velocidad
				if (placeMeeting(x+velX, y, aux))
				{
					// Se detecta si va a la derecha o a la izquierda el jugador
					int sign = velX > 0? 1: -1;
					// Mientras a�n no est� a un pixel de lejan�a
					while (!placeMeeting(x+sign, y, aux))
						// Se acerca de pixel en pixel a la direcci�n correspondiente
						x+=sign;
					// Hace que la velocidad en x se haga 0 (no rebota)
					velX = 0;
				}
				// Si hace contacto con la pared en el eje de las y al sumarle la velocidad
				if (placeMeeting(x, y+velY, aux))
				{
					
					// Se detecta si va arriba o a abajo el jugador
					int sign = velY > 0? 1: -1;
					// Mientras a�n no est� a un pixel de lejan�a
					while (!placeMeeting(x, y+sign, aux))
						// Se acerca de pixel en pixel a la direcci�n correspondiente
						y+=sign;
					// Hace que la velocidad en x se haga 0 (no rebota)
					velY = 0;
					
				}
				// Si entonces ha tocado piso, rebota
				//if (onFloor()) velY = velBounce;
			}
			// Si el auxiliar es un enemigo
			if (aux instanceof Enemy)
			{
				// Si hace contacto con el enemigo en el eje de las x al sumarle la velocidad
				if (placeMeeting(x+velX, y, aux))
				{
					// Se detecta si va a la derecha o a la izquierda el jugador
					int sign = velX > 0? 1: -1;
					// Mientras a�n no est� a un pixel de lejan�a
					while(!placeMeeting(x + sign, y, aux))
						// Se acerca de pixel en pixel a la direcci�n correspondiente
						x += sign;
					// Remueve al objeto porque hizo contacto
					handler.removeObj(aux);
					// Hace que el jugador rebote
					//velX *= -1;				
					}
			}
		}
	}

	// M�todo que lee las teclas que han sido presionadas
	public void keyPressed(int key) {
		// Si es escape, cierra el juego
		if (key == KeyEvent.VK_ESCAPE) System.exit(1);
		// Si es la flecha izquierda, vuelve la velocidad en x -3
		if (key == KeyEvent.VK_LEFT) {
			velX = -3;
			flagDir=-1;
		}
		// Si es la flecha derecha, vuelve la velocidad en x +3
		if (key == KeyEvent.VK_RIGHT) {
			velX = 3;
			flagDir=1;
		}
		
		// Si la tecla presionada es espacio cambia la distancia de salto
		if (key == KeyEvent.VK_SPACE)
		{
			// Le suma 2 a la velocidad de salto
			if (onFloor()) velY = velBounce;
			//velBounce += 2;
			// Si la velocidad se vuelve -2 (el tope) la regresa a -8
			//if (velBounce == -2) velBounce = -8;
		}
		if (key == KeyEvent.VK_S) {
			spb=new SpawnerB(handler);
			spb.tick(true,(int) x,(int) y);
			this.handler=spb.getHandler();
		}
	}

	public void keyReleased(int key) {
		if (key == KeyEvent.VK_LEFT) {
			velX=0;
			flagDir=0;
		}
		// Si es la flecha derecha, vuelve la velocidad en x +3
		if (key == KeyEvent.VK_RIGHT) {
			velX=0;
			flagDir=0;	
		}
	}

	public void keyTyped(int key) {
	
	}

	@Override
	public void paint(Graphics g) {
		//g.drawImage(image,(int)x,(int)y,width,height, null);
		
	}

	public int getFlagDir() {
		return flagDir;
	}

	public void setFlagDir(int flagDir) {
		this.flagDir = flagDir;
	}

	
	
}
