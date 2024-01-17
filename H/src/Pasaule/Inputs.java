package Pasaule;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

public class Inputs implements MouseInputListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource() == tas.button1) {
			System.out.println("Take Action 1");
			tas.createFrame1();
			tas.panel2 = null;
			tas.createPanel1();
		}
		if(e.getSource() == tas.button2) {
			System.out.println("Take Action 2");
			tas.createFrame2();
			tas.panel1 = null;
			tas.createPanel2();
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

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
