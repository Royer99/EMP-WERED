package spawner;
import gameObject.Bullet;
import gameObject.Handler;

public class SpawnerB {
	private Handler handler;
	
	public SpawnerB (Handler handler){
		this.handler = handler;
	}
	
	public void tick(boolean shootflag,int x,int y){
		if(shootflag) {
			handler.addObj(new Bullet(x,y,50,50,handler));
		}
	}
	
	public Handler getHandler() {
		return handler;
	}
}
