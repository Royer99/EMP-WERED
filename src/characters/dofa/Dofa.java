package characters.dofa;
import java.awt.image.BufferedImage;
public class Dofa extends Character{
    private BufferedImage image;


    public Dofa() {
    }

    public Dofa(BufferedImage image) {
        this.image = image;
    }

    public BufferedImage getImage() {
        return this.image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public String toString() {
        return super.toString()+"{" +
            " image='" + getImage() + "'" +
            "}";
    }

    public void mover(){

    }
    public void paint(){

    }
    public void ataca(){

    }

}