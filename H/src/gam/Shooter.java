package gam;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Shooter {
	public static void main(String[] args) {
		World world = new World();
	//	startText();
		world.start();

	}
	/*
	static void startText() {
		JButton button = new JButton("Start!");
		button.setBounds(500, 200, 100, 100);
		button.setBackground(Color.white);
		World.world.cont.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				World.world.start();
				button.setVisible(false);
			}
		});
	}        
	 */
	
}
