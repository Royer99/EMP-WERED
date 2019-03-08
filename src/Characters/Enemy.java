package Characters;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * 
 * @author Ivanramirez
 * @className: ConstructionWorker
 * @description:ConstructionWorker class models the methods of the main character 
 * @lastEditDate:07/03/2019
 * @lastEdit:BufferedImage,paint,mover,morir,ataca, Rectangle,
 * @status: does not move yet but the paint method works fine over the FakeScroll test
 *
 */

public abstract class  Enemy extends Character{

	private boolean flag=false;
	private boolean flag2=false;
	
	

	public Enemy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Enemy(int posX, int posY, int width, int height, int velX, int velY, boolean dir, int life) {
		super(posX, posY, width, height, velX, velY, dir, life);
		// TODO Auto-generated constructor stub
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public boolean isFlag2() {
		return flag2;
	}

	public void setFlag2(boolean flag2) {
		this.flag2 = flag2;
	}

	

	@Override
	public abstract void paint(Graphics2D g);
	

	@Override
	public void ataca() {
		System.out.println("ataca");
		
	}

	

	@Override
	public void update() 
	{
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
		this.posY=posY+velY;}
	}

	@Override
	public void mover()
	{
		if(flag==false) 
		{
			this.posX+=velX;
			flag=true;
			
		}
		else if(flag==true) 
		{
			this.posX-=velX;
			flag=false;
		}
		
		
	}
	
	public boolean morir () 
	{
		return this.life==0;
	}
	
	public abstract boolean colision(Rectangle rect);

	public void ataca(int key) {
		// TODO Auto-generated method stub
		
	}
		


	

         
}