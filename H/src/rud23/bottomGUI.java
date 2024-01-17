package rud23;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class bottomGUI implements MouseListener{
	static JLabel optionPanel;
	static JLabel pauseButton;
	static JLabel exitButton;
	static JLabel upgradeButton1;
	static JLabel upgradeButton2;
	static final int OPTION_PANEL_HEIGHT = 200;
	static final int OPTION_PANEL_WIDTH = Main.SCREEN_WIDTH;
	
	public bottomGUI() {
		pauseButton = createPauseButton();
		exitButton = createExitButton();
		optionPanel = createOptionPanel();
		
		upgradeButton1 = createUpdateButton1();
		upgradeButton2 = createUpdateButton2();
		upgradeButton1.addMouseListener(this);
		upgradeButton2.addMouseListener(this);

	}
	static JLabel createUpdateButton1() {
		JLabel counter = new JLabel("Upgrade!");
		Font font = new Font("sans-serif", Font.PLAIN, 24);
		counter.setBackground(Color.white);
		counter.setBounds(50, Main.SCREEN_HEIGHT - OPTION_PANEL_HEIGHT + 20, 150, 50);
		counter.setOpaque(true);
		counter.setFont(font);
		counter.setVisible(false);
		GameScreen.gameScreen.add(counter);
		GameScreen.gameScreen.setComponentZOrder(counter, 0);
		return counter;
	}
	static JLabel createUpdateButton2() {
		JLabel counter = new JLabel("Upgrade!");
		Font font = new Font("sans-serif", Font.PLAIN, 24);
		counter.setBackground(Color.white);
		counter.setBounds(50, Main.SCREEN_HEIGHT - OPTION_PANEL_HEIGHT + 100, 150, 50);
		counter.setOpaque(true);
		counter.setFont(font);
		counter.setVisible(false);
		GameScreen.gameScreen.add(counter);
		GameScreen.gameScreen.setComponentZOrder(counter, 0);
		return counter;
	}
	static JLabel createOptionPanel() {
		JLabel counter = new JLabel();
		counter.setBackground(Color.lightGray);
		counter.setBounds(0, Main.SCREEN_HEIGHT - OPTION_PANEL_HEIGHT, Main.SCREEN_WIDTH, 200);
		counter.setOpaque(true);
		GameScreen.gameScreen.add(counter);
		return counter;
	}
	static JLabel createPauseButton() {
		JLabel counter = new JLabel("Pause");
		Font font = new Font("sans-serif", Font.PLAIN, 24);
		counter.setBackground(Color.white);
		counter.setBounds(Main.SCREEN_WIDTH - 250, Main.SCREEN_HEIGHT - OPTION_PANEL_HEIGHT + 20, 150, 50);
		counter.setOpaque(true);
		counter.setFont(font);
		GameScreen.gameScreen.add(counter);
		return counter;
	}
	static JLabel createExitButton() {
		JLabel counter = new JLabel("Exit");
		Font font = new Font("sans-serif", Font.PLAIN, 24);
		counter.setBackground(Color.white);
		counter.setBounds(Main.SCREEN_WIDTH - 250, Main.SCREEN_HEIGHT - OPTION_PANEL_HEIGHT+ 100, 150, 50);
		counter.setOpaque(true);
		counter.setFont(font);
		GameScreen.gameScreen.add(counter);
		return counter;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == upgradeButton1) Tower.upgrade1();
		if (e.getSource() == upgradeButton2) Tower.upgrade2();
		
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
