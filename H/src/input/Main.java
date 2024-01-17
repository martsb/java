package input;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
	static int submitPressedTimes = 0;

	public static void main(String[] args) {
		JFrame frame = new JFrame("Minecraft Alpha v1.0");
		frame.setBounds(200, 200, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cont = frame.getContentPane();
		cont.setBackground(Color.decode("#3084a2"));
		frame.setVisible(true);
		cont.setLayout(null);
		
		Font title = new Font("sans-serif", Font.BOLD, 24);
		Font base = new Font("sans-serif", Font.PLAIN, 16);
		JLabel header = new JLabel("How did You get here?");
		header.setForeground(Color.white);
		header.setFont(title);
		header.setBounds(250, 40, 260, 40);
		header.setBackground(Color.decode("#4398b9"));
		
		JLabel statusLabel = new JLabel("yes");
		statusLabel.setBounds(250, 180, 250, 30);
		statusLabel.setFont(base);
		statusLabel.setForeground(Color.WHITE);
		JButton submit = new JButton("Submit");
		submit.setBounds(400, 120, 100, 30);
		submit.setBorder(null);
		submit.setBackground(Color.WHITE);
		cont.add(statusLabel);
		cont.add(header);
		cont.add(submit);
		
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			submitPressedTimes++;
			String text = "You pressed me!";
			if (submitPressedTimes>10) text = "STAAAHP!!!";
			else if (submitPressedTimes>5) text = "Stop it!";
			else if (submitPressedTimes>1) text = "You pressed me again!";
			statusLabel.setText(text);
			}
			});

	}

}
