package Pasaule;

public class Main {
public static void main(String[] args) {
	
	@SuppressWarnings("unused")
	Screens screen = new Screens();
	Screens.start();
	}
}
/*

// You might want to add frame.setVisible(true) to be the very last line. Sometimes with Mac, the components won't appear until you resize the window

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class Main {

	public static void main(String[] args) {

		// JLabel = a GUI display area for a string of text, an image, or both
		
		ImageIcon image = new ImageIcon("bord.png");
		Border border = BorderFactory.createLineBorder(Color.green,3);
		
		JLabel label = new JLabel(); //create a label
		label.setText("bro, do you even code?"); //set text of label
		label.setIcon(image);
		label.setHorizontalTextPosition(JLabel.CENTER); //set text LEFT,CENTER, RIGHT of imageicon
		label.setVerticalTextPosition(JLabel.TOP); //set text TOP,CENTER, BOTTOM of imageicon
		label.setForeground(new Color(0x00FF00)); //set font color of text
		label.setFont(new Font("MV Boli",Font.PLAIN,100)); //set font of text
		label.setIconTextGap(-25); //set gap of text to image
		label.setBackground(Color.black); //set background color
		label.setOpaque(true); //display background color
		//label.setBorder(border); //sets border of label (not image+text)
		label.setVerticalAlignment(JLabel.CENTER); //set vertical position of icon+text within label
		label.setHorizontalAlignment(JLabel.CENTER); //set horizontal position of icon+text within label
		//label.setBounds(100, 100, 250, 250); //set x,y position within frame as well as dimensions
			
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setSize(500,500);
		//frame.setLayout(null);
		frame.setVisible(true);	 
		frame.add(label);
		frame.pack();
	}
}

package Pasaule;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
    private static final int TILE_SIZE = 10;
    private static final int NUM_TILES = 100;
    private static final int FRAME_SIZE = TILE_SIZE * NUM_TILES + 17;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tile Splitting Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(FRAME_SIZE, FRAME_SIZE);

        // Create a custom panel for painting the tiles
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Draw the tiles
                for (int x = 0; x < NUM_TILES; x++) {
                    for (int y = 0; y < NUM_TILES; y++) {
                        int tileX = x * TILE_SIZE;
                        int tileY = y * TILE_SIZE;

                        // Set a different color for each tile
                        if ((x + y) % 2 == 0) {
                            g.setColor(Color.WHITE);
                        } else {
                            g.setColor(Color.GRAY);
                        }

                        // Draw the tile
                        g.fillRect(tileX, tileY, TILE_SIZE, TILE_SIZE);
                    }
                }
            }
        };

        // Set the preferred size of the panel
        panel.setPreferredSize(new Dimension(FRAME_SIZE, FRAME_SIZE));

        // Add the panel to the frame
        frame.getContentPane().add(panel);

        // Display the frame
        frame.setVisible(true);
    }
}
*/