package pav23;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JLabel;

public class Wall extends JLabel{
	static final int size = 16;
	static ArrayList<Wall> all = new ArrayList<>();
	
	Wall(int x, int y) {
		this.setBounds(x, y, size, size);
		this.setBackground(Color.black);
		this.setOpaque(true);
		Screen.c.add(this);
		all.add(this);
	}
	static void create() {
		for (int i = 0; i < Screen.width/16-1; i++) {
			for (int j = 0; j < Screen.height/16-2; j++) {
				if(i == 0 || j == 0 || i == Screen.width/16-2|| j == Screen.height/16-3) {
					all.add(new Wall(i*16, j*16));
				}
			}
		}
	}
	static boolean checkTouch(Wall w, int tx, int ty) {
		Rectangle r1 = new Rectangle(Player.x, Player.y, Player.size, Player.size);
		Rectangle r2 = new Rectangle(w.getX() + tx, w.getY() + ty, Wall.size, Wall.size);
		if(r1.intersects(r2)) return true;
		else return false;
	}
}
