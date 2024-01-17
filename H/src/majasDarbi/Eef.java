package majasDarbi;

import java.util.ArrayList;

public class Eef {
	static String name;
	int age;
	static ArrayList<Eef> all = new ArrayList<>();
	Eef(String name, int age) {
		this.name = name;
		this.age = age;
		all.add(this);
	}
	public static void printAllInfo() {
		System.out.println("ee");
		for (Eef e : Eef.all) {
			System.out.println("Name: " + e.name + ", age: " + e.age);
		}
		
	}
}
