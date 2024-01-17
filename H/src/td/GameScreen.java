package td;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;


import javax.swing.JPanel;

public class GameScreen extends JPanel{
	
	private Random random;
	private BufferedImage img;

	ArrayList<BufferedImage> sprites = new ArrayList<>();
	
	public GameScreen(BufferedImage img) {
		this.img = img;
		loadSprites();
		random = new Random();
	}
	
	private void loadSprites() {
		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 10; x++) {
				sprites.add(img.getSubimage(x*32, y*32, 32, 32));
			}
		}
		
	}

	public void paintComponent(Graphics g) {
		g.drawImage(sprites.get(rndNum()), 0, 0, null);
		repaint();
	}
				
	private int rndNum() {
		int a = random.nextInt(71);
		return a;
	}
	
	private Color getRndColor() {
		int r = random.nextInt(256);
		int b = random.nextInt(256);
		int g = random.nextInt(256);
		return new Color(r, b, g);
	}

}
