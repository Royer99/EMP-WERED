/**
 * @className: Bullet 
 * @author: Royer Donnet Arenas Camacho
 * @description: Bullet class models the superclass for the enemies and dofa bullets   
 * @lastEditDate:07/03/2019
 * @lastEdit: 
 * @status: 
 */
public class Bullet {
	private int posX;
	private int posY;
	private int width;
	private int height;
	private int velX;
	private int velY;
	
	public Bullet(int posX, int posY, int width, int height, int velX, int velY) {
		super();
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.height = height;
		this.velX = velX;
		this.velY = velY;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
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

	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}
	
	public String toString() {
		return ("posX"+posX+"posY"+posY+"width"+width+"height"+height+"velX"+velX+"velY"+velY);
	}
	
	
}
