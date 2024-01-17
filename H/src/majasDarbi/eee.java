package majasDarbi;

public class eee {

	public static void main(String[] args) {
		Eef a1 = new Eef("af", 10);
		Eef a2 = new Eef("ad", 20);
		Eef a3 = a1;
		System.out.println(a3.age);

		a1.age = 14;
		Eef.printAllInfo();
		System.out.println(a3.age);
	}

}
