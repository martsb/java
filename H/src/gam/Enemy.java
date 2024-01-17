package gam;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;

public class Enemy extends JLabel {
	int dir = 0;
	int speed = 8;
	static int size = 30;
	static int fps = 30;
	static ArrayList<Enemy> all = new ArrayList<Enemy>();
	Enemy(int y) {
		this.setBounds(World.width - 50, y, size, size);
		this.setOpaque(true);
		this.setBackground(Color.YELLOW);
		World.world.cont.add(this);
		all.add(this);
	}
	static void checkTouch() {
		Rectangle r1 = new Rectangle(World.hero.getX(), World.hero.getY(), Hero.size, Hero.size);
		for (int i = 0; i < Enemy.all.size(); i++) {
			Rectangle r2 = new Rectangle(Enemy.all.get(i).getX(), Enemy.all.get(i).getY(), Enemy.size, Enemy.size);
			if(r1.intersects(r2)) {
				Enemy.all.get(i).setBackground(Color.black);
				Enemy.all.remove(i);
				World.world.addGold();
			}
			
		}
	}
	static void movement() {
		Thread t = new Thread() {
			public void run() {
				int a = 0;
				while(!World.gameOver) {
					if(a % fps == 0) {
						all.add(new Enemy(getRandom(10, 300)));
					}
					a++;
					moveAll();
					pause(1000 / fps);
				}
			}
			public void moveAll() {
				for (int i=0; i<all.size();i++) {
					Enemy e = all.get(i);
					int y = e.getY() + getRandom(-1, 2);
					int x = e.getX() - e.speed;
					if (x < -e.size) {
						all.remove(e);
						World.world.loseLives();
					}
					e.setLocation(x, y);
					
				}
			}
		};
		t.start();
	}
	
	static int getRandom(int min, int max) {
		return (new Random()).nextInt(max-min) + min;
	}
	
	static void generate() {
		for (int i = 0; i < 2; i++) {
			all.add(new Enemy(getRandom(10, 300)));	
		}
	}
	
	static void pause(int millis) {
		try {
			Thread.sleep(millis);
		} catch (Exception e) {
			System.out.println("Error on pause");
		}
	}

	public static void stun() {
		for (int i = 0; i < all.size(); i++) {
			all.get(i).speed = 1;
		}
		
	}
}
