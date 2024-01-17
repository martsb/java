package Tilecap;

import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameScreen extends JPanel implements Runnable{
	static GameScreen gameScreen;
	static Thread threade;
	//???
	static TextField text;
	static JLabel label;
	static JButton button;
	static int first;
	static int second;
	static Tile capturable;
	
	public GameScreen() {
		gameScreen = this;
		this.setLayout(null);
		this.setBackground(Color.lightGray);
		threade = new Thread(gameScreen);
		threade.start();
		createBoxes();
	}
	//???
	static void createBoxes() {
		text = new TextField();
		text.setBounds(100, 70, 100, 20);
		gameScreen.add(text);
		
		label = new JLabel("");
		label.setBounds(100, 40, 100, 20);
		gameScreen.add(label);
		
		button = new JButton("Enter");
		button.setBounds(100, 100, 100, 20);
		gameScreen.add(button);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int value = 0;
				try {
				value = Integer.parseInt(text.getText());
				} catch (Exception E) {};
				if (value == first * second) Tile.capture(capturable);
			}
		});

	}
	static void question(Tile t) {
		capturable = t;
		first = Tile.getRandom(2, 10);
		second = Tile.getRandom(2, 10);
		GameScreen.label.setText("What is " + first + " * " + second + "?");
	}

	@Override
	public void run() {
		Tile.generateAll();

	}
}
