package pav23;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JLabel;

public class Supply extends JLabel{
	static int[] costs = {50, 50, 50};
	static ArrayList<Supply> all = new ArrayList<>();
	static int size = 24;
	static int playerSpeedCost = costs[0];
	static int playerHealthCost = costs[1];
	static int droneSpeedCost = costs[2];
	
	Supply() {
		this.setBounds(Screen.screen.getRndNum(32, Screen.width-64), Screen.screen.getRndNum(32, Screen.height-64), size, size);
		this.setBackground(Color.pink);
		this.setOpaque(true);
		Screen.c.add(this);
		all.add(this);
	}
	static void spawn() {
		if(Screen.gameTimeFPS % 200 == 0) all.add(new Supply());
	}
	static void checkTouch() {
		Rectangle r1 = new Rectangle(Screen.player.getX(), Screen.player.getY(), Player.size, Player.size);
		for (int i = 0; i < all.size(); i++) {
			Rectangle r2 = new Rectangle(all.get(i).getX(), all.get(i).getY(), Supply.size, Supply.size);
			if(r1.intersects(r2)) collect(all.get(i));
		}
	}
	static void collect(Supply s) {
	/*	int rnd = Screen.screen.getRndNum(1, 4);
		if (rnd == 1) Player.speed++;
		if (rnd == 2) Drone.speed++;
		if (rnd == 3) {
			Player.health += 50;
			Screen.screen.healthBar.setText("Health: " + Player.health);
		}
				*/
		Player.money+=50;
		s.setLocation(-100, -200);
		all.remove(s);
		Screen.screen.moneyBar.setText("Money: " + Player.money);

	}
}
