package vas23;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JLabel;

public class City extends JLabel implements MouseListener{
	static int citySize = 64;
	static ArrayList<City> cities = new ArrayList<>();
	int count = 0;
	static int citiesPrice = 10;
	
	City(int x, int y) {
		this.setBounds(x, y, citySize, citySize);
		this.setVisible(true);
		this.setBackground(Color.cyan);
		this.setOpaque(true);
		this.setText("p: " + count);
		Mainc.c.add(this);	
		cities.add(this);
		this.addMouseListener(this);
	}
	static void spawnCity(int x, int y) {
		if (Mainc.money >= citiesPrice) {
			new City(x, y);	
			Mainc.money -= 10;
			Mainc.moneyCounter.setText("Money: " + Mainc.money);
		}
	}
	static void setZero(Object object) {
		City city = (City) object;
		city.count = 0;
		city.setText("p: " + city.count);
	}
	static void createCentral() {
		City central = new City(Mainc.SCREEN_WIDTH / 2, Mainc.SCREEN_HEIGHT / 2);
	}
	static void grow() {
		for (City city : cities) {
			city.count++;
			city.setText("p: " + city.count);
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		Mainc.addMoney(count);
		setZero(e.getSource());
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
