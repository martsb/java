package Ziema24;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JLabel;

public class Inventory extends JLabel{
	static JLabel inventory;
	static ArrayList<JLabel> all = new ArrayList<JLabel>();
	static int yLOCATION;
	static final int xLOCATION = 300;
	static final int WIDTH = 600;
	static final int HEIGHT = 300;
	static final int SLOTSIZE = 50;
	static final int topX = 50;
	static final int bottomX = topX + Main.SCREEN_HEIGHT;
	
	Inventory() {
		inventory = this;
		this.setBounds(xLOCATION, yLOCATION, WIDTH, HEIGHT);
		this.setBackground(Color.gray);
		this.setOpaque(true);
		this.setVisible(false);
		Main.panel.add(this);
		Main.panel.setComponentZOrder(this, 1);
	}
	Inventory(int x, int y) {
		x += Inventory.xLOCATION;
		y += Inventory.yLOCATION;
		this.setBounds(x, y, SLOTSIZE, SLOTSIZE);
		this.setBackground(Color.black);
		this.setOpaque(true);
		this.setVisible(false);
		all.add(this);
		Main.panel.add(this);
		Main.panel.setComponentZOrder(this, 0);
	}
	
}
