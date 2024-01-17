package Tilecap;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
	static Main main;
	static JFrame ekrans;
	static JPanel currentScreen;
	static int DEVIATION = 7;
	static int SCREEN_WIDTH = 1200;
	static int SCREEN_HEIGHT = 800;
	
	public static void main(String[] args) {
		currentScreen = new GameScreen();
		main = new Main();
	}
	Main() {
		ekrans = new JFrame();
		ekrans.setBounds(400, 150, SCREEN_WIDTH, SCREEN_HEIGHT + DEVIATION);
		ekrans.setVisible(true);
		ekrans.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ekrans.setResizable(false);
		ekrans.add(currentScreen);
	}
	static void switchScreen(JPanel newPanel) {
		ekrans.remove(currentScreen);
		currentScreen = newPanel;
		ekrans.add(currentScreen);
		ekrans.revalidate();
		ekrans.repaint();
	}
}
