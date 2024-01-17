package BrikBal;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
	static final int SCREEN_WIDTH = 1200;
	static final int SCREEN_HEIGHT = 800;
	static JFrame jframe = new JFrame("BrikBal++++++");
	static JPanel panel = new JPanel();
	static JPanel currentScene;

	public static void main(String[] args) {
		new Main();
	}
	
	Main() {
		currentScene = new MenuScreen();
		createMainScreen();
	}
	static void createMainScreen() {
		jframe.setBounds(400, 100, SCREEN_WIDTH, SCREEN_HEIGHT);
		jframe.setVisible(true);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setResizable(false);
		jframe.add(currentScene);
	}


    static void switchScene(JPanel newScene) {
        jframe.remove(currentScene);
        currentScene = newScene;
        jframe.add(currentScene);
        jframe.revalidate();
        jframe.repaint();
    }
}
//ddd
	