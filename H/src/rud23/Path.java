package rud23;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JLabel;

public class Path extends JLabel{
	String switchSide;
	int switchX;
	int switchY;
	static ArrayList<Path> all = new ArrayList<Path>();
	static Path p1 = new Path(0, 100, 300, 50, "down", 255, 105);
	static Path p2 = new Path(250, 150, 50, 300, "right", 255, 600);
	static Path p3 = new Path(250, 450, 500, 50, "up", 755, 400);
	static Path p4 = new Path(700, 150, 50, 300, "right", 755, 255);
	static Path p5 = new Path(750, 150, 450, 50, "right", 0, 0);
	
	Path(int x, int y, int width, int height, String switchSide, int switchX, int switchY) {
		JLabel p = new JLabel();
		p.setBounds(x, y, width, height);
		p.setBackground(Color.gray);
		p.setOpaque(true);
		this.switchSide = switchSide;
		this.switchX = switchX;
		this.switchY = switchY;
		GameScreen.gameScreen.add(p);
		all.add(this);
		GameScreen.gameScreen.repaint();
	}

}
