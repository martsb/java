package BrikBal;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Brick extends JLabel{
	static ArrayList<Brick> all = new ArrayList<Brick>();
	static int count = 0;
    static ImageIcon imageIcon = new ImageIcon("C:\\Users\\Marts Druvis Lauma\\eclipse-workspace\\H\\res\\bord.png");


	Brick(int x, int y) {
		this.setBounds(x, y, 100, 50);
		this.setVisible(true);
		this.setBackground(Color.orange);
		this.setOpaque(true);
		this.setIcon(imageIcon);
		GameScreen.gameScreen.add(this);
	}
	static void createBricks(int difficulty) {
		for (int y = 0; y < difficulty; y++) {
			for (int x = 0; x < 10; x++) {
				all.add(new Brick(50 + (110 * x), 20 + (60 * y)));
				count++;
			}
			GameScreen.gameScreen.repaint();
		}
	}
	static void checkTouch() {
		for (int i = 0; i < all.size(); i++) {
			Rectangle r1 = all.get(i).getBounds();
			Rectangle r2 = GameScreen.ball.getBounds();
			if (r1.intersects(r2)) {
				all.get(i).remove();
				GameScreen.addMoney();
				Ball.diry *= -1;
			}
		}
	}
	void remove() {
		this.setLocation(-100, -100);
		count--;
	//	all.remove(this);
	//	Main.currentScene.remove(this);
	}
}
