package input;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import dofa.Dofa;

// Clase encargada de leer la entrada de teclado del usuario
public class KeyInput implements KeyListener{
	// Se crea a qui�n va a ser el escuchador de las teclas
	Dofa player;
	// Se hace el constructor, pas�ndole al escuchador
	public KeyInput(Dofa player) 
	{
		this.player = player;
	}
	// Si una tecla es presionada
	@Override
	public void keyPressed(KeyEvent e) {
		// Se obtiene el c�digo entero de la tecla
		int key = e.getKeyCode();
		// Se le pasa el c�digo al m�todo de tecla presionada del escuchador
		player.keyPressed(key);
	}
	// Si una tecla es liberada
	@Override
	public void keyReleased(KeyEvent e) {
		// Se obtiene el c�digo entero de la tecla
		int key = e.getKeyCode();
		// Se le pasa el c�digo al m�todo de tecla liberada del escuchador
		player.keyReleased(key);
	}

	@Override
	public void keyTyped(KeyEvent e) {		
	}

}
