package Characters;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ConstructionWorker extends Enemy
{
	private BufferedImage img;

	public ConstructionWorker() 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public ConstructionWorker(int posX, int posY, int width, int height, int velX, int velY, boolean dir, int life) {
		super(posX, posY, width, height, velX, velY, dir, life);
		try {	
			img=(BufferedImage)ImageIO.read(getClass().getClassLoader().getResource("res/images/worker/worker.png"));
        }catch(IOException e) {
        	e.printStackTrace();
        }
	}

	@Override
	public void paint(Graphics2D g) {
		// TODO Auto-generated method stub
		g.drawImage(img,posX,posY,width,height,null);
	}

	@Override
	public void morir(int life) {
		// TODO Auto-generated method stub
		
	}
	
}
