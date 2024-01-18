package Kase;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	ImageIcon icon1 = new ImageIcon("C:\\Users\\Marts Druvis Lauma\\git\\repository2\\H\\res\\Soil.png");
	
	Main() {
		frame.setBounds(400, 100, 1200, 900);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		panel.setLayout(null);
		panel.setBackground(Color.cyan);
		
		JLabel kaste = new JLabel();
		kaste.setBounds(100, 100, 100, 100);
		kaste.setBackground(new Color(0f, 0f, 0f, 0f));
		kaste.setVisible(true);
		kaste.setOpaque(true);
		kaste.setIcon(icon1);
		panel.add(kaste);
		
	}
	static void draw(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		g2D.drawRect(200, 200, 100, 100);
	}
	public static void main(String[] args) {
		new Main();
		
	}

}
