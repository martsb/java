package Ziema24;

import java.awt.Color;

public class Soil extends Block{
	static int soilBreakPoint = 3;

	public Soil(int x, int y) {
		super(x, y);
		this.breakPoint = soilBreakPoint;
		if (Main.useTextures) this.setIcon(soil);
			else this.setBackground(Color.green);
		
	}
	

}
