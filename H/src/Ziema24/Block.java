package Ziema24;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Block extends JLabel implements MouseListener{

	static ImageIcon ground = new ImageIcon("C:\\Users\\Marts Druvis Lauma\\eclipse-workspace\\H\\res\\Ground.png");
	static ImageIcon soil = new ImageIcon("C:\\Users\\Marts Druvis Lauma\\eclipse-workspace\\H\\res\\Soil.png");
	static ImageIcon brokenGround = new ImageIcon("C:\\Users\\Marts Druvis Lauma\\eclipse-workspace\\H\\res\\BrokenGround.png");
	static ImageIcon brokenSoil = new ImageIcon("C:\\Users\\Marts Druvis Lauma\\eclipse-workspace\\H\\res\\BrokenSoil.png");
	static JLabel block1 = new JLabel();
	static ArrayList<JLabel> blockList = new ArrayList<JLabel>();
	static int SIZE = 50;
	int breakPrcnt = 0;
	int breakPoint;
	
	Block() {
		block1 = this;
		this.setBounds(400, 200, 500, 500);
		this.setBackground(Color.red);
		this.setOpaque(true);
		this.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.green));
		this.addMouseListener(this);
		blockList.add(this);
		Main.panel.add(this);
	}
	Block(int x, int y) {
		this.setBounds(x, y, SIZE, SIZE);
		this.setBackground(new Color(0f, 0f, 0f, 0f));
		this.setOpaque(true);
		this.addMouseListener(this);
		blockList.add(this);
		Main.panel.add(this);
		//this.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.green));
	}
	static void move(int distance) {
		Main.deviation += distance;
		for (int i = 0; i < Block.blockList.size(); i++) {
			Block.blockList.get(i).setLocation(Block.blockList.get(i).getX() + distance, Block.blockList.get(i).getY());
			
		}
	}
	static void generateGround() {
		int height = 10;
		for (int i = 0; i < Math.ceil((float) Main.WORLD_LENGHT_BLOCKS); i++) {
			new Mantle((Main.SCREEN_HEIGHT - Main.WORLD_LENGHT_BLOCKS * Block.SIZE) / 2 + i * Block.SIZE, Main.SCREEN_HEIGHT - Block.SIZE);
			for (int j = 2; j < height+1; j++) {
				new Ground((Main.SCREEN_HEIGHT - Main.WORLD_LENGHT_BLOCKS * Block.SIZE) / 2 + i * Block.SIZE, Main.SCREEN_HEIGHT - j * Block.SIZE);
			}
			for (int j = 0; j < 3; j++) {
				new Soil((Main.SCREEN_HEIGHT - Main.WORLD_LENGHT_BLOCKS * Block.SIZE) / 2 + i * Block.SIZE, Main.SCREEN_HEIGHT - (height + j + 1) * Block.SIZE);		
			}

			if (height <= 4) height++;
			if (height >= 13) height--;
			height += Main.random.nextInt(-1, 2);
		}
	}
	static void generateRandomBlocks(int count) {
		for (int i = 0; i < count; i++) {
			new Block(Main.random.nextInt(0, Main.SCREEN_WIDTH - 100), Main.random.nextInt(0, Main.SCREEN_HEIGHT - 100));
		}
	}
	static void explosion() {
	    int playerX = Player.player.getX() + Player.SIZE / 2;
	    int playerY = Player.player.getY() + Player.SIZE / 2;

	    // Use an iterator to safely remove elements while iterating
	    Iterator<JLabel> iterator = Block.blockList.iterator();
	    
	    while (iterator.hasNext()) {
	        JLabel block = iterator.next();
	        int blockX = block.getX() + Block.SIZE / 2;
	        int blockY = block.getY() + Block.SIZE / 2;

	        int distanceX = Math.abs(blockX - playerX);
	        int distanceY = Math.abs(blockY - playerY);

	        if (Math.sqrt(distanceX * distanceX + distanceY * distanceY) < 200) {
	            // Remove the current block using the iterator's remove method
	            iterator.remove();
	            Block.remove(block);
	        }
	    }
	}
	static void remove(JLabel block) {
		blockList.remove(block);
		Main.panel.remove(block);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			if (breakPrcnt >= this.breakPoint) {
				Block.remove(this);
			} else {
				breakPrcnt++;
			}
			if (10 * this.breakPrcnt / this.breakPoint >= 5) {
				if (this.breakPoint == 10) this.setIcon(brokenGround);
				if (this.breakPoint == 3) this.setIcon(brokenSoil);

			}
		}
		if (e.getButton() == MouseEvent.BUTTON2) {
			
			System.out.println(this.breakPrcnt);
		}
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
