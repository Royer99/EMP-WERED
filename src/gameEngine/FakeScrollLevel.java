package gameEngine;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Characters.Character;
import Characters.Dofa;
import plataforma.Cuadro;
import plataforma.Objeto;
public class FakeScrollLevel extends LevelController{
    private BufferedImage img,img2;
    private int scrollSpd;
    private int b1_xOff;
    private int b2_xOff;
    private Character player;
    private Objeto plataforma;

    public FakeScrollLevel(int wwidth,int wheight){
        super(wwidth,wheight);
        player=new Dofa(200,300,500,500,2,2,true,100); 
        plataforma=new Cuadro(0,600,800,200);
        try{
            img=(BufferedImage)ImageIO.read(getClass().getClassLoader().getResource("metrocdmx.jpg"));
            img2=(BufferedImage)ImageIO.read(getClass().getClassLoader().getResource("metrocdmx.jpg"));
        }catch(IOException e){
            e.printStackTrace();
        }
        scrollSpd=2;
        b1_xOff=0;
        b2_xOff=b1_xOff+img.getWidth();
        
    }
    
	public BufferedImage getImg2() {
		return img2;
	}

	public void setImg2(BufferedImage img2) {
		this.img2 = img2;
	}

	public int getScrollSpd() {
		return scrollSpd;
	}

	public void setScrollSpd(int scrollSpd) {
		this.scrollSpd = scrollSpd;
	}

	public Character getPlayer() {
		return player;
	}

	public void setPlayer(Character player) {
		this.player = player;
	}

	public BufferedImage getImg() {
		return img;
	}
	public void setImg(BufferedImage img) {
		this.img = img;
	}
	public int getB1_xOff() {
		return b1_xOff;
	}
	public void setB1_xOff(int b1_xOff) {
		this.b1_xOff = b1_xOff;
	}
	public int getB2_xOff() {
		return b2_xOff;
	}
	public void setB2_xOff(int b2_xOff) {
		this.b2_xOff = b2_xOff;
	}
   public void draw(Graphics2D g) {
       super.draw(g);
       g.drawImage(img, b1_xOff, 0, null);
       g.drawImage(img, b2_xOff, 0, null);
       player.paint(g);
       plataforma.paint(g);
   }
   public void update(){
       super.update();
       b1_xOff-=scrollSpd;
       b2_xOff-=scrollSpd;
       if(b1_xOff<=(-img.getWidth())){
           b1_xOff=img.getWidth();
       }
       if(b2_xOff<=(-img.getWidth())){
        b2_xOff=img.getWidth();
        }
        player.update();
   		
   }
   public void mouseClicked(MouseEvent e){
       System.out.println("Hello World");
   }
   public void keyPressed(KeyEvent e){
       if(e.getKeyCode()==KeyEvent.VK_LEFT){
           player.mover(1);
       }else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            player.mover(3);
       }else if(e.getKeyCode()==KeyEvent.VK_UP) {
    	   	player.mover(2);
       }else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
    	    player.mover(4);
       }
   }
}
