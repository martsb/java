package BrikBal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameScreen extends JPanel implements Runnable{
	static int money = 0;
	int difficulty;
	static Random random = new Random();
	static JLabel moneyCounter = new JLabel();
	static Player player;
	static Ball ball;
	static Main main;
	static GameScreen gameScreen;
	static Thread threade;
    static volatile boolean running = true;
    static boolean botEnabled = false;


	public GameScreen(int difficulty) {	
		this.difficulty = difficulty;
		gameScreen = this;
		this.setLayout(null);
		this.setBackground(Color.cyan);
		Brick.all = new ArrayList<Brick>();
		createThings();
		startGame();
		System.out.println(running);
	}
	static void moveBot() {
		GameScreen.player.setLocation(GameScreen.ball.getX(), GameScreen.player.getY());
	}
	static void endGame() {
		GameScreen.running = false;
		threade = null;
		Main.switchScene(new MenuScreen());
		Brick.count = 0;
	}
	static void startGame() {
		threade = null;
		running = true;
		threade = new Thread(gameScreen);
		threade.start();
	}
	static void pauseGame() {
		running = false;
		threade = null;
	}
	static void continueGame() {
		threade = null;
		running = true;
		threade = new Thread(gameScreen);
		threade.start();
	}
	
	void createThings() {
		createMoneyCounter();
		player = new Player();
		ball = new Ball();
		Brick.createBricks(difficulty);
	}
	static void checkWin() {
		if (Brick.count == 0) {
			endGame();
		}
	}
	static void addMoney() {
		money++;
		moneyCounter.setText("Money: " + money);
	}
	void createMoneyCounter() {
		Font font = new Font("sans-serif", Font.BOLD, 24);
		moneyCounter.setBounds(20, 20, 150, 50);
		moneyCounter.setVisible(true);
		moneyCounter.setFont(font);
		moneyCounter.setText("Money: " + money);
		add(moneyCounter);
	}

	static void pause(int s) {
		try {
			Thread.sleep(s);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	static int getRandom(int x, int y) {
		return random.nextInt(x, y);
	}
	@Override
	public void run() {
		int count = 0;
		while(running) {
			Player.checkTouch();
			ball.move();
			if (botEnabled) moveBot();
			if (player.APressed) Player.move(-2);
			if (player.DPressed) Player.move(2);
			if (count % 10 == 0) Brick.checkTouch();
			if (count % 200 == 0) checkWin();
			if (count % 200 == 0) Player.moveUp(difficulty);
			Main.jframe.repaint();
			count++;
			pause(1);
		}
	}
		
}
