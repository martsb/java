package gam;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import input.KeyboardInputs;
import input.MouseInputs;

public class Panel extends JPanel{
	private MouseInputs mouseInputs;
	private int xDelta = 0, yDelta = 0;
	public Panel() {
		
		mouseInputs = new MouseInputs(this);
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);
	}
	
	public void changeXDelta(int value) {
		this.xDelta += value;
		repaint();
	}
	public void changeYDelta(int value) {
		this.yDelta += value;
		repaint();
	}
	public void setRectPos(int x, int y) {
		this.xDelta = x;
		this.yDelta = y;
		repaint();
	}
		
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.fillRect(xDelta, yDelta, 300, 100);
		g.fillRect(200, 200, 100, 100);

	}
}
