import java.awt.image.BufferedImage;
public class Dofa extends Character{
    private BufferedImage image;


    public Dofa() {
        super();
    }

    public Dofa(int posX, int posY, int width, int height, int velX, int velY, boolean dir, int life,BufferedImage image) {
        super(posX,posY,width,height,velX,velY,dir,life);
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