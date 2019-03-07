package Characters;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * @className: Dofa 
 * @author: Royer Donnet Arenas Camacho
 * @description: Dofa class models the methods of the main character 
 * @lastEditDate:06/03/2019
 * @lastEdit:BufferedImage and paint 
 * @status: does not move yet but the paint method works fine over the FakeScroll test
 */
public class Dofa extends Character{
    private BufferedImage image;


    public Dofa() {
        super();
    }

    public Dofa(int posX, int posY, int width, int height, int velX, int velY, boolean dir, int life) {
        super(posX,posY,width,height,velX,velY,dir,life);
        try {
        	image=(BufferedImage)ImageIO.read(getClass().getClassLoader().getResource("dofa.png"));
        }catch(IOException e) {
        	e.printStackTrace();
        }
    }

    public BufferedImage getImage() {
        return this.image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public String toString() {
        return (super.toString()+"{" +
            " image='" + getImage() + "'" +
            "}");
    }

	@Override
	public void mover() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void paint(Graphics2D g) {
		g.drawImage(image,posX,posY,width,height,null);
	}
	
	@Override
	public void ataca() {
		// TODO Auto-generated method stub
		
	}
    
    
}