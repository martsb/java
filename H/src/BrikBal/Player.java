package BrikBal;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel implements KeyListener{
	static int PLAYER_WIDTH = 100;
	static int PLAYER_HEIGHT = 20;
	boolean APressed = false;
	boolean DPressed = false;
    static ImageIcon imageIcon = new ImageIcon("C:\\Users\\Marts Druvis Lauma\\eclipse-workspace\\H\\res\\bord.png");

	
	Player() {
		this.setBounds(550, 700, PLAYER_WIDTH, PLAYER_HEIGHT);
		this.setVisible(true);
		this.setBackground(Color.black);
		this.setOpaque(true);
		this.setIcon(imageIcon);
		GameScreen.gameScreen.add(this);	
		Main.jframe.addKeyListener(this);
	}
	static void checkTouch() {
		Rectangle r1 = GameScreen.player.getBounds();
		Rectangle r2 = GameScreen.ball.getBounds();
		if (r1.intersects(r2)) {
			Ball.diry = -1;
		}
	}
	static void moveUp(int d) {
		GameScreen.player.setLocation(GameScreen.player.getX(), GameScreen.player.getY() - d);
	}
	static void move(int d) {
		if (GameScreen.player.getX() < 0) {
			GameScreen.player.setLocation(GameScreen.player.getX() + Math.abs(d), GameScreen.player.getY());
		} else if (GameScreen.player.getX() > Main.SCREEN_WIDTH - Player.PLAYER_WIDTH){
			GameScreen.player.setLocation(GameScreen.player.getX() - Math.abs(d), GameScreen.player.getY());
		} else {
			GameScreen.player.setLocation(GameScreen.player.getX()+d, GameScreen.player.getY());
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {	
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_A) APressed = true;
		if (e.getKeyCode() == KeyEvent.VK_D) DPressed = true;
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.out.println(GameScreen.running);
			if(GameScreen.running == true) {
				GameScreen.pauseGame();
			} else {
				GameScreen.continueGame();
			}
		}
			
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_A) APressed = false;
		if (e.getKeyCode() == KeyEvent.VK_D) DPressed = false;		
	}

}
