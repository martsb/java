package pav23;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.RepaintManager;
import javax.swing.event.MouseInputListener;

public class Tile extends JLabel implements MouseInputListener{
	static int fps = 600;
	static int size = 16;
	static Color color = Color.gray;
	int x;
	int y;
	boolean isCaptured = false;
	static ArrayList<Tile> all = new ArrayList<>();
	static ArrayList<Tile> captured = new ArrayList<>();
	
	public Tile(int x, int y) {
		this.setBounds(x, y, size, size);
		this.setBackground(color);
		this.setOpaque(true);
		Screen.c.add(this);
		this.addMouseListener(this);
	}
	static void randomCapture() {
		all.get(Screen.screen.getRndNum(0,all.size())).capture();;
	}
	void capture() {
		this.isCaptured = true;
		this.setBackground(Color.green);
		captured.add(this);
		Player.score += 1;
	}
	static void generate() {
		all.add(new Tile(Screen.player.getX(), Screen.player.getY()));
	}
	static void generateAll() {
		for (int i = 0; i < Screen.width/16+1; i++) {
			for (int j = 0; j < Screen.height/16+1; j++) {
					all.add(new Tile(i*16, j*16));
			}
		}
	}
	public void mouseClicked(MouseEvent e) {
		
	}
	public void mousePressed(MouseEvent e) {
		this.capture();
	}
	public void mouseReleased(MouseEvent e) {
		
	}
	public void mouseEntered(MouseEvent e) {
		
	}
	public void mouseExited(MouseEvent e) {
		
	}
	public void mouseDragged(MouseEvent e) {	

	}
	public void mouseMoved(MouseEvent e) {
	
	}
}
