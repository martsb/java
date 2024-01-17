package Pasaule;

import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.event.MouseInputListener;

import pav23.Screen;

public class Human extends JLabel implements MouseInputListener{
	int size = 32;
	
	Human(int x, int y) {
		this.setBounds(x, y, size, size);
		this.setBackground(Color.black);
		this.setOpaque(true);
		Screens.screen.c.add(this);
//	this.addKeyListener(this);
	}

	public static void create() {
		Screens.human = new Human(600, 600);
	}
	static void moveRandomly() {
		Screens.human.setLocation(Screens.human.getX() + Screens.rndNum(-1, 2), Screens.human.getY() + Screens.rndNum(-1, 2));
	}
	static void moveToPlant() {
		Plant closest = null;
		Integer curDistance = null;
		for (int i = 0; i < Plant.plants.size(); i++) {
			int xDistance = Math.abs(Screens.human.getX()-Plant.plants.get(i).getX());
			int yDistance = Math.abs(Screens.human.getY()-Plant.plants.get(i).getY());
			if (closest == null || xDistance + yDistance < curDistance) {
				closest = Plant.plants.get(i);
				curDistance = xDistance + yDistance;
			}
		}
	}
	static void tryWalking() {
		if(Plant.plants.isEmpty()) moveRandomly();
		else moveToPlant();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("rr");
		
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
