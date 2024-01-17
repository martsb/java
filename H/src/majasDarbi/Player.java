package majasDarbi;

public class Player {
	String name;
	Boolean inSquad = false;
	int SkillLvl;
	int price;
	Team team;
	
	
	public Player(String name, int skillLvl, int price) {
		this.name = name;
		SkillLvl = skillLvl;
		this.price = price;
	}
	void transferTo(Team team) {
			if(team.budget < this.price) {
				System.out.println("Transfer unsuccesful! Team doesn't have enough money!");
				return;
			}
			if(this.team != null) removeFromTeam(this);
			this.team = team;
			team.trial.add(this);
			team.budget -= this.price;
			
			double sum = 0;
			for (int i = 0; i < team.mainSquad.size(); i++) {
				sum += team.mainSquad.get(i).SkillLvl;
			}
			if (team.mainSquad.size() < 3 || this.SkillLvl > sum / team.mainSquad.size()) {
				this.inSquad = true;
				team.trial.remove(this);
				team.mainSquad.add(this);
			}
			FindBestPlyrInTeam(team).SkillLvl *= 1.1;
			FindWorstPlyrInTeam(team).SkillLvl *= 0.9;
	}
	void removeFromTeam(Player player) {
		team.mainSquad.remove(this);
		team.trial.remove(this);
		this.team = null;
	}
	Player FindBestPlyrInTeam(Team team) {
		Player best = null;
		int lvl = 0;
		for (int i = 0; i < team.mainSquad.size(); i++) {
			if (team.mainSquad.get(i).SkillLvl > lvl || best == null) {
				best = team.mainSquad.get(i);
				lvl = team.mainSquad.get(i).SkillLvl;
			}
		}
		return best;
	}
	Player FindWorstPlyrInTeam(Team team) {
		Player worst = null;
		int lvl = 100;
		for (int i = 0; i < team.mainSquad.size(); i++) {
			if (team.mainSquad.get(i).SkillLvl < lvl || worst == null) {
				worst = team.mainSquad.get(i);
				lvl = team.mainSquad.get(i).SkillLvl;
			}
		}
		return worst;
	}
	public String toString() {
		return this.name;
	}
}
