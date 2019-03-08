package Characters;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @NombreDeLaClase: Dofa 
 * @author: Royer Donnet Arenas Camacho
 * @description: Clase Dofa que  hereda los metodos de la clase padre Character 
 * tambien determina la imagen que se debe de cargar 
 * @lastEditDate:08/03/2019
 * @lastEdit:metodo update
 * @status: se mueve parcialmente y se pinta
 */
/**
 * @author royer
 *
 */
/**
 * @author royer
 *
 */
public class Dofa extends Character{
    private BufferedImage image;
    private boolean flag,flag2;



    public Dofa() {
        super();
    }
/**
 * @nombreDeElMetodo Constructor alternativo
 * @author Royer Donnet Arenas Camacho
 * @description construtor alternativo para instancia a dofa, utiliza el super de Character y settea la imagen de dofa
 * @param posX,posY,width,height,velX,velY,dir,life
 * @return
 * @ultimaFechaDeModificacion:07/03/2019
 * @ultimaModificacion:banderas para direccion
 * 
 */
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
    /**
     * @nombreDeElMetodo toString
     * @author Royer Donnet Arenas Camacho
     * @description 
     * @param 
     * @return String con las variables de instancia de Dofa
     * @ultimaFechaDeModificacion:06/03/2019
     * @ultimaModificacion:creacion del metodo
     * 
     */
        public
    public String toString() {
        return (super.toString()+"{" +
            " image='" + getImage() + "'" +
            "}");
    }
    /**
    * @nombreDeElMetodo mover
    * @author Royer Donnet Arenas Camacho
    * @description este metodo recibe una tecla del teclado para poder enceder banderas que se usan en el update
    * @param int key 
    * @return 
    * @ultimaFechaDeModificacion:07/03/2019
    * @ultimaModificacion:creacion del metodo
    * 
    */
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
    /**
     * @nombreDeElMetodo paint
     * @author Royer Donnet Arenas Camacho
     * @description este metodo se encarga de pintar a Dofa con la imagen que se cargo en el constructor alterno
     * @param Graphics2D g
     * @return 
     * @ultimaFechaDeModificacion:07/03/2019
     * @ultimaModificacion:creacion del metodo
     * 
     */    
    public void paint(Graphics2D g) {
		g.drawImage(image,posX,posY,width,height,null);
    }
    /**
     * @nombreDeElMetodo update
     * @author Royer Donnet Arenas Camacho
     * @description este metodo se encarga de actulizar las pos del objeto para simular el movimiento
     * @param 
     * @return 
     * @ultimaFechaDeModificacion:07/03/2019
     * @ultimaModificacion:creacion del metodo
     * 
     */ 
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

	@Override
	public void mover() {
		// TODO Auto-generated method stub
		
	}
    
    
}