package sprite;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import image.Assets;

public class SpriteBuilder {
	private BufferedImage spritesheet;
	private List <BufferedImage> images;
	private int cellW,cellH;
	
	public SpriteBuilder(int cellW,int cellH) {
		spritesheet=Assets.sprite;
		images=new ArrayList<>();
		this.cellH=cellH;
		this.cellW=cellW;
	}
	
	public SpriteBuilder addImage(int i,int j) {
		images.add(spritesheet.getSubimage(i*cellW,j*cellH,cellW, cellH));
		return this;
	}
	
	public CachedSprite build() {
		return new CachedSprite(images);
	}
}
