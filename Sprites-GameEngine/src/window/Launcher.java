package window;
import gameEngine.Game;

// Clase encargada de ejecutar el juego
public class Launcher {

	public static void main(String[] args) {
		// Se crea el juego, se le da el t�tulo y el tama�o de ventana
		Game game = new Game("Fast Game", 1600, 800);
		// Se inicia el juego
		game.start();
	}

}
