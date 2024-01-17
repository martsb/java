package rud23;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Ball extends JLabel {
	static final int BALL_SIZE = 40;
	static int startingX = -40;
	static int startingY = 105;
	String direction;
	Path currectPath;
    static ImageIcon imageIcon = new ImageIcon("C:\\Users\\Marts Druvis Lauma\\eclipse-workspace\\H\\res\\Ball.png");
    static ArrayList<Ball> all = new ArrayList<Ball>();
    Color c=new Color(0f,0f,0f,0f );


	Ball() {
		this.setBounds(startingX, startingY, BALL_SIZE, BALL_SIZE);
		this.setVisible(true);
		this.setBackground(c);
		this.setOpaque(true);
		this.setIcon(imageIcon);
		this.direction = "right";
		this.currectPath = Path.p1;
		all.add(this);
		GameScreen.gameScreen.add(this);
		GameScreen.gameScreen.setComponentZOrder(this, 0);
	}
	static void moveAll() {
		for (int i = 0; i < all.size(); i++) {
			if (all.get(i).direction == "right") all.get(i).setLocation(all.get(i).getX()+1, all.get(i).getY());
			else if (all.get(i).direction == "left") all.get(i).setLocation(all.get(i).getX()-1, all.get(i).getY());
			else if (all.get(i).direction == "up") all.get(i).setLocation(all.get(i).getX(), all.get(i).getY()-1);
			else if (all.get(i).direction == "down") all.get(i).setLocation(all.get(i).getX(), all.get(i).getY()+1);

		}
	}
	static void changeDirection() {
		
	}
	static void checkDirection() {
		for (int i = 0; i < all.size(); i++) {
			if(all.get(i).getX() == 255 && all.get(i).getY() == 105) {
				all.get(i).direction = "down";
				all.get(i).currectPath = Path.p2;
			} else if (all.get(i).getX() == 255 && all.get(i).getY() == 455) {
				all.get(i).direction = "right";
				all.get(i).currectPath = Path.p3;
			} else if (all.get(i).getX() == 705 && all.get(i).getY() == 455) {
				all.get(i).direction = "up";
				all.get(i).currectPath = Path.p4;
			} else if (all.get(i).getX() == 705 && all.get(i).getY() == 155) {
				all.get(i).direction = "right";
				all.get(i).currectPath = Path.p5;
			} else if (all.get(i).getX() >= Main.SCREEN_WIDTH && all.get(i).getY() == 155) {
				all.get(i).setLocation(-100, -100);
				all.remove(i);
				GameScreen.loseLives();
			}
		}
	}
	static void pop(Ball b) {
		b.setLocation(-100, -100);
		all.remove(b);
		GameScreen.changeMoney(GameScreen.random.nextInt(5, 16));
	}
}
