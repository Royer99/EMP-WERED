package Characters;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Dad extends Enemy
{
	BufferedImage img;
	Rectangle rect;
	
	
	@Override
	public void mover() {
		// TODO Auto-generated method stub
		super.mover();
	}

	@Override
	public void morir(int life) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void paint(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void ataca() {
		// TODO Auto-generated method stub
		super.ataca();
	}

	
	

	

	
	
	//SETTERS AND GETTERS
	
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
	public int getPosX() {
		// TODO Auto-generated method stub
		return super.getPosX();
	}

	@Override
	public void setPosX(int posX) {
		// TODO Auto-generated method stub
		super.setPosX(posX);
	}

	@Override
	public int getPosY() {
		// TODO Auto-generated method stub
		return super.getPosY();
	}

	@Override
	public void setPosY(int posY) {
		// TODO Auto-generated method stub
		super.setPosY(posY);
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return super.getWidth();
	}

	@Override
	public void setWidth(int width) {
		// TODO Auto-generated method stub
		super.setWidth(width);
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return super.getHeight();
	}

	@Override
	public void setHeight(int height) {
		// TODO Auto-generated method stub
		super.setHeight(height);
	}

	@Override
	public int getVelX() {
		// TODO Auto-generated method stub
		return super.getVelX();
	}

	@Override
	public void setVelX(int velX) {
		// TODO Auto-generated method stub
		super.setVelX(velX);
	}

	@Override
	public int getVelY() {
		// TODO Auto-generated method stub
		return super.getVelY();
	}

	@Override
	public void setVelY(int velY) {
		// TODO Auto-generated method stub
		super.setVelY(velY);
	}

	@Override
	public boolean isDir() {
		// TODO Auto-generated method stub
		return super.isDir();
	}

	@Override
	public boolean getDir() {
		// TODO Auto-generated method stub
		return super.getDir();
	}

	@Override
	public void setDir(boolean dir) {
		// TODO Auto-generated method stub
		super.setDir(dir);
	}

	@Override
	public int getLife() {
		// TODO Auto-generated method stub
		return super.getLife();
	}

	@Override
	public void setLife(int life) {
		// TODO Auto-generated method stub
		super.setLife(life);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
}
