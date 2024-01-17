package rud23;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class GameScreen extends JPanel implements Runnable{
	static GameScreen gameScreen;
	static JLabel roundCounter;
	static JLabel moneyCounter;
	static JLabel livesCounter;
	static Thread threade;
	static Round currectRound = Round.r1;
	static Random random = new Random();
	static int currentRoundNumber = 0;
	static int money = 150;
	static int lives = 10;
	static int count = 0;
	static int towerAttackCooldown = 200;
	
	public GameScreen() {
		gameScreen = this;
		this.setLayout(null);
		this.setBackground(Color.cyan);
		roundCounter = createCounter(20, 20, "Round: " + (currentRoundNumber + 1));
		moneyCounter = createCounter(Main.SCREEN_WIDTH - 250, 20, "Money: " + money);
		livesCounter = createCounter(Main.SCREEN_WIDTH - 250, 70, "Lives: " + lives);
		new bottomGUI();
		threade = new Thread(gameScreen);
		threade.start();
	}
	
	JLabel createCounter(int x, int y, String text) {
		Font font = new Font("sans-serif", Font.PLAIN, 44);
		JLabel counter = new JLabel(text);
		counter.setFont(font);
		counter.setBackground(Color.cyan);
		counter.setForeground(Color.red);
		counter.setBounds(x, y, 250, 40);
		counter.setOpaque(true);
		GameScreen.gameScreen.add(counter);
		return counter;
	}	
	

	
	static void loseLives() {
		lives--;
		livesCounter.setText("Lives: " + lives);	
	}
		
	public static void changeMoney(int i) {
		money += i;
		moneyCounter.setText("Money: " + money);
	}

	static void checkGameOver() {
		if (lives <= 0) System.exit(0);
	}

	static void spawnTower(int x, int y) {
		if (money >= 100 && y < Main.SCREEN_HEIGHT - bottomGUI.OPTION_PANEL_HEIGHT) {
			new Tower(x, y);
			changeMoney(-100);
		}
	}
	
	static void pause(int s) {
		try {
			Thread.sleep(s);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while(true) {
			if (count % currectRound.spawnCooldown == 0 && currectRound.ballCount != 0) {
				new Ball();
				currectRound.ballCount--;
			}
			if (currectRound.ballCount == 0 && Ball.all.isEmpty()) {
				currectRound = Round.all.get(currentRoundNumber);
				GameScreen.currentRoundNumber++;
				roundCounter.setText("Round: " + currentRoundNumber);
				if (currentRoundNumber >= Round.all.size()) GameScreen.currentRoundNumber = 0;
				
			}
			if (count % towerAttackCooldown == 0) Tower.findTarget();
			checkGameOver();
			Bullet.moveAllHoming();
			Bullet.checkCollision();
			Bullet.updateTarget();
			Bullet.checkDespawn();
			Ball.moveAll();
			Ball.checkDirection();
			count++;
			pause(2);
		}
	}

}
