package image;

// Se importan las librer�as a ocupar
import java.awt.image.BufferedImage;

public class Assets {
	
	// Aqu� se cargan todas las im�genes que se requieran en el juego
	// Es est�tico y p�blico dado a que requerimos acceder a ellas desde varias clases
	/*
	 * Ejemplo de BufferedImage con varias im�genes:
	 * public static BufferedImage background, player, cloud, enemy...; 
	*/
	public static BufferedImage background,dofa,ufo,moon,flag,bullet,sprite;
	
	// En �ste m�todo se inicializan todas las i-{m�genes que se van a ocupar
	public static void init()
	{
		// Se hace uso de la clase ImageLoader para cargar la im�gen 
		// (la clase debi� ser creada previamente)
		background = ImageLoader.loadImage("/textures/cdmx.png");
		dofa= ImageLoader.loadImage("/character.png");
		ufo= ImageLoader.loadImage("/ufo.png");
		moon= ImageLoader.loadImage("/brick.png");
		flag= ImageLoader.loadImage("/flag.png");
		bullet=ImageLoader.loadImage("/bullet.png");
		//sprite=ImageLoader.loadImage("/bat/PNG/bat-32x32.png");
		sprite=ImageLoader.loadImage("/MarioSprite.png");
		
	}
}
