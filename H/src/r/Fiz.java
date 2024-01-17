package r;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Fiz implements KeyListener {
	static JFrame screen;
	static JLabel player;
	static Container c;
	static ImageIcon image = new ImageIcon("/bord.png");
	static Timer timer1;
	static Timer timer2;
	static Timer timer3;
	static Timer timer4;
	static boolean rightPressed = false;
	static boolean leftPressed = false;
	static boolean gameOver = false;
	static final int SCREEN_HEIGHT = 600;
	static final int SCREEN_WIDTH = 600;
	static final int PLAYER_SIZE = 50;
	static final int BAR_DEVIATION = 39;
	static int moveSpeed = 10;
	static int velocity = 0;
	static int jumpStrenght = 30;
	static long lastTime;
	static int frameCount;
	    
	public static void main(String[] args) {
		new Fiz();
			 
	}
	Fiz() {
		createScreen();
		createPlayer();
		screen.addKeyListener(this);
		infinite();
	}	
	static void infinite() {
		start();
		tryMove();	
		doVelocity();
		doGravity();
		
		JLabel a = new JLabel();
		a.setBounds(100, 100, PLAYER_SIZE, PLAYER_SIZE);
		a.setIcon(image);
	}
	

	 static void doVelocity() {
		ActionListener tasker2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(player.getY() < SCREEN_HEIGHT - PLAYER_SIZE - BAR_DEVIATION) {
					velocity++;
				} else if (velocity > 0) {
					velocity = 0;
					player.setLocation(player.getX(), SCREEN_HEIGHT - PLAYER_SIZE - BAR_DEVIATION);
				}

			}
		};

		timer2 = new Timer(10, tasker2);
		timer2.start();
	}
	static void doGravity() {
		ActionListener tasker4 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				player.setLocation(player.getX(), player.getY()+velocity);
			}
		};

		timer4 = new Timer(10, tasker4);
		timer4.start();
	}
	static void jump() {
			velocity -= jumpStrenght;
			
	}

	static void tryMove() {
		 ActionListener taskPerformer3 = new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent evt) {
	            if(leftPressed) player.setLocation(player.getX()-moveSpeed, player.getY());
	            if(rightPressed) player.setLocation(player.getX()+moveSpeed, player.getY());
				
	            if(player.getY() < 0) {
					velocity = 0;
					player.setLocation(player.getX(), 0);
				}
	            if(player.getX() < 0) player.setLocation(0, player.getY());
	            if(player.getX() > SCREEN_WIDTH - 1.5 * PLAYER_SIZE) player.setLocation((int)(SCREEN_WIDTH - 1.3 * PLAYER_SIZE), player.getY());
	         }
	     };
	        
	     timer3 = new Timer(10, taskPerformer3);
	     timer3.start();
		
	}
    static void start() {
        lastTime = System.currentTimeMillis();
        frameCount = 0;
    }
    
    static void update() {
        long currentTime = System.currentTimeMillis();
        frameCount++;
        
        if (currentTime - lastTime >= 1000) {
            double fps = frameCount / ((currentTime - lastTime) / 1000.0);
            System.out.println("FPS: " + fps);
            frameCount = 0;
            lastTime = currentTime;
        }
    }
	static void pause(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	static void createScreen() {
		screen = new JFrame();
		screen.setBounds(600, 300, SCREEN_WIDTH, SCREEN_HEIGHT);
		screen.setVisible(true);
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screen.setLayout(null);
		c = screen.getContentPane();
	}
	static void createPlayer() {
		player = new JLabel();
		player.setBounds((SCREEN_WIDTH - PLAYER_SIZE) / 2, 400, PLAYER_SIZE, PLAYER_SIZE);
		player.setBackground(Color.black);
		player.setIcon(image);
		player.setOpaque(true);
		c.add(player);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_A) {
			leftPressed = true;
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			rightPressed = true;
		} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			 jump();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_A) {
			leftPressed = false;
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			rightPressed = false;
		}
		
		
	} // Thread
	static void a() {
		Thread t = new Thread() {
		public void run() {
				System.out.println("ew");
            	if(leftPressed) player.setLocation(player.getX()-3, player.getY());
            	if(rightPressed) player.setLocation(player.getX()+3, player.getY());
			
		}
		};
		t.start();
	}
}
