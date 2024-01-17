package gam;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JLabel;

public class Supply extends JLabel{
	static ArrayList<Supply> all = new ArrayList<>();
	static int size = 40;
	
	Supply(int x, int y) {
		this.setBounds(x, y, size, size);
		this.setOpaque(true);
		this.setBackground(Color.pink);
		World.world.cont.add(this);
		all.add(this);
	}
	static void generate() {
		for (int i = 0; i < 2; i++) {
			all.add(new Supply(Enemy.getRandom(50, 1150), Enemy.getRandom(300, 500)));	
		}
	}
	static void collect() {
		Rectangle r1 = new Rectangle(World.hero.getX(), World.hero.getY(), Hero.size, Hero.size);
		for (int i = 0; i < Supply.all.size(); i++) {
			Rectangle r2 = new Rectangle(Supply.all.get(i).getX(), Supply.all.get(i).getY(), Supply.size, Supply.size);
			if(r1.intersects(r2)) {
				Supply.all.get(i).setBackground(Color.gray);
			}
			
		}
	}
}
