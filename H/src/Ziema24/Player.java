package Ziema24;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;

public class Player extends JLabel implements KeyListener{
	
	 static final int SIZE = 32;
	 static JLabel player;
	 static int velocity = 0;
	 static int speed = 5;
	 static boolean leftPressed = false;
	 static boolean rightPressed = false;
	
	Player() {
		player = this;
		player.setBounds(Main.SCREEN_WIDTH / 2, 100, SIZE, SIZE);
		player.setBackground(Color.black);
		player.setOpaque(true);
		player.setVisible(true);
		Main.frame.addKeyListener(this);
		Main.panel.add(this);
	}
	public static boolean hasCollisionsY() {
		for (int i = 0; i < Block.blockList.size(); i++) {
			Rectangle playerRect = new Rectangle(Player.player.getX(), Player.player.getY() + velocity, Player.SIZE, Player.SIZE);
			Rectangle block1Rect = Block.blockList.get(i).getBounds();
			if (playerRect.intersects(block1Rect)) {
				Player.velocity = 0;
				return true;
			}
		}
		return false;
	}
	public static boolean hasCollisionsX(int distance) {
		for (int i = 0; i < Block.blockList.size(); i++) {
			Rectangle playerRect = new Rectangle(Player.player.getX() + distance, Player.player.getY(), Player.SIZE, Player.SIZE);
			Rectangle block1Rect = Block.blockList.get(i).getBounds();
			if (playerRect.intersects(block1Rect)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
 		if (e.getKeyCode() == KeyEvent.VK_ENTER) Main.gamePaused = !Main.gamePaused;
		if (e.getKeyCode() == KeyEvent.VK_SPACE && !Main.gamePaused && Player.velocity == 0) Player.velocity -= 10;
		if (e.getKeyCode() == KeyEvent.VK_A) leftPressed = true;
		if (e.getKeyCode() == KeyEvent.VK_D) rightPressed = true;
		if (e.getKeyCode() == KeyEvent.VK_H) Block.explosion();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_A) leftPressed = false;
		if (e.getKeyCode() == KeyEvent.VK_D) rightPressed = false;		
	}


}
