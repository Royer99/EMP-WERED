package plataforma;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class Objeto {
	protected int posY;
	protected int posX;
	protected int width;
	protected int height;
	protected Rectangle rect;

	public Objeto(int posX,int posY,int width,int height){
		this.posX=posX;
		this.posY=posY;
		this.width=width;
		this.height=height;
	}
	
	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Rectangle getRect() {
		return rect;
	}

	public void setRect(Rectangle rect) {
		this.rect = rect;
	}
	
	public abstract void paint(Graphics2D g);
	
}
