package window;
import gameEngine.Game;

public class Main {

	public static void main(String[] args) {
		// Se crea el juego, se le da el t�tulo y el tama�o de ventana
				Game game = new Game("Fast Game", 720, 480);
				// Se inicia el juego
				game.start();

	}

}
