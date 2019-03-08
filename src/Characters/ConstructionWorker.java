package Characters;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 
 * @author Ivanramirez
 * @className: ConstructionWorker
 * @description:ConstructionWorker class models the methods of the main character 
 * @lastEditDate:07/03/2019
 * @lastEdit:BufferedImage,paint,mover,morir,ataca, Rectangle,
 * @status: does not move yet but the paint method works fine over the FakeScroll test
 *
 */
public class ConstructionWorker extends Enemy
{
	BufferedImage img;
	Rectangle rect;
	
	public ConstructionWorker(int posX, int posY, int width, int height, int velX, int velY, boolean dir, int life,BufferedImage img,Rectangle rect ) {
		super(posX, posY, width, height, velX, velY, dir, life);
		this.img= img;
		this.rect=rect;
		try {
        	img=(BufferedImage)ImageIO.read(getClass().getClassLoader().getResource("bully.png"));
        }catch(IOException e) {
        	e.printStackTrace();
        }
	}
	


	
	@Override
	public void mover(int key) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void ataca(int key) {
		// TODO Auto-generated method stub
		
	}




	public BufferedImage getImg() {
		return img;
	}




	public void setImg(BufferedImage img) {
		this.img = img;
	}




	public Rectangle getRect() {
		return rect;
	}




	public void setRect(Rectangle rect) {
		this.rect = rect;
	}




	@Override
	public void paint(Graphics2D g) {
		g.drawImage(img,posX,posY,width,height,null);
		
	}
	
	

	


	@Override
	public void ataca() {
		// TODO Auto-generated method stub
		super.ataca();
	}



	@Override
	public void update() {
		// TODO Auto-generated method stub
		super.update();
	}



	@Override
	public void mover() {
		// TODO Auto-generated method stub
		super.mover();
	}



	@Override
	public boolean morir() {
		// TODO Auto-generated method stub
		return super.morir();
	}



	@Override
	public boolean colision(Rectangle rect) 
	{
		if(this.rect.getBounds().intersects(rect.getBounds())) {return true;}
		else {
		return false;}
	}
	
	


}
