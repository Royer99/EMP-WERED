import java.awt.BorderLayout;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;

import gameEngine.Panel1;
/**
 * 
 * @author royer
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Panel1 game=new Panel1();
		JFrame app=new JFrame("Game Animation");
		app.setSize(1600, 800);
		app.getContentPane().add(game,BorderLayout.CENTER);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.pack();
		app.setResizable(false);
		app.setVisible(true);
		ExecutorService pool= Executors.newFixedThreadPool(2);
		pool.execute(game);
		game.addNotify();
		pool.shutdown();
	}


}
