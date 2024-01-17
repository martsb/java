package Tilecap;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tile extends JLabel implements MouseListener{
	static int size = 16;
	static ArrayList<Tile> all = new ArrayList<Tile>();
	static ArrayList<Tile> captured = new ArrayList<Tile>();
	static Random random = new Random();
	static int num = 1;

	
	Tile(int x, int y) {
		this.setBounds(x, y, size, size);
		this.setOpaque(true);
		this.setBackground(Color.lightGray);
		this.addMouseListener(this);
		all.add(this);
		
		GameScreen.gameScreen.add(this);
	}
	static void generateAll() {
		all = new ArrayList<Tile>();
		captured = new ArrayList<Tile>();
		for (int i = 0; i < Main.SCREEN_WIDTH/Tile.size - 1; i++) {
			for (int j = 0; j < Main.SCREEN_HEIGHT/Tile.size - 2; j++) {
				new Tile(Tile.size*i, Tile.size*j);		
				GameScreen.gameScreen.repaint();
			}
		}
		for (int i = 0; i < Tile.all.size(); i++) {
			if(i % 2 == 1) Tile.all.get(i).setBackground(Color.gray);
		}
		Tile.capture(Tile.all.get(2000));
	}
	static void capture(Tile t) {
		t.setBackground(Color.green);
		captured.add(t);
	}
	static boolean checkLegalMove(Tile t) {
		int presedX = all.indexOf(t) / 48;
		int presedY = all.indexOf(t) % 48;

		for (int i = 0; i < captured.size(); i++) {
			int currentX = all.indexOf(captured.get(i)) / 48;
			int currentY = all.indexOf(captured.get(i)) % 48;
			
			if ((Math.abs(presedX - currentX) <= 1 &&
				 Math.abs(presedY - currentY) == 0) ||
					(Math.abs(presedX - currentX) == 0 &&
					 Math.abs(presedY - currentY) <= 1)) {
				return true;
			}
		}
		return false;
	}
	static int getRandom(int x, int y) {
		return random.nextInt(x, y);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(checkLegalMove(this)) GameScreen.question(this);

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.setBorder(null);
		
	}
}
