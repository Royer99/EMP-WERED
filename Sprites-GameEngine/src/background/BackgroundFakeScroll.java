package background;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import image.Assets;

public class BackgroundFakeScroll {
	 private BufferedImage img,img2;
	    private int scrollSpd;
	    private int b1_xOff;
	    private int b2_xOff;
	    private int wwidth,wheight;
	    
	    public BackgroundFakeScroll(int wwidth,int wheight){
	    	img=Assets.background;
	    	img2=Assets.background;
	    	scrollSpd=10;
	        b1_xOff=0;
	        b2_xOff=b1_xOff+img.getWidth();
	    }
	    
	    public void render(Graphics g) {
	        g.drawImage(img, b1_xOff, 0, null);
	        g.drawImage(img, b2_xOff, 0, null);
	    }
	    
	    public void tick(){
	        b1_xOff-=scrollSpd;
	        b2_xOff-=scrollSpd;
	        if(b1_xOff<=(-img.getWidth())){
	            b1_xOff=img.getWidth();
	        }
	        if(b2_xOff<=(-img.getWidth())){
	         b2_xOff=img.getWidth();
	         }
	    }
}

