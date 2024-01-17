package gam;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class World extends JFrame implements KeyListener {
	Container cont;
	boolean playing;
	static int fps = 50;
	static int width = 1200;
	static int height = 600;
	static int gold = -1;
	static int lives = 100;
	static World world;
	static Hero hero;
	static boolean leftPressed = false;
	static boolean rightPressed = false;
	static boolean upPressed = false;
	static boolean downPressed = false;
	static boolean canShoot = true;
	static boolean gameOver = false;
	JLabel money = new JLabel();
	JLabel health = new JLabel();
	World() {
		super("Shooter");
		this.setBounds(250, 100, width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.cont = this.getContentPane();
		this.cont.setBackground(Color.decode("#023151"));
		this.cont.setLayout(null);
		this.addKeyListener(this);
		this.setVisible(true);
		World.world = this;
	//	Hero.addStun();
		money = goldCounter();
		health = livesCounter();
	}
	void start() {
		Hero.create();
		Enemy.movement();
		this.play();
	}
	
	void play() {
		while(!gameOver) {
			
			checkGameOver();
			hero.move();
			Bullet.moveAll();
			Bullet.checkHit();
			Enemy.checkTouch();
			cont.repaint();
			pause(1000 / World.fps);
		}
	}
	void loseLives() {
		lives--;
		health.setText("Lives: " + lives);
	}
	JLabel livesCounter() {
		Font font = new Font("sans-serif", Font.PLAIN, 44);
		JLabel counter = new JLabel("Lives: " + lives);
		counter.setFont(font);
		counter.setForeground(Color.red);
		counter.setBounds(20, 40, 260, 40);
		cont.add(counter);
		return counter;
	}
	void addGold() {
		gold ++;
		money.setText("Gold: " + gold + "/10");
	}
	JLabel goldCounter() {
		Font title = new Font("sans-serif", Font.PLAIN, 44);
		JLabel header = new JLabel("Gold: 0/10");
		header.setForeground(Color.yellow);
		header.setFont(title);
		header.setBounds(900, 40, 260, 40);
		cont.add(header);	
		return header;
	}
	void checkGameOver() {
		if(gold >= 10 || lives <= 0) {
			this.cont.setBackground(Color.gray);
			Font title = new Font("sans-serif", Font.BOLD, 44);
			String text;
			if(lives <= 0) text = "YOU LOSE!";
			else text = "YOU WIN!";
			JLabel header = new JLabel(text);
			header.setForeground(Color.yellow);
			header.setFont(title);
			header.setBounds(500, 40, 260, 40);
			header.setBackground(Color.decode("#4398b9"));
			cont.add(header);
			gameOver = true;
		}
		
	}
	static void pause(int millis) {
		try {
			Thread.sleep(millis);
		} catch (Exception e) {
			System.out.println("Error on pause");
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			leftPressed = true;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rightPressed = true;
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			upPressed = true;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			downPressed = true;
		} else if(e.getKeyCode() == KeyEvent.VK_C) {
				Bullet.width *=2;
		} else if (e.getKeyCode() == KeyEvent.VK_SPACE && canShoot == true) {
			Bullet.create();
			canShoot = false;
		} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			Enemy.all.removeAll(Enemy.all);
		}
		
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			leftPressed = false;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rightPressed = false;
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			upPressed = false;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			downPressed = false;
		} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			canShoot = true;
		}
	}
}
