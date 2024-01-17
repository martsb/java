package vas23;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.GroupLayout.Group;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Mainc implements MouseListener{
	static JFrame jframe = new JFrame("gamz");
	static Container c = new Container();
	static Random random = new Random();
	static int SCREEN_WIDTH = 1200;
	static int SCREEN_HEIGHT = 800;
	static int money = 0;
	static JLabel moneyCounter = new JLabel();

	public static void main(String[] args) {
		new Mainc();
		
	}
	public Mainc() {
		jframe.addMouseListener(this);
		run();
	}
	static void run() {
		createScreen();
		createMoneyCounter();
		City.createCentral();
		loop();
	}
	static void loop() {
		int count = 0;
		while(true) {
			if (count % 100 == 0) City.grow();
			c.repaint();
			pause(10);
			count++;
		}
	}
	static void addMoney(int x) {
		money += x;
		moneyCounter.setText("Money: " + money);
	}
	static void createMoneyCounter() {
		moneyCounter.setBounds(10, 10, 100, 50);
		moneyCounter.setVisible(true);
		moneyCounter.setBackground(Color.cyan);
		moneyCounter.setText("Money: " + Mainc.money);
		Mainc.c.add(moneyCounter);
	}
	static void createScreen() {
		jframe.setBounds(400, 100, SCREEN_WIDTH, SCREEN_HEIGHT);
		jframe.setVisible(true);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c = jframe.getContentPane();
		c.setLayout(null);
	}
	static void pause(int s) {
		try {
			Thread.sleep(s);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static int getRandom(int x, int y) {
		return random.nextInt(x, y);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		City.spawnCity(e.getX()-30, e.getY()-60);
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
