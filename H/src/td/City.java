package td;

import java.util.ArrayList;


public class City {
	String name;
	int population = 0;
	static ArrayList<City> list = new ArrayList<>();
	ArrayList<Person> people = new ArrayList<>();

	City(String name, int population) {
		this.name = name;
		this.population = population;
	}

	static void populate(Person person) {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).name.matches(person.city)) {
					list.get(i).population ++;
					list.get(i).people.add(person);
					return;
			}
		}
		list.add(list.size(), new City(person.city, 1));
	}
	int getPopulation() {
		return this.people.size();
	}
}
