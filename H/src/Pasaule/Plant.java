package Pasaule;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JLabel;

public class Plant extends JLabel {
	int size = 32;
    static ArrayList<Plant> plants = new ArrayList<>();

	
	Plant(int x, int y) {
		this.setBounds(x, y, size, size);
		this.setBackground(Color.GREEN);
		this.setOpaque(true);
		plants.add(this);
		Screens.screen.c.add(this);
//	this.addKeyListener(this);
	}
	static void spawn(int x, int y) {
		new Plant(x, y);
	}
}
