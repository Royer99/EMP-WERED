public class Character{
    private int posx;
    private int posy;
    private BufferedImage image;


    public Character() {
    }

    public Character(int posx, int posy, BufferedImage image) {
        this.posx = posx;
        this.posy = posy;
        this.image = image;
    }

    public int getPosx() {
        return this.posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return this.posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    public BufferedImage getImage() {
        return this.image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public Character posx(int posx) {
        this.posx = posx;
        return this;
    }

    public Character posy(int posy) {
        this.posy = posy;
        return this;
    }

    public Character image(BufferedImage image) {
        this.image = image;
        return this;
    }

    public String toString() {
        return "{" +
            " posx='" + getPosx() + "'" +
            ", posy='" + getPosy() + "'" +
            ", image='" + getImage() + "'" +
            "}";
    }
    
}