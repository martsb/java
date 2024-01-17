package pav23;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JLabel;

import gam.World;

public class Player extends JLabel{
	static final int size = 32;
	static int speed = 3;
	static int money = 0;
	static int score = 0;
	static int health = 100;
	static int x = Screen.width/2;
	static int y = Screen.height/2;
	
	Player() {
		this.setBounds(x, y, size, size);
		this.setBackground(Color.yellow);
		this.setOpaque(true);
		Screen.c.add(this);
	}
	static void addSpeed() {
		if(Player.money >= Supply.playerSpeedCost && !Screen.gameOver) {
			Player.speed++;
			Player.money -= Supply.playerSpeedCost;
			Screen.screen.moneyBar.setText("Money: " + Player.money);
			Supply.playerSpeedCost *= 1.1;
			Bar.all.get(0).setText(Supply.playerSpeedCost + "$     Add player speed (1)");
		}
	}
	static void addHealth() {
		if(Player.money >= Supply.playerHealthCost && !Screen.gameOver) {
			Player.health +=50;
			Player.money -= Supply.playerHealthCost;
			Screen.screen.healthBar.setText("Health: " + Player.health);
			Screen.screen.moneyBar.setText("Money: " + Player.money);
			Supply.playerHealthCost *= 1.1;
			Bar.all.get(1).setText(Supply.playerHealthCost + "$     Add player health (2)");
		}
	}
	static void checkLegalPosition() {
		if(Screen.player.getX() < 0 		   ||
		   Screen.player.getY() < 0 		   ||
		   Screen.player.getX() > Screen.width ||
		   Screen.player.getY() > Screen.height) 
			Screen.player.loseHealth();
	}
	static void addScore() {
		score++;
		Screen.screen.scoreBar.setText("Score: " + score);
	}
	void loseHealth() {
		health--;
		Screen.screen.healthBar.setText("Health: " + health);
	}
	static void create() {
		Screen.player = new Player();
	}
	static void shoot() {
		
	}
	static void touch() {
		Rectangle r1 = new Rectangle(x, y, size, size);
		for (int i = 0; i < Tile.all.size(); i++) {
			if(!Tile.all.get(i).isCaptured) {
				Rectangle r2 = new Rectangle(Tile.all.get(i).getX(), Tile.all.get(i).getY(), Tile.size, Tile.size);
				if(r1.intersects(r2)) Tile.all.get(i).capture();
			}
		}
	}
	void move() {
		int dirx = 0;
		int diry = 0;
		if (Screen.leftPressed) dirx = -1;
		if (Screen.rightPressed) dirx = 1;
		if (Screen.upPressed) diry = -1;
		if (Screen.downPressed) diry = 1;
		int x = getX();
		int y = getY();
		x += dirx * speed;
		y += diry * speed;
		setLocation(x, y);
	}
} 
