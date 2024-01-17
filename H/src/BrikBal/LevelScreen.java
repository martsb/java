package BrikBal;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class LevelScreen extends JPanel{
	static JButton cancelButton = new JButton("Back");
	static LevelScreen levelScreen;
	
	public LevelScreen() {
		levelScreen = this;
		this.setLayout(null);
		this.setBackground(Color.yellow);
		addCancelButton();
		addLevelButton(200, 100, 1);
		addLevelButton(410, 100, 2);
		addLevelButton(620, 100, 3);
		addLevelButton(830, 100, 4);
		addLevelButton(200, 210, 5);
		addLevelButton(410, 210, 6);
		addLevelButton(620, 210, 7);
		addLevelButton(830, 210, 8);
		addLevelButton(500, 320, 9);

	}
	static void addLevelButton(int x, int y, int dif) {
		JButton levelButton = new JButton("Level " + dif);
		levelButton.setBounds(x, y, 200, 100);
		levelButton.setVisible(true);
		levelButton.setFocusable(false);
		levelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.switchScene(new GameScreen(dif));
            }
        });
        levelScreen.add(levelButton);
	}
	static void addCancelButton() {
		cancelButton.setBounds(500, 500, 200, 100);
		cancelButton.setVisible(true);
		cancelButton.setFocusable(false);
		cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.switchScene(new MenuScreen());
            }
        });
        levelScreen.add(cancelButton);
	}
}
