package pav23;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.LinkedList;

import javax.swing.JLabel;

public class Enemy extends JLabel{
	static int speed = 1;
	static int size = 30;
	boolean isDead = false;
	static LinkedList<Enemy> all = new LinkedList<Enemy>();
	Enemy(int x, int y) {
		this.setBounds(x, y, size, size);
		this.setOpaque(true);
		this.setBackground(Color.red);
		Screen.c.add(this);
		all.add(this);
	}
	Enemy() {
		this.setBounds(Screen.width/2, Screen.height/2, size, size);
	}
	static void checkDroneTouch() {
		Rectangle r1 = new Rectangle(Screen.human.getX(), Screen.human.getY(), Drone.size, Drone.size);
		for (int i = 0; i < Enemy.all.size(); i++) {
			Rectangle r2 = new Rectangle(Enemy.all.get(i).getX(), Enemy.all.get(i).getY(), Enemy.size, Enemy.size);
			if(r1.intersects(r2)) {
				Enemy.all.get(i).setLocation(-100, -100);
				Enemy.all.get(i).isDead = true;
				Screen.c.remove(Enemy.all.get(i));
				Enemy.all.remove(Enemy.all.get(i));
				Enemy.all.get(i).disable();
				Player.addScore();
				Player.money++;
				System.out.println("Money: " + Player.money);
				Screen.screen.moneyBar.setText("Money: " + Player.money);

			}		
		}
	}
	static void checkPlayerTouch() {
		Rectangle r1 = new Rectangle(Screen.player.getX(), Screen.player.getY(), Player.size, Player.size);
		for (int i = 0; i < Enemy.all.size(); i++) {
			Rectangle r2 = new Rectangle(Enemy.all.get(i).getX(), Enemy.all.get(i).getY(), Enemy.size, Enemy.size);
			if(r1.intersects(r2)) {
				if(Player.health > 0) Screen.player.loseHealth();
				System.out.println("Health: " + Player.health);
			}			
		}
	}
	static void checkTileTouch() {
		for (int i = 0; i < Tile.all.size(); i++) {
			Rectangle r1 = new Rectangle(Tile.all.get(i).getX(), Tile.all.get(i).getY(), Tile.size, Tile.size);
			for (int j = 0; j < Enemy.all.size(); j++) {
				Rectangle r2 = new Rectangle(Enemy.all.get(j).getX(), Enemy.all.get(j).getY(), Enemy.size, Enemy.size);
				if(r1.intersects(r2)) {
					Tile.all.get(i).setLocation(-200, -100);
				}
			}
		}
	}
	static void spawn() {
		if(Screen.gameTimeFPS % Screen.spawnDelay == 0) {
			if(Screen.spawnDelay>5) Screen.spawnDelay-=1;
			int rnd = Screen.screen.getRndNum(1, 5);
			if (rnd == 1) all.add(new Enemy(Screen.width-64, Screen.screen.getRndNum(32, Screen.height-96)));	
			if (rnd == 2) all.add(new Enemy(0, Screen.screen.getRndNum(32, Screen.height-96)));	
			if (rnd == 3) all.add(new Enemy(Screen.screen.getRndNum(32, Screen.width-96), Screen.height-64));	
			if (rnd == 4) all.add(new Enemy(Screen.screen.getRndNum(32, Screen.width-96), 0));				
		}
	}
	static void move() {
		for (int i = 0; i < Enemy.all.size(); i++) {
			if(!Enemy.all.get(i).isDead) {
				int dirX = 0;
				int dirY = 0;
				if(Enemy.all.get(i).getX() < Screen.player.getX()) dirX = 1 * speed;
				if(Enemy.all.get(i).getX() > Screen.player.getX()) dirX = -1 * speed;
				if(Enemy.all.get(i).getY() < Screen.player.getY()) dirY = 1 * speed;
				if(Enemy.all.get(i).getY() > Screen.player.getY()) dirY = -1 * speed;
				Enemy.all.get(i).setLocation(Enemy.all.get(i).getX()+dirX, Enemy.all.get(i).getY()+dirY);
			}
		}
	}
}
