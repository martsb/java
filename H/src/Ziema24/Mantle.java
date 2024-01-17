package Ziema24;

import java.awt.Color;

public class Mantle extends Block{
	static int soilBreakPoint = 100;

	public Mantle(int x, int y) {
		super(x, y);
		this.breakPoint = soilBreakPoint;
		this.setBackground(Color.black);
		
	}
	

}
