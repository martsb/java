package BrikBal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuScreen extends JPanel implements KeyListener{
    ImageIcon imageIcon = new ImageIcon("C:\\Users\\Marts Druvis Lauma\\eclipse-workspace\\H\\res\\spriteatlas.png");
	Font font = new Font("sans-serif", Font.PLAIN, 24);
	private Main main;

	public MenuScreen() {
		this.setLayout(null);
		this.setBackground(Color.yellow);
		Main.jframe.addKeyListener(this);
		JLabel label1 = new JLabel("  BrikBal+++++++");
        label1.setBounds(500, 100, 200, 50);
        label1.setOpaque(true);
        label1.setBackground(Color.red);
        label1.setFont(font);
        add(label1);
        
        JButton playButton = new JButton("Play");
        playButton.setBounds(500, 200, 200, 100);
        playButton.setFocusable(false);
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.switchScene(new LevelScreen());
            }
        });

        add(playButton);
        JButton extraButton = new JButton("Extra");
        extraButton.setBounds(500, 350, 200, 100);
        extraButton.setFocusable(false);
        extraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.switchScene(new ExtraScreen());
            }
        });

        add(extraButton);
        
        JLabel label2 = new JLabel(imageIcon);
        label2.setBounds(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        label2.setOpaque(true);
        label2.setBackground(Color.pink);
        label2.setFont(font);
        add(label2);
        
        
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_S) {
			System.out.println("we");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
