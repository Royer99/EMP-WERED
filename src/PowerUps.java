import java.awt.Graphics2D;

public abstract class PowerUps {
	protected int posX;
	protected int PosY;
	protected int width;
	protected int height;


	public PowerUps() {
	}

	public PowerUps(int posX, int PosY, int width, int height) {
		this.posX = posX;
		this.PosY = PosY;
		this.width = width;
		this.height = height;
	}

	public int getPosX() {
		return this.posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return this.PosY;
	}

	public void setPosY(int PosY) {
		this.PosY = PosY;
	}

	public int getWidth() {
		return this.width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return this.height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String toString() {
		return "{" +
			" posX='" + getPosX() + "'" +
			", PosY='" + getPosY() + "'" +
			", width='" + getWidth() + "'" +
			", height='" + getHeight() + "'" +
			"}";
	}
	
	public abstract void paint(Graphics2D g);

}
