package Pasaule;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.event.MouseInputListener;

public class Screens extends JFrame implements MouseInputListener{
	public Container c;
	Color color = Color.cyan;
	public static Screens screen;
	static Human human;
	static Random random = new Random();

	
	Screens() {
		super("Gam");
		this.setBounds(250, 20, 1000, 1000);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.c = this.getContentPane();
		this.c.setBackground(color);
		
		this.c.setLayout(null);
		this.setVisible(true);
	//	this.addKeyListener();
		Screens.screen = this;
	}
	public static void start() {
		Human.create();
		screen.addMouseListener(screen);
		loop();
	}
	static void loop() {
		while(true) {
			Human.moveRandomly();
			screen.repaint();
			pause(10);
		}

	}
	static void pause(int s) {
		try {
			Thread.sleep(s);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	static int rndNum(int a, int b) {
		return random.nextInt(a, b);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		Plant.spawn((int)getMousePosition().getX() - 16, (int)getMousePosition().getY() - 32);
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
