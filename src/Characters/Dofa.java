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
    private boolean flag,flag2;



    public Dofa() {
        super();
    }

    public Dofa(int posX, int posY, int width, int height, int velX, int velY, boolean dir, int life) {
        super(posX,posY,width,height,velX,velY,dir,life);
        flag=true;
		flag2=false;
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
	public void mover(int Key) {
        if(Key==1) {
			flag=true;
		}else if(Key==2) {
			flag2=true;
		}else if(Key==3) {
			flag=false;
		}else if(Key==4) {
			flag2=false;
		}
    }
        
    public void paint(Graphics2D g) {
		g.drawImage(image,posX,posY,width,height,null);
    }
    
    public void update() {
		if(flag&&flag2) {
			this.posX=posX-velX;
			this.posY=posY-velY;
		}else if(flag&&!flag2) {
			this.posX=posX-velX;
			this.posY=posY+velY;
		}else if(!flag&&flag2) {
			this.posX=posX+velX;
			this.posY=posY-velY;
		}else if(!flag&&!flag2){
			this.posX=posX+velX;
			this.posY=posY+velY;
		}
		
	}
	@Override
	public void ataca() {
		// TODO Auto-generated method stub
		
    }
    public void powerUpCollision(Rectangle r){

    }
    public void onFloor(){
        
    }
    
    
}