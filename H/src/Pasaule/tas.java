package Pasaule;

import java.awt.Color;
import java.awt.Container;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class tas {
	static Container c = new Container();
	static Inputs inp = new Inputs();
	static JLabel button1;
	static JLabel button2;
	static JFrame frame1;
	static JFrame frame2;
	static JPanel panel1;
	static JPanel panel2;
	static Timer timer;
	static TimerTask task;
	
	tas() {
	//	createFrame1();
		timing();
	}
	
	public static void main(String[] args) {
		tas tas = new tas();
	}
	static void timing() {
		timer = new Timer();
		task = new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("ee");
			}
		};
		timer.scheduleAtFixedRate(task, 0, 400);
	}
	static void createPanel2() {
		panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setVisible(true);
		panel2.setBounds(400, 400, 200, 200);
		panel2.setBackground(Color.pink);
		panel2.setForeground(Color.black);
		c.add(panel2);
	}
	static void createPanel1() {
		panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setVisible(true);
		panel1.setBounds(400, 400, 200, 200);
		panel1.setBackground(Color.blue);
		panel1.setForeground(Color.black);
		c.add(panel1);
	}
	static void createFrame2() {
		if(frame2 != null) frame2.dispose();
		if(frame1 != null) frame1.dispose();
		frame2 = new JFrame();
		c = frame2.getContentPane();
		frame2.setBounds(100, 100, 600, 600);
		frame2.setVisible(true);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setLayout(null);
		c.setBackground(Color.yellow);
		createButton1();
		createButton2();
		
	}
	static void createFrame1() {
		if(frame1 != null) frame1.dispose();
		if(frame2 != null) frame2.dispose();
		frame1 = new JFrame();
		c = frame1.getContentPane();
		frame1.setBounds(100, 100, 600, 600);
		frame1.setVisible(true);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setLayout(null);
		c.setBackground(Color.cyan);
		createButton1();
		createButton2();

	}
	static void createButton1() {
		button1 = new JLabel("Button-1");
		button1.setBounds(100, 100, 200, 50);
		button1.setBackground(Color.red);
		button1.setOpaque(true);
		button1.addMouseListener(inp);
		c.add(button1);
	}
	static void createButton2() {
;		button2 = new JLabel("Button-2");
		button2.setBounds(100, 200, 200, 50);
		button2.setBackground(Color.red);
		button2.setOpaque(true);
		button2.addMouseListener(inp);
		c.add(button2);
	}
}
