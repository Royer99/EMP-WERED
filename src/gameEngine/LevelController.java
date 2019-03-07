package gameEngine;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LevelController  implements KeyListener, MouseListener{
    protected int wwidth;
    protected int wheight;

    public LevelController(){
        wwidth=0;
        wheight=0;
    }
    public LevelController(int wwidth,int wheight){
        this.wwidth=wwidth;
        this.wheight=wheight;
    }

	public int getWwidth(){
        return this.wwidth;
    }
    
    public void setWwidth(int wwidth){
        this.wwidth= wwidth;
    }
    public int getWheight(){
        return this.wheight;
    }
    
    public void setWheight(int wheight){
        this.wheight= wheight;
    }
    public void draw(Graphics2D g){
        g.setColor(Color.BLACK);
        g.fillRect(0,0,wwidth,wheight);
    }
    public void update(){

    }
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}