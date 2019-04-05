package gameObject;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ListIterator;

import enemy.Enemy;
import image.Assets;

public class Bullet extends GameObject{
	private int velX;
	private BufferedImage image;
	public Bullet(double x, double y, int width, int height, Handler handler) {
		super(x, y, width, height, handler);
		image=Assets.bullet;
		velX=6;
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(image,(int)x,(int)y,width,height, null);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		x+=velX;
		colision();
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return (new Rectangle(getX(), getY(), width, height));
	}
	
	public void colision(){
		ListIterator <GameObject> iterator = handler.obj.listIterator();
		while (iterator.hasNext()) {
			GameObject aux = iterator.next();
			if (aux instanceof Enemy){
				if (placeMeeting(x+velX, y, aux)){
					System.out.println("intersecto|");
					handler.removeObj(aux);
				}
			}
		}
	}
	
	public boolean placeMeeting (double xr, double yr, GameObject obj){
		if ((new Rectangle((int)xr, (int)yr, width, height)).intersects(obj.getBounds())) 
			return true;
		return false;
	}
	
	public Handler getHandler() {
		return handler;
	}
}
