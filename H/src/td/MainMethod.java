package td;

import java.util.Comparator;
import java.util.HashSet;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

public class MainMethod {

	public static void main(String[] args) {
		Config.generate();

		// 1.
		System.out.println("1. Average adult salary is: " + avgAdultSalary());
		// 2.
		String city = "Valmiera";		
		Person oldestWorker = findCitiesOldestWorker(city);
		System.out.println("2. Oldest worker in " + city + " is " + oldestWorker.firstName + " " + oldestWorker.lastName);
		// 3.
		System.out.println("3. Average doctor salary is " + AvgDrSalary());
		// 4.
		System.out.println("4. Total pet count is " + totalPetCount());
		// 5.
		String petName = "Fluffy";
		System.out.println("5. There are " + petCountNamed(petName) + " pets named " + petName);
		// 6.
		youngestPerson();
		System.out.println("6. The average age, where " + youngestPerson().firstName + " lives is " + avgAgeWhereLives(youngestPerson()));
		// 7.
		System.out.println("7. There are " + uniqueFirstNameCount() + " unique first names");
		System.out.println("   There are " + uniqueLastNameCount() + " unique last  names");
		// 9.
		String city1 = "Vienna";
		Person.printCityPopulation(city1);
		// 10.
		
		City populatest = populatestCity();
		System.out.println("10. " + populatest.name + " is the most populated with: " + populatest.population + "\n");

		// Extra
		String city2 = "Rīga";
		Person.printCityDemographics(city2);
		Person.printMostPensionersCity();		
	}

	private static City populatestCity() {
		Comparator<City> comp = Comparator.comparing(City::getPopulation);
		return City.list
				.stream()
				.max(comp)
				.get();
	}

	static long uniqueLastNameCount() {
		return Person.all
				.stream()
				.map(p -> p.lastName)
				.distinct()
				.count();
	}

	static long uniqueFirstNameCount() {
		return Person.all
				.stream()
				.map(p -> {
					if (p.firstName.startsWith("Dr. ")) p.firstName = p.firstName.substring(4);
					return p.firstName;
				})
				.distinct()
				.count();
	}

	static double avgAgeWhereLives(Person youngestPerson) {
		return Person.all
				.stream()
				.filter(p -> p.city.equals(youngestPerson.city))
				.mapToDouble(Person -> Person.age)
				.average()
				.getAsDouble();
	}

	static Person youngestPerson() {
		Comparator<Person> comp = Comparator.comparing(Person::getAge);
		return Person.all
			.stream()
			.min(comp)
			.get();
			
	}

	static long petCountNamed(String petName) {
		return Person.all
				.stream()
				.flatMap(p -> p.pets.stream())
				.filter(p -> p.contains(petName))
				.count();
	}

	static int totalPetCount() {
		return Person.all
				.stream()
				.mapToInt(Person -> Person.pets.size())
				.sum();
	}

	static double AvgDrSalary() {
		return Person.all
				.stream()
				.filter(p -> p.firstName.startsWith("Dr. "))
				.mapToDouble(Person -> Person.salary)
				.average()
				.getAsDouble();
	}

	static Person findCitiesOldestWorker(String city) {
		Comparator<Person> comp = Comparator.comparing(Person::getAge);
		return Person.all
				.stream()
				.filter(p -> p.isWorking && p.city.equals(city))
				.max(comp)
				.get();
	}

	static double avgAdultSalary() {
		return Person.all
				.stream()
				.filter(p -> p.isAdult())
				.mapToDouble(Person -> Person.salary)
				.average()
				.getAsDouble();
	}
	

}
