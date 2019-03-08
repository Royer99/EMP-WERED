package Characters;
import java.awt.Graphics2D;

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