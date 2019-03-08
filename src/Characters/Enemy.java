package Characters;
import java.awt.Graphics2D;

public abstract class  Enemy extends Character{

	public Enemy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Enemy(int posX, int posY, int width, int height, int velX, int velY, boolean dir, int life) {
		super(posX, posY, width, height, velX, velY, dir, life);
		// TODO Auto-generated constructor stub

	}


	@Override
	public abstract void mover();
	

	@Override
	public abstract void paint(Graphics2D g);

	@Override
	public abstract  void ataca();
	
	public abstract void morir(int life);	
	

         
}