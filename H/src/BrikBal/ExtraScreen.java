package BrikBal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import vas23.Game;

public class ExtraScreen extends JPanel implements Runnable{
	 private Main main;
	    private JLabel label1, label2, label3, label4, botSign;
        Thread threade;


	    public ExtraScreen() {

	        // Set the layout to null
	        setLayout(null);

	        // Create and position JLabels
	        label1 = new JLabel("What");
	        label1.setBounds(100, 100, 100, 20); // x, y, width, height
	        label1.setOpaque(true);
	        label1.setBackground(Color.red);
	        
	        label2 = new JLabel("is");
	        label2.setBounds(300, 200, 100, 20); // x, y, width, height
	        label2.setOpaque(true);
	        label2.setBackground(Color.red);
	        
	        // Add JLabels to the panel
	        add(label1);
	        add(label2);
	        
	        JButton playButton = new JButton("Back");
	        playButton.setBounds(300, 200, 100, 100);
	        playButton.setFocusable(false);
	        playButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                Main.switchScene(new MenuScreen());
	            }
	        });

	        add(playButton);
	        
	        JButton botButton = new JButton("ENABLE THE BOT!");
	        botButton.setBounds(500, 200, 200, 100);
	        botButton.setFocusable(false);
	        botButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	if (GameScreen.botEnabled) {
		            	GameScreen.botEnabled = false;
		            	botButton.setText("ENABLE THE BOT!");
	            		botSign.setVisible(false);

	            	} else if (GameScreen.money >= 0) {
	            		GameScreen.botEnabled = true;
	            		botButton.setText("disable the bot");
	            		botSign.setVisible(true);
	            	}
	            }
	        });

	        add(botButton);
	        
	        botSign = new JLabel("THE BOT HAS BEEN ENABLED!", SwingConstants.CENTER);
	        botSign.setFont(new Font("a", Font.BOLD, 20));
	        botSign.setVisible(false);
	        botSign.setBounds(400, 20, 400, 100); // x, y, width, height
	        botSign.setOpaque(true);
	        botSign.setBackground(Color.red);
	        
	        add(botSign);
	        
	        label4 = new JLabel("Requires 100 moneys...", SwingConstants.CENTER);
	        label4.setBounds(500, 300, 200, 20); // x, y, width, height
	        // Add JLabels to the panel
	        add(label4);
	        
	        Thread threade = new Thread(this);
	        threade.start();
	    }

		@Override
		public void run() {
			label3 = new JLabel("your money: " + GameScreen.money);
			label3.setBounds(300, 400, 100, 50); // x, y, width, height
			label3.setOpaque(true);
			label3.setBackground(Color.green);    
		    add(label3);
		    while(true) {
		    	label3.setLocation(label3.getX() + GameScreen.getRandom(-10, 11), label3.getY() + GameScreen.getRandom(-10, 11));
		    	GameScreen.pause(1000);
		    }
		}
}
