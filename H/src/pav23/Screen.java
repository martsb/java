package pav23;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.event.MouseInputListener;

public class Screen extends JFrame implements KeyListener{
	Color color = Color.decode("#ADD8E6");
	static Container c = new Container();
	Random random = new Random();
	static Screen screen;
	static Player player;
	static Drone human;
	JLabel healthBar;
	JLabel scoreBar;
	JLabel moneyBar;
	Bar b = new Bar();
	static JLayeredPane layeredPane = new JLayeredPane();
	
	static int fpsCounter = 0;
	static int gameTimeFPS = 0;
	static int droneX = Screen.width/2+20; 
	static int droneY = Screen.height/2-20;
	static int fps = 60;
	static int spawnDelay = 100;
	static final int height = 800;
	static final int width = 1200;

	static boolean gamePaused = false;
	static boolean gameOver = false;
	static boolean leftPressed = false;
	static boolean rightPressed = false;
	static boolean upPressed = false; 
	static boolean downPressed = false;
	
	Screen() {
		super("Gam");
		this.setBounds(250, 20, width, height + Bar.bigHeight);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		c = this.getContentPane();
		c.setBackground(color);
		color = Color.black;
		
		c.setLayout(null);
		this.addKeyListener(this);
		this.setVisible(true);
		Screen.screen = this;
		
		scoreBar = scoreCounter();
		healthBar = healthCounter();
		moneyBar = moneyCounter();
	}	


	void open() {
		Bar.createSmall(50, 785, Supply.playerSpeedCost + "$     Add player speed (1)");
		Bar.createSmall(50, 845, Supply.playerHealthCost + "$     Add player health (2)");
		Bar.createSmall(50, 905, Supply.droneSpeedCost + "$     Add drone speed (3)");
		Bar.createDefault();
		Drone.create();
		Player.create();
		Wall.create();
	//	Tile.generate();
		this.play();
		System.out.println("weewewwe");
		getFPS();
	}


	void play() {
		while(!gameOver && !gamePaused) {
			checkGameOver();
		//	drone.move();
			human.move2Enemy(new Enemy());
			Enemy.spawn();
			Enemy.move();
			Enemy.checkDroneTouch();
			Enemy.checkPlayerTouch();
			Enemy.checkTileTouch();
			player.move();
			Player.touch();
			Player.checkLegalPosition();
			Supply.spawn();
			Supply.checkTouch();
			Bar.changeColor();
			c.repaint();
			gameTimeFPS++;
			pause(1000 / fps);
			if (gamePaused) pause(1000);
		}
	}
	private void getFPS() {
		countFPS();
		for(;;) {
			pause(1000);
			System.out.println("FPS: " + fpsCounter);
			fpsCounter = 0;
		}
	}
	private void countFPS() {
		for(;;) {
			fpsCounter++;
		}
	}

	JLabel moneyCounter() {
		Font font = new Font("sans-serif", Font.PLAIN, 44);
		JLabel counter = new JLabel("Money: " + Player.money);
		counter.setFont(font);
		counter.setForeground(Color.red);
		counter.setBounds(900, 90, 260, 40);
		c.add(counter);
		return counter;
	}
	 JLabel scoreCounter() {
		Font font = new Font("sans-serif", Font.PLAIN, 44);
		JLabel counter = new JLabel("Score: " + Player.score);
		counter.setFont(font);
		counter.setForeground(Color.red);
		counter.setBounds(900, 40, 260, 40);
		c.add(counter);
		return counter;
	}
	JLabel healthCounter() {
		Font font = new Font("sans-serif", Font.PLAIN, 44);
		JLabel counter = new JLabel("Health: " + Player.health);
		counter.setFont(font);
		counter.setForeground(Color.red);
		counter.setBounds(20, 40, 260, 40);
		c.add(counter);
		return counter;
	}
	void checkGameOver() {
		if(Player.health <= 0) {
			gameOver = true;
			System.out.println("Game over!");
			System.out.println("Score: " + Player.score);
		}
	}
	public static void pause(int t) {
		try {
			Thread.sleep(t);
		} catch (InterruptedException e) {
			System.out.println("Pause error!");
			e.printStackTrace();
		}
	}
	int getRndNum(int a, int b) {
		return random.nextInt(a, b);
	}
/*	
	void makeXMove(int x) {
		if(!LegalMove(x, 0)) return;
		
		for (int i = 0; i < Wall.all.size(); i++) {
			Wall w = Wall.all.get(i);
			int x1 = w.getX()+x*8;
			w.setLocation(x1, w.getY());
		}
		for (int i = 0; i < Tile.all.size(); i++) {
			Tile t = Tile.all.get(i);
			int x1 = t.getX()+x*16;
			t.setLocation(x1, t.getY());
		}
	}
	void makeYMove(int y) {
		if(!LegalMove(0, y)) return;
		for (int i = 0; i < Wall.all.size(); i++) {
			Wall w = Wall.all.get(i);
			int y1 = w.getY()+y*8;
			w.setLocation(w.getX(), y1);
		}
		for (int i = 0; i < Tile.all.size(); i++) {
			Tile t = Tile.all.get(i);
			int y1 = t.getY()+y*16;
			t.setLocation(t.getX(), y1);
		} 
	} */
	boolean LegalMove(int x, int y) {
		for (int i = 0; i < Wall.all.size(); i++) {
			if(Wall.checkTouch(Wall.all.get(i), x*16, y*16)) {
				return false;
			}
		}
		return true;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_A) {
			leftPressed = true;
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			rightPressed = true;
		} else if (e.getKeyCode() == KeyEvent.VK_W) {
			upPressed = true;
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			downPressed = true;
		} else if (e.getKeyCode() == KeyEvent.VK_SPACE && Player.money >= 1) {
			Tile.generate();
			Player.money--;
			System.out.println("Money: " + Player.money);
		} else if (e.getKeyCode() == KeyEvent.VK_1) {
			Player.addSpeed();;
		} else if (e.getKeyCode() == KeyEvent.VK_2) {
			Player.addHealth();;
		} else if (e.getKeyCode() == KeyEvent.VK_3) {
			Drone.addSpeed();
		} else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			if(!gamePaused) {
				gamePaused = true;
				System.out.println("Pause!");
			} else {
				gamePaused = false;
				System.out.println("GO!");
			}
		}
		
	/*	if (e.getKeyCode() == KeyEvent.VK_A) {
			makeXMove(1);
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			makeXMove(-1);
		}
		if (e.getKeyCode() == KeyEvent.VK_W) {
			makeYMove(1);
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			makeYMove(-1);
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			Bullet.create();
			System.out.println("r");
		} */
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_A) {
			leftPressed = false;
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			rightPressed = false;
		} else if (e.getKeyCode() == KeyEvent.VK_W) {
			upPressed = false;
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			downPressed = false;
		}
	}
	/*
	@Override
	public void mouseClicked(MouseEvent e) {

	}
	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("ee");
	//	 droneX = e.getX();
	//   droneY = e.getY();
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {

		
	}
	@Override
	public void mouseExited(MouseEvent e) {

		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
	
	}
	@Override
	public void mouseMoved(MouseEvent e) {

	}	
	*/
}

/* ???
if (e.getKeyCode() == KeyEvent.VK_LEFT) {
	for (int i = 0; i < Wall.all.size(); i++) {
			Wall w = Wall.all.get(i);
			int x;
			if(Wall.checkTouch(w)) x = w.getX()-10;
			else x = w.getX()+10;
			w.setLocation(x, w.getY());
	}
*/
