package gameEngine;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class Panel1 extends JPanel implements Runnable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int anchop=1600;
    private static final int altop=800;
    private Thread animator;
    private volatile boolean running=false;
    private volatile boolean gameOver=false;
    private Graphics dbg;
    private Image dbimage=null;
    private LevelController level;

    public Panel1(){
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(anchop,altop));
        readyForTermination();
        setFocusable(true);
        requestFocus();
        level=new FakeScrollLevel(anchop,altop);
        //MouseListener 
        addMouseListener(level);
        addKeyListener(level);
    }
    //Notify para que sirve?
    public void addNotify(){
        super.addNotify();
        startGame();
    }
    //inicia el juego con, detecta si el animator esta en null o diferente de corriendo
    public void startGame(){
        if(animator==null||!running){
            animator=new Thread(this);
            animator.start();
            this.setVisible(true);
        }
    }
    //detiene el juego
    public void stopGame(){
        running=false;
    }
    public void run(){
    	long beforeTime,timerDiff,sleepTime,period=30;
    	beforeTime=System.currentTimeMillis();
        running=true;
        while(running){
        	running=true;
        	//System.out.println(col.toString());
        	if(gameOver){
                running=false;
        	}
                gameUpdate();
                gameRender();
                paintScreen();
                timerDiff=System.currentTimeMillis()-beforeTime;
                sleepTime=period-timerDiff;
                System.out.println(sleepTime);
                if(sleepTime<0) {
                	sleepTime=5;
                }
                try {
                	Thread.sleep(sleepTime);
                }catch(InterruptedException ex) {
                
                }
                beforeTime=System.currentTimeMillis();
            /*try{
                Thread.sleep(20);
            }catch(InterruptedException ex){
                System.exit(0);
            }*/
        }	
        //System.exit(0);
    }
    //si diferente de game over mueve pelotas y llama al paint para pintar
    public void gameUpdate(){
        if(!gameOver){
            level.update();
        }
            //repaint();
    }
    /*double buffering, crea una imagen y en caso de que no se pueda imprime dbImage is null,
      en caso de que dbimage sea diferente de null crea procede a double buffering, 
      si el juego termina entonces llama al msg 
    */
    public void gameRender(){
        if(dbimage==null){
            dbimage=createImage(anchop,altop);
            //cuando entra?
            if(dbimage==null){
                System.out.println("dbImage is null");
                return;
            }
        }else{
            dbg=dbimage.getGraphics();
            dbg.setColor(Color.WHITE);
            dbg.fillRect(0, 0, anchop, altop);
        	level.draw((Graphics2D)dbg);
        }
        if(gameOver){
            gameOverMsg(dbg);
            dbg.setColor(Color.BLUE);
            dbg.fillRect(0, 0, anchop, altop);
            dbg.setColor(Color.ORANGE);
            dbg.setFont(new Font("Helvetica", Font.PLAIN, 30));
            dbg.drawString("GAME OVER", 200, 300);
        }
    }
    //imprime game over
    public void gameOverMsg(Graphics dbg){
    	System.out.println("GAME OVER");
    }
    //paint:
    /*public void paint(Graphics g){
    	/*super.paint(g);
    	dbg=dbimage.getGraphics();
        dbg.setColor(Color.RED);
        dbg.fillRect(0, 0, anchop, altop);
        col.paint(g);*/
        
    	
    	//super.paint(g);
    	/*if(dbimage!=null){
    		//System.out.println("no null");
            g.drawImage(dbimage,0,0,null);
        }
        
    }*/
    public void paintScreen() {
    	Graphics g;
    	try {
    		g=this.getGraphics();
    		if(g!=null && dbimage!=null) {
    			g.drawImage(dbimage, 0, 0, null);
    		}
    		Toolkit.getDefaultToolkit().sync();
    		g.dispose();
    	}catch(Exception e) {
    		System.out.println("Graphic content error"+e);
    	}
    }
    public void paint(Graphics g){
    	/*super.paint(g);
    	dbg=dbimage.getGraphics();
        dbg.setColor(Color.RED);
        dbg.fillRect(0, 0, anchop, altop);
        col.paint(g);*/
    	
    	//super.paint(g);
    	if(dbimage!=null){
    		//System.out.println("no null");
            g.drawImage(dbimage,0,0,null);
        }
        
    }
    public void readyForTermination(){
    	
    }
    public void click(int mx,int my){
    	
    }
}
