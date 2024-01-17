package td;


import java.util.ArrayList;
import java.util.HashSet;

public class Person {
	String firstName;
	String lastName;
	int age;
	String gender; //M|F
	String city;
	int salary;
	boolean isWorking;
	
	ArrayList<String> pets = new ArrayList<String>();
	static final int MIN_ADULT_AGE = 18;
	static final int MIN_PENSION_AGE = 60;
	static ArrayList<Person> all = new ArrayList<Person>();
	Person(String first, String last, String s, int age, int money, String city, ArrayList<String> pets) {
		this.firstName = first;
		this.lastName = last;
		this.age = age;
		this.salary = money;
		this.isWorking = this.salary > 0; 
		this.pets = pets;
		this.city = city;
		this.gender = s;
		Person.all.add(this);
		City.populate(this);
	}
	int getAge() {
		return this.age;
	}
	int getSalary() {
		return this.salary;
	}
	boolean isAdult() {
		return !this.isKid() && !this.isPensioner();
	}
	boolean isKid() {
		return this.age < MIN_ADULT_AGE;
	}
	boolean isPensioner() {
		return this.age >= MIN_PENSION_AGE;
	}
	boolean isMale() {
		return this.gender.equals("M");
	}
	boolean isFemale() {
		return !this.isMale();
	}
	String getFullname() {
		return this.firstName+" "+this.lastName;
	}
	public String toString() {
		return this.getFullname()+" is " +this.age+"\n"
				+(this.isMale() ? "He": "She")+" lives in " +this.city
				+(this.isWorking ? " and earns " +this.salary+"€" : "and is unemployed")+"\n"
				+(this.isMale() ? "He": "She")+" has " 
				+this.pets.size()+" pet"+(pets.size()==1?"":"s")+": " +this.pets+"\n";
	}
	//Started making these before realizing that I have to use Stream
	//Extra
	static void printMostPensionersCity() {
		City city = null;
		double count = 0;
		double highest = 0;
		for (int i = 0; i < City.list.size(); i++) {
			
			for (int j = 0; j < City.list.get(i).people.size(); j++) {
				if(City.list.get(i).people.get(j).age >= Person.MIN_PENSION_AGE) {
					count ++;
				}
			}
			count /= City.list.get(i).population;
			if(city == null || count > highest) {
				city = City.list.get(i);
				highest = count;
			}
			count = 0;
		}
		System.out.println(city.name + " has the highest % of pensioners: " + 100 * highest);
	}
	// Extra
	static void printCityDemographics(String city) {
		for (int i = 0; i < City.list.size(); i++) {
			if(City.list.get(i).name.equals(city)) {
				double kid = 0;
				double ad = 0;
				double old = 0;
				for (int j = 0; j < City.list.get(i).people.size(); j++) {
					if(City.list.get(i).people.get(j).age < Person.MIN_ADULT_AGE) {
						kid ++;
					} else if(City.list.get(i).people.get(j).age >= Person.MIN_PENSION_AGE) {
						old ++;
					} else {
						ad ++;
					}
				}
				System.out.println(City.list.get(i).name + " has demographics of: \n" + 
								   Math.round(100*kid / City.list.get(i).population) + "% kids\n" + 
								   Math.round(100*ad / City.list.get(i).population) + "% adults\n" + 
								   Math.round(100*old / City.list.get(i).population) + "% pensioners");
			}

		}
	}
	// 9.
	static void printCityPopulation(String city) {
		for (int i = 0; i < City.list.size(); i++) {
			if(City.list.get(i).name.equals(city)) System.out.println("9. " + City.list.get(i).name + " has population of " + City.list.get(i).population);
		}
		
	}

	// 10.
	static City populatestCity() {
		City most = null;
		for (int i = 0; i < City.list.size(); i++) {
			if(most == null || City.list.get(i).population > most.population) {
				most = City.list.get(i);
			}
			
		}
		return most;
	}
	// 7.
	static int uniqueLastNameCount() {
		HashSet<String> list = new HashSet<String>();
		for (int i = 0; i < Person.all.size(); i++) {
			list.add(Person.all.get(i).lastName);
		}
		return list.size();
		
	}
	// Obviously I didn't read the task, so I made these first...
	// 7.
	static int uniqueFirstNameCount() {
		HashSet<String> list = new HashSet<String>();
		for (int i = 0; i < Person.all.size(); i++) {
			if(Person.all.get(i).firstName.startsWith("Dr. ")) {
				list.add(Person.all.get(i).firstName.substring(4));
			} else {
				list.add(Person.all.get(i).firstName);
			}
		}
		return list.size();
	}
	// 6.
	static double avgAgeWhereLives(Person person) {
		double total = 0;
		int count = 0;
		for (int i = 0; i < Person.all.size(); i++) {
			if(Person.all.get(i).city.equals(person.city)) {
				total += Person.all.get(i).age;
				count ++;
			}
		}
		return total / count;
	}
	// 6.
	static Person youngestPerson() {
		Person youngest = null;
		for(int i = 0; i < Person.all.size(); i++) {
			if(youngest == null || Person.all.get(i).age < youngest.age) {
				youngest = Person.all.get(i);
			}
		}
		return youngest;
	}
	// 5.
	static int petCountNamed(String name) {
		int total = 0;
		for(int i = 0; i < Person.all.size(); i++) {
			for (int j = 0; j < Person.all.get(i).pets.size(); j++) {
				if(Person.all.get(i).pets.get(j).contains(name)) {
					total ++;
				}
			}
		}
		return total;
	}
	// 4.
	static int totalPetCount() {
		int total = 0;
		for(int i = 0; i < Person.all.size(); i++) {
			total += Person.all.get(i).pets.size();
		}
		return total;
	}
	// 3.
	static double AvgDrSalary() {
		double total = 0;
		int count = 0;
		for(int i = 0; i < Person.all.size(); i++) {
			if(Person.all.get(i).firstName.startsWith("Dr.")) {
				total += Person.all.get(i).salary;
				count ++;
			}
		}
		return total / count;
	}
	// 2.
	static Person findCitiesOldestWorker(String city) {
		Person oldest = null;
		for (int i = 0; i < Person.all.size(); i++) {
			if(Person.all.get(i).city.matches(city) &&
			  Person.all.get(i).isWorking && 
			  (oldest == null || Person.all.get(i).age > oldest.age)) {
				
				oldest = Person.all.get(i);
			}
			
		}
		return oldest;
	}
	// 1.
	static double avgAdultSalary() {
		double total = 0;
		int count = 0;
		for (int i = 0; i < Person.all.size(); i++) {
			if(Person.all.get(i).age >= Person.MIN_ADULT_AGE && Person.all.get(i).age < Person.MIN_PENSION_AGE) {
				total += Person.all.get(i).salary;
				count ++;
			}
		}
		return total / count;
		
	}
}
