package gam;

import javax.swing.JFrame;

public class Window {
	private JFrame jframe;
	public Window(Panel panel) {
		jframe = new JFrame();
		jframe.setSize(500, 500);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.add(panel);
		jframe.setLocationRelativeTo(null);
		jframe.setVisible(true);
	}
	

}
