package BrikBal;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Ball extends JLabel{
	static int dirx = -1;
	static int diry = -1;
	static final int BALL_SIZE = 20;
    static ImageIcon imageIcon = new ImageIcon("C:\\Users\\Marts Druvis Lauma\\eclipse-workspace\\H\\res\\spriteatlas.png");

	
	Ball() {
		this.setBounds(590, 650, BALL_SIZE, BALL_SIZE);
		this.setVisible(true);
		this.setBackground(Color.green);
		this.setOpaque(true);
		this.setIcon(imageIcon);
		GameScreen.gameScreen.add(this);
	}
	void move() {
		if (GameScreen.ball.getX() == 0) 								dirx =  1;
		if (GameScreen.ball.getX() == Main.SCREEN_WIDTH - BALL_SIZE)    dirx = -1;
		if (GameScreen.ball.getY() == 0) 								diry =  1;
		if (GameScreen.ball.getY() == Main.SCREEN_HEIGHT - BALL_SIZE) {
			GameScreen.endGame();
		}
		this.setLocation(this.getX() + dirx, this.getY() + diry);
	}
}
