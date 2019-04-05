package spawner;
import enemy.Enemy;
import gameEngine.Game;
import gameObject.GameObject;
import gameObject.Handler;

//import java.awt.Color;

// Clase encargada de Spawnear enemigos y llevar el control del nivel
public class Spawner {
	// Requiere del Handler para a�adirle a los enemigos
	private Handler handler;
	// Variable para llevar la cuenta del nivel
	private int level;
	// Constructor que requiere del Handler
	public Spawner (Handler handler)
	{
		this.handler = handler;
		// Se inicia el juego en el nivel 1
		level = 1;
		// El nivel 1 inicia con un enemigo
		handler.addObj(new Enemy(360, 50, 60, 40,handler, 1 + level*0.5));
	}
	// M�todo encargado de actualizar el Spawner
	public void tick()
	{
		// Si no tiene ning�n enemigo
		if (!hasEnemy())
		{
			// El nivel de menos tendr� un enemigo
			handler.addObj(new Enemy(360, 50, 60, 40, handler, 1 + level*0.5));
			// Cada 6 niveles a�ade un nuevo enemigo
			for (int i = 0; i < level; i ++)
			{
				handler.addObj(new Enemy(Math.random() * (Game.width - 50) + 0, 50, 60, 40, handler, 1 + (level*0.5)));
			}
			// El nivel incrementa en uno
			level++;
		}
	}
	
	// M�todo que nos ayuda a saber si ya no existen enemigos en el juego
	public boolean hasEnemy()
	{
		// Por cada objeto se revisa si por lo menos hay un enemigo, si lo hay regresa true
		for (GameObject obj: handler.obj) if (obj instanceof Enemy) return true;
		// Si no se enctontr� a lo menos un enemigo, regresa false
		return false;
	}
	public String toString() {
		return("Level:"+level);
	}
}
