package Ziema24;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

//Pievienot Tekstūras
//Salabot lecienu, tā lai var atsperties tikai no zemes, nevis pie velocity = 0
//Pievienot radiusu ap Player, kurā var noņemt blokus
//Pievienot GitHubu

public class Main implements Runnable, MouseListener{
	
	static Main main;
	static JFrame frame = new JFrame("Zeme");
	static JPanel panel = new JPanel();
	static Random random = new Random();
	static Thread threade;
	static final int SCREEN_WIDTH = 1200;
	static final int SCREEN_HEIGHT = 900;
	static final int WORLD_LENGHT_BLOCKS = 100;
	static int deviation = 0;
	static boolean gamePaused = false;
	static boolean useTextures = true;

	
	Main() {
		main = this;
		frame.setBounds(400, 100, SCREEN_WIDTH, SCREEN_HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel.setLayout(null);
		panel.setBackground(Color.cyan);
		panel.addMouseListener(this);
		frame.add(panel);
		
		new Player();
		Block.generateGround();
		threade = new Thread(this);
		threade.start();
	}
	
	public void run() {
		int count = 0;
		while(true) {
			if (gamePaused) {
				pause(100);
				continue;
			}
			if (count % 3 == 0 && Player.velocity < 10) Player.velocity++;
			if (!Player.hasCollisionsY()) Player.player.setLocation(Player.player.getX(), Player.player.getY() + Player.velocity);
			if (!Player.hasCollisionsX(-Player.speed) && Player.leftPressed) Block.move(Player.speed);
			if (!Player.hasCollisionsX(Player.speed) && Player.rightPressed) Block.move(-Player.speed);
			if (Player.player.getY() > SCREEN_HEIGHT) System.exit(0);
		//	if (count % 100 == 0) Block.generateRandomBlocks(1);
			panel.repaint();
			count++;
			pause(10);
		}
	}
	public void circle() {
		int range = 10000;
		for (int i = 100; i >= -100; i-=10) {
			new Soil(i, (int) Math.sqrt(range-i*i) + 100);		
		}
		for (int i = -100; i <= 100; i+=10) {
			new Soil(i, (int) -Math.sqrt(range-i*i) + 100);		
		}
	}
	public void pause(int s) {
		try {
			Thread.sleep(s);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Main();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON3) {
			new Ground((int)Math.floor((double)(e.getX() - (deviation % 50)) / Block.SIZE) * Block.SIZE + (deviation % 50), (int)Math.floor((double)e.getY() / Block.SIZE) * Block.SIZE);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
