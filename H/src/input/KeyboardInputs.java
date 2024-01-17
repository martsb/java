package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import gam.Panel;

public class KeyboardInputs implements KeyListener{
	private Panel panel;
	public KeyboardInputs(Panel panel) {
		this.panel = panel;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
	
		
	}
	

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		
			case KeyEvent.VK_W: 
				panel.changeYDelta(-20);
				break;
			case KeyEvent.VK_A: 
				panel.changeXDelta(-20);
				break;
			case KeyEvent.VK_S: 
				panel.changeYDelta(+20);
				break;
			case KeyEvent.VK_D: 
				panel.changeXDelta(+20);
				break;
		}
		
	}
}
