package Ziema24;

import java.awt.Color;

public class Ground extends Block{
	static int groundBreakPoint = 10;

	public Ground(int x, int y) {
		super(x, y);
		this.breakPoint = groundBreakPoint;
		if (Main.useTextures) this.setIcon(ground); 
			else this.setBackground(Color.gray);

		
	}
	

}
