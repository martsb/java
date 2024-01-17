package rud23;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JLabel;

public class Bullet extends JLabel{
	static int size = 16;
	static int BulletSpeed = 5;
	int targetX;
	int targetY;
	int despawnCount = GameScreen.count + 200;
	Ball b;
	static ArrayList<Bullet> all = new ArrayList<Bullet>();
	
	Bullet(int x, int y, Ball b) {
		this.b = b;
		targetX = b.getX();
		targetY = b.getY();
		this.setBounds(x, y, size, size);
		this.setBackground(Color.blue);
		this.setOpaque(true);
		Main.currentScreen.add(this);
		Bullet.all.add(this);
		GameScreen.gameScreen.setComponentZOrder(this, 0);

	}
	static void checkDespawn() {
		for (int i = 0; i < all.size(); i++) {
			if (all.get(i).despawnCount <= GameScreen.count) pop(all.get(i));
		}
	}
	static void moveAllRegular() {
		
	}
	static void moveAllHoming() {
		for (int i = 0; i < all.size(); i++) {
			int cx = all.get(i).getX();
			int cy = all.get(i).getY();
			if (all.get(i).targetX > cx) all.get(i).setLocation(all.get(i).getX() + BulletSpeed, all.get(i).getY());
			if (all.get(i).targetX < cx) all.get(i).setLocation(all.get(i).getX() - BulletSpeed, all.get(i).getY());
			if (all.get(i).targetY > cy) all.get(i).setLocation(all.get(i).getX(), all.get(i).getY() + BulletSpeed);
			if (all.get(i).targetY < cy) all.get(i).setLocation(all.get(i).getX(), all.get(i).getY() - BulletSpeed);
		}
	}
	static void checkCollision() {
			for (int i = 0; i < Bullet.all.size(); i++) {
				int counta = all.size();
				int countb = Ball.all.size();
				for (int j = 0; j < Ball.all.size(); j++) {
					if (counta != all.size() || countb != Ball.all.size()) return;
					Rectangle r1 = Bullet.all.get(i).getBounds();
					Rectangle r2 = Ball.all.get(j).getBounds();
					if (r1.intersects(r2)) {
	
		                if (!Bullet.all.isEmpty()) {
		                    Bullet.pop(Bullet.all.get(i));
		                }
		                if (!Ball.all.isEmpty()) {
		                    Ball.pop(Ball.all.get(j));
		                }
					}
				}
	
			}
		
	}
	static void pop(Bullet b) {
		b.setLocation(-200, -100);
		all.remove(b);

	}
	static void updateTarget() {
		for (int i = 0; i < all.size(); i++) {
			if (!Ball.all.contains(all.get(i).b) && !Ball.all.isEmpty()) all.get(i).b = Ball.all.get(0);
			all.get(i).targetX = all.get(i).b.getX();
			all.get(i).targetY = all.get(i).b.getY();
		}
	}
}
