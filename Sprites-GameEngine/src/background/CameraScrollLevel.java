package background;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import image.Assets;

public class CameraScrollLevel{
    private BufferedImage img;
    int nBacks;
    int camX;
    Character player;
    int speed;
    private int wwidth,wheight;


    public CameraScrollLevel(int width, int height){
        img =Assets.background;
        nBacks=8;
        camX=0;
        speed=0;

    }

    public void tick() {
        camX+=speed;
    }

    public void draw(Graphics g){
        g.translate(-camX, 0);

        for (int i=0;i<=nBacks;i++)
        {
        	//g.drawImage(img, i*img.getWidth(), 0, null);
        	g.drawImage(img,i*img.getWidth(), 0,3392,800, null);
        }
    }

    public void mouseClicked(MouseEvent e){
        System.out.println("Hello World");
    }


	public void setSpeed(int speed) {
		this.speed = speed;
	}
    
    
}
