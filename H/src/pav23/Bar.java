package pav23;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.event.MouseInputListener;

public class Bar extends JLabel implements MouseInputListener{
	static int bigHeight = 200;
	static int smallWidth = 200;
	static int smallHeight = 40;
	static ArrayList<Bar> all = new ArrayList<>();
	
	Bar() {
		this.setBounds(0, Screen.height-32, Screen.width, bigHeight);
		this.setBackground(Color.cyan);
		this.setOpaque(true);
		Screen.c.add(this);
	}
	Bar(int x, int y, String text) {
		this.setBounds(x, y, smallWidth, smallHeight);
		this.setBackground(Color.LIGHT_GRAY);
		this.setOpaque(true);
		this.addMouseListener(this);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setText(text);
		Screen.c.add(this);
		all.add(this);
	}
	static void createDefault() {
		new Bar();
	}
	static void createSmall(int x, int y, String text) {
		new Bar(x, y, text);
	}
	static void changeColor() {
		if(Player.money >= Supply.playerSpeedCost) Bar.all.get(0).setBackground(Color.green);
		if(Player.money >= Supply.playerHealthCost) Bar.all.get(1).setBackground(Color.green);
		if(Player.money >= Supply.droneSpeedCost) Bar.all.get(2).setBackground(Color.green);
		if(Player.money < Supply.playerSpeedCost) Bar.all.get(0).setBackground(Color.LIGHT_GRAY);
		if(Player.money < Supply.playerHealthCost) Bar.all.get(1).setBackground(Color.LIGHT_GRAY);
		if(Player.money < Supply.droneSpeedCost) Bar.all.get(2).setBackground(Color.LIGHT_GRAY);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	//	if(e.getSource())
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == Bar.all.get(0)) {
			Player.addSpeed();
		}
		if (e.getSource() == Bar.all.get(1)) {
			Player.addHealth();
		}
		if (e.getSource() == Bar.all.get(2)) {
			Drone.addSpeed();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {	
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}
