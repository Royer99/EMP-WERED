import java.awt.image.BufferedImage;

public class Cuadro extends Objeto {
	private BufferedImage image;

	
	public Cuadro() {
		try {
        	image=(BufferedImage)ImageIO.read(getClass().getClassLoader().getResource("dofa.png"));
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
	
	
}
