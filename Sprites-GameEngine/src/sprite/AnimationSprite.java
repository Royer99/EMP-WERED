package sprite;
import java.awt.Graphics;

public class AnimationSprite {
	private int imageIndex;
	private CachedSprite sprite;
	private boolean reachedEnd;
	private int animSpd;
	private int animCount;
	private int topCount;
	private int Sx,Sy;
	private int width,height;
	
	public AnimationSprite(int x, int y,CachedSprite sprite) {
		imageIndex=0;
		this.sprite=sprite;
		System.out.println("Sprites Amount: "+sprite.size());
		Sx=x;
		Sy=y;
	}
	
	public AnimationSprite(int x, int y,CachedSprite sprite,int width,int height) {
		imageIndex=0;
		this.sprite=sprite;
		System.out.println("Sprites Amount: "+sprite.size());
		Sx=x;
		Sy=y;
		this.width=width;
		this.height=height;
	}

	public void setX(int x) {
		Sx = x;
	}

	public void setY(int y) {
		Sy = y;
	}
	
	public void setAnimSpd(int animSpd) {
		this.animSpd = animSpd;
		if(animSpd!=0) {
			topCount=60/animSpd;
			animCount=0;
		}
		reachedEnd=false;
	}
	
	public void update(int x,int y) {
		if(animCount<topCount) {
			animCount++;
			reachedEnd=false;
		}else {
			animCount=0;
			imageIndex=(imageIndex+1)%sprite.size();
			reachedEnd=true;
		}
		setX(x);
		setY(y);
		
	}
	
	public void render(Graphics g,int astroWidth,int astroHeight) {
		if(width!=0) {
			g.drawImage(sprite.get(imageIndex),Sx,Sy,astroWidth,astroHeight,null);
		}else {
			g.drawImage(sprite.get(imageIndex),Sx,Sy,astroWidth,astroHeight,null);
		}
	}
	
	public boolean hasReachedEnd() {
		return reachedEnd;
	}
	
	public void reset() {
		imageIndex=0;
		animCount=0;
	}
}
