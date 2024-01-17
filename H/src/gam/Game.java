package gam;

public class Game {
	private Window window;
	private Panel panel;
	public Game() {
			panel = new Panel();
			window = new Window(panel);
			panel.setFocusable(true);
			panel.requestFocus();
	
	}

}
