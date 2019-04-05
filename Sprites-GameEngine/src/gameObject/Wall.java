package gameObject;
//import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import image.Assets;

// Clase Pared (En caso de tener varias, �sta puede ser abstracta)
public class Wall extends GameObject{
	private BufferedImage image;
	// Constructor que recibe los atributos de un GameObject
	public Wall(double x, double y, int width, int height,Handler handler){
		super (x,y,width,height,handler);
		image=Assets.moon;
	}
	
	// La pared solo requiere ser pintada
	@Override
	public void paint(Graphics g){
		// Se le da un color
		// Se pinta el rect�ngulo de la pared
		// En �ste caso ha sido comentado, ya que el background nos ayuda visualmente
		//g.fillRect(getX(), getY(), width, height);
		//g.drawImage(image,(int)x,(int)y,width,height, null);

	}
	
	// La pared no requiere actualizar nada (posici�n, color y tama�o se mantienen constantes)
	@Override
	public void tick() {}
	
	// Obtiene los bordes de la pared (nos ayuda con las colisiones)
	@Override
	public Rectangle getBounds(){
		return (new Rectangle(getX(), getY(), width, height));
	}
}
