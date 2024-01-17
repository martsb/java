package pav23;

import java.awt.Color;

import javax.swing.JLabel;


public class Drone extends JLabel{
	static int size = 16;
	static int x = Screen.width/2;
	static int y = Screen.height/2;
	static int speed = 2;
	
	Drone() {
		this.setBounds(x, y, size, size);
		this.setBackground(Color.white);
		this.setOpaque(true);
		Screen.screen.c.add(this);
	}
	static void create() {
		Screen.human = new Drone();
	}
	static void addSpeed() {
		if(Player.money >= Supply.droneSpeedCost && !Screen.gameOver) {
			Drone.speed++;
			Player.money -= Supply.droneSpeedCost;
			Screen.screen.moneyBar.setText("Money: " + Player.money);
			Supply.droneSpeedCost *= 1.1;
			Bar.all.get(2).setText(Supply.droneSpeedCost + "$     Add drone speed (3)");
		}
	}
	static int[] getEnemiesDistance(Enemy e) {
		int x = Math.abs(Screen.human.getX() - e.getX());
		int y = Math.abs(Screen.human.getY() - e.getY());
		int[] a = {x, y};
		return a;
	}
	Enemy findTarget() {
		Enemy target = null;
		int distance = 0;
		for (int i = 0; i < Enemy.all.size(); i++) {
			int[] coords = getEnemiesDistance(Enemy.all.get(i));
			if(!Enemy.all.get(i).isDead  && (target == null || coords[0] + coords[1] < distance)) {
				target = Enemy.all.get(i);
				distance = coords[0] + coords[1];
			}
		}
		return target;
	}
	void move2Enemy(Enemy e) {
		if(!Enemy.all.contains(e) && findTarget() != null) e = findTarget();
		int dirX = 0;
		int dirY = 0;
		if(Screen.human.getX() + size < e.getX() + Enemy.size) dirX = 1 * speed;
		if(Screen.human.getX() + size > e.getX() + Enemy.size) dirX = -1 * speed;
		if(Screen.human.getY() + size < e.getY() + Enemy.size) dirY = 1 * speed;
		if(Screen.human.getY() + size > e.getY() + Enemy.size) dirY = -1 * speed;
		Screen.human.setLocation(Screen.human.getX()+dirX, Screen.human.getY()+dirY);
	}
	void move() {
		int dirX = 0;
		int dirY = 0;
		if(Screen.human.getX() + size < Screen.droneX) dirX = 1 * speed;
		if(Screen.human.getX() + size > Screen.droneX) dirX = -1 * speed;
		if(Screen.human.getY() + size < Screen.droneY) dirY = 1 * speed;
		if(Screen.human.getY() + size > Screen.droneY) dirY = -1 * speed;
		if((Screen.human.getX() + size - Screen.droneX) / 10 == 0) dirX = 0;
		if((Screen.human.getY() + size - Screen.droneY) / 10 == 0) dirY = 0;
		Screen.human.setLocation(Screen.human.getX()+dirX, Screen.human.getY()+dirY);
	//	Screen.drone.setLocation(Screen.mouseX, Screen.mouseY);
	}

}
