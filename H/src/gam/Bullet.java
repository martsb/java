package gam;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JLabel;

public class Bullet extends JLabel {
	static int width = 5;
	static int height = 5;
	int speed;
	
	static ArrayList<Bullet> all = new ArrayList<Bullet>();
	Bullet() {
		Hero h = World.hero;
		this.speed = getRandom(20, 23);
		int x = h.getX() + (Hero.size - width) / 2;
		int y = h.getY() - speed;
		this.setBounds(x, y, width, speed);
		this.setOpaque(true);
		this.setBackground(Color.GREEN);
		all.add(this);
		World.world.cont.add(this);
	}
	
	static void create() {
		new Bullet();
	}
	
	static void checkHit() {
		for (int i = 0; i < Bullet.all.size(); i++) { 
			for (int j = 0; j < Enemy.all.size(); j++) {
				int x1 = Bullet.all.get(i).getX();
				int y1 = Bullet.all.get(i).getY();
				int x2 = Enemy.all.get(j).getX();
				int y2 = Enemy.all.get(j).getY();
				if(x1 >= x2 - width && x1 <= x2 + Enemy.size && y1 >= y2 && y1 <= y2+Enemy.size + height) {
					Enemy.all.get(j).setBackground(Color.black);
					Enemy.all.remove(j);
					World.world.addGold();
				}
			}
			if(Bullet.all.get(i).getY() > World.height) Bullet.all.remove(i);
		}
	}
	
	static void moveAll() {
		for (int i=0; i<all.size();i++) {
			Bullet b = all.get(i);
			int z = getRandom(-3, 3);
			int x = b.getX() + z;
			int y = b.getY() - b.speed;
			b.setLocation(x, y);
			if(b.getY() < -10) all.remove(i);
		}
	}
	
	static int getRandom(int min, int max) {
		return (new Random()).nextInt(max-min) + min;
	}
	public Rectangle getBounds() {
	    return new Rectangle(getX(), getY(), width, height);
	}
}
