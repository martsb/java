package gam;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Hero extends JLabel {
	static int speed = 10;
	static int size = 50;
	
	Hero() {
		this.setBounds(500, 500, size, size);
		this.setOpaque(true);
		this.setBackground(Color.white);
		World.world.cont.add(this);
	}
	
	static void create() {
		World.hero = new Hero();
	}
	static void addStun() {
		JButton button = new JButton("Stun!");
		button.setBounds(10, 100, 80, 80);
		button.setBackground(Color.LIGHT_GRAY);
		Font font = new Font("Ariel", Font.BOLD, 15);
		button.setFont(font);
		World.world.cont.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Enemy.stun();
			}
		});
	}
	
	void move() {
		int dirx = 0;
		int diry = 0;
		if (World.leftPressed) dirx = -1;
		if (World.rightPressed) dirx = 1;
		if (World.upPressed) diry = -1;
		if (World.downPressed) diry = 1;
		int x = getX();
		int y = getY();
		x += dirx * speed;
		y += diry * speed;
		if (x > World.width && dirx == 1) {
			x = -size;
		} else if (x < -size && dirx == -1) {
			x = World.width;
		}
		if (y > World.height && diry == 1) {
			y = -size;
		} else if (y < -size && diry == -1) {
			y = World.height;
		}
		setLocation(x, y);
	}
}
