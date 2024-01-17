package rud23;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main implements MouseListener{
	static Main main;
	static JFrame ekrans;
	static JPanel currentScreen = new JPanel();
	static int SCREEN_WIDTH = 1200;
	static int SCREEN_HEIGHT = 800;
	
	public static void main(String[] args) {
		currentScreen = new MenuScreen();
		main = new Main();
	}
	Main() {
		ekrans = new JFrame("Anti - Tower Defense???");
		ekrans.setBounds(400, 150, SCREEN_WIDTH, SCREEN_HEIGHT);
		ekrans.setVisible(true);
		ekrans.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ekrans.setResizable(false);
		ekrans.addMouseListener(this);
		ekrans.add(currentScreen);

	}
	static void switchScreen(JPanel newScreen) {
        ekrans.remove(currentScreen);
        currentScreen = newScreen;
        ekrans.add(currentScreen);
        ekrans.revalidate();
        ekrans.repaint();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		GameScreen.spawnTower(e.getX(), e.getY());
		currentScreen.repaint();
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
