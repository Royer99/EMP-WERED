import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
public class Dofa extends Character{
    private BufferedImage image;


    public Dofa() {
        super();
    }

    public Dofa(int posX, int posY, int width, int height, int velX, int velY, boolean dir, int life,BufferedImage image) {
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

    public void mover(){

    }
    public void paint(){

    }
    public void ataca(){

    }

}