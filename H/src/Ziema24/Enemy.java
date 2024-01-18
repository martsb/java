package Ziema24;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class Enemy extends JLabel{
	static JLabel enemy;
	static int SIZE = 25;
	static int speed = 1;
	static int velocity = 0;
	static ArrayList<JLabel> list = new ArrayList<JLabel>();
	
	Enemy(int x, int y) {
		enemy = this;
		this.setBounds(x, y, SIZE, SIZE);
		this.setBackground(Color.red);
		this.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.black));
		this.setOpaque(true);
		this.setVisible(true);
		list.add(this);
		Main.panel.add(this);
	}
	static void checkTouch() {
		Rectangle playerRect = new Rectangle(Player.player.getBounds());
		Rectangle enemyRect = new Rectangle(Enemy.enemy.getBounds());
		if (playerRect.intersects(enemyRect)) Enemy.enemy.setBackground(new Color(Main.random.nextInt(0, 256), Main.random.nextInt(0, 256), Main.random.nextInt(0, 256)));
	}
	static void jump() {
		if (Enemy.velocity >= -10) Enemy.velocity -= 5;
	}
	static void move() {
		if (Enemy.enemy.getX() - Player.player.getX() > 0) Enemy.enemy.setLocation(Enemy.enemy.getX() - 1, Enemy.enemy.getY());
		else Enemy.enemy.setLocation(Enemy.enemy.getX() + 1, Enemy.enemy.getY());
	}
	public static boolean hasCollisionsY() {
		for (int i = 0; i < Block.blockList.size(); i++) {
			Rectangle playerRect = new Rectangle(Enemy.enemy.getX(), Enemy.enemy.getY() + velocity, Enemy.SIZE, Enemy.SIZE);
			Rectangle block1Rect = Block.blockList.get(i).getBounds();
			if (playerRect.intersects(block1Rect)) {
				Enemy.velocity = 0;
				return true;
			}
		}
		return false;
	}
	public static boolean hasCollisionsX(int distance) {
		if (Enemy.enemy.getX() - Player.player.getX() > 0) distance = -distance;
		for (int i = 0; i < Block.blockList.size(); i++) {
			Rectangle playerRect = new Rectangle(Enemy.enemy.getX() + distance, Enemy.enemy.getY(), Enemy.SIZE, Enemy.SIZE);
			Rectangle block1Rect = Block.blockList.get(i).getBounds();
			if (playerRect.intersects(block1Rect)) {
				if (Enemy.velocity >= 0) Enemy.jump();
				return true;
			}
		}
		return false;
	}
}
