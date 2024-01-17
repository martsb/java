package majasDarbi;

import java.util.ArrayList;

public class Team {
	String name;
	int budget;
	ArrayList<Player> trial = new ArrayList<Player>();
	ArrayList<Player> mainSquad = new ArrayList<Player>();
	
	public Team(String name, int budget) {
		this.name = name;
		this.budget = budget;
	}
}
