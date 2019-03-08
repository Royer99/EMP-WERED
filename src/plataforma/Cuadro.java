package plataforma;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Cuadro extends Objeto {
	private BufferedImage image;

	
	public Cuadro(int posX,int posY,int width,int height) {
		super(posX,posY,width,height);
		try {
        	image=(BufferedImage)ImageIO.read(getClass().getClassLoader().getResource("block.png"));
        }catch(IOException e) {
        	e.printStackTrace();
        }
	}


	public BufferedImage getImage() {
		return image;
	}


	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
	public void paint(Graphics2D g){
		g.drawImage(image,posX,posY,width,height,null);
	}
}
