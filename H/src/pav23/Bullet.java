package pav23;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JLabel;

public class Bullet extends JLabel{
	int height = 5;
	int width = 5;
	int speed = 10;
	ArrayList<Bullet> all = new ArrayList<>();
	
	public Bullet() {	
		Player p = Screen.player;
		int x = p.getX() + (Player.size - width) / 2;
		int y = p.getY() - speed;
		this.setBounds(x, y, width, speed);
		this.setOpaque(true);
		this.setBackground(Color.white);
		all.add(this);
		Screen.screen.c.add(this);
	}

	public static void create() {
		new Bullet();
	}
	
	
}
