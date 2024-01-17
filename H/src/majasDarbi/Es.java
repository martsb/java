package majasDarbi;

public class Es {

	public static void main(String[] args) {
		Team t1 = new Team("Shooters",  1000);
		Team t2 = new Team("Speedy",  2000);
		Player p1 = new Player("Joe", 58, 200);
		Player p2 = new Player("Andy", 51, 140);
		Player p3 = new Player("Mary", 35, 50);
		Player p4 = new Player("Karen", 62, 300);
		Player p5 = new Player("Jordan", 68, 340);
		Player p6 = new Player("Wendy", 45, 160);
		Player p7 = new Player("Johny", 28, 240);
		Player p8 = new Player("Peter", 32, 310);

		p1.transferTo(t2);
		p2.transferTo(t1);
		p3.transferTo(t1);
		p4.transferTo(t2);
		p5.transferTo(t2);
		p6.transferTo(t1);
		p7.transferTo(t1);
		p8.transferTo(t2);

		p5.transferTo(t1);
		p6.transferTo(t2);

		System.out.println(t1.name + " has players in main squad: " + t1.mainSquad);
		System.out.println(t2.name + " has players in main squad: " + t2.mainSquad);
		System.out.println(t1.name + " has players in trial: " + t1.trial);
		System.out.println(t2.name + " has players in trial: " + t2.trial);


	}

}
