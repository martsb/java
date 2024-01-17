package rud23;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Tower extends JLabel implements MouseListener{
		ImageIcon towerImage = new ImageIcon("C:\\Users\\Marts Druvis Lauma\\eclipse-workspace\\H\\res\\Tower.png");
		static ArrayList<Tower> all = new ArrayList<Tower>();
		static Tower selectedTower;
		boolean upgraded1 = false;
		boolean upgraded2 = false;
		static int size = 48;
		
	Tower (int x, int y) {
		this.setBounds(x - 20, y - 40, size, size);
		this.setBackground(Color.black);
		this.setOpaque(true);
		this.addMouseListener(this);
		this.setIcon(towerImage);
		Main.currentScreen.add(this);
		all.add(this);
	}
	static void upgrade1() {
		selectedTower.upgraded1 = true;
		bottomGUI.upgradeButton1.setBackground(Color.green);
	}
	static void upgrade2() {
		selectedTower.upgraded2 = true;
		bottomGUI.upgradeButton2.setBackground(Color.green);
	}
	static void remove(Tower t) {
		t.setLocation(-300, -100);
		all.remove(t);
	}
	static void findTarget() {
		for (int i = 0; i < all.size(); i++) {
			if (!Ball.all.isEmpty()) shoot(all.get(i), Ball.all.get(0));
		}
	}
	static void shoot(Tower t, Ball b) {
		new Bullet(t.getX(), t.getY(), b);
	}
	static void select(Tower t) {
		if (selectedTower != null) {
			selectedTower.setBorder(null);
		}
		selectedTower = t;
		t.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.green));
		bottomGUI.upgradeButton1.setVisible(true);
		bottomGUI.upgradeButton2.setVisible(true);
		
		if (selectedTower.upgraded1) {
			bottomGUI.upgradeButton1.setBackground(Color.green);
		} else {
			bottomGUI.upgradeButton1.setBackground(Color.gray);
		}
		if (selectedTower.upgraded2) {
			bottomGUI.upgradeButton2.setBackground(Color.green);
		} else {
			bottomGUI.upgradeButton1.setBackground(Color.gray);
		}
		
		
		GameScreen.gameScreen.repaint();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		select(this);
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

}
