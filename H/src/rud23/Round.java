package rud23;

import java.util.ArrayList;

public class Round {
	int number;
	int ballCount;
	int spawnCooldown;
	static ArrayList<Round> all = new ArrayList<Round>();
	
	static Round r1 = new Round(1, 5, 100);
	static Round r2 = new Round(2, 10, 80);
	static Round r3 = new Round(3, 15, 60);
	static Round r4 = new Round(4, 25, 40);
	static Round r5 = new Round(5, 35, 30);
	static Round r6 = new Round(6, 100, 20);
	static Round r7 = new Round(7, 200, 10);
	static Round r8 = new Round(8, 400, 5);
	static Round r9 = new Round(9, 1000, 2);
	static Round r10 = new Round(10, 999999, 1);

	
	public Round(int number, int ballCount, int spawnCooldown) {
		super();
		this.number = number;
		this.ballCount = ballCount;
		this.spawnCooldown = spawnCooldown;
		all.add(this);
	}
}
