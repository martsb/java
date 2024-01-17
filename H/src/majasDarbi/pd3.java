package majasDarbi;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class pd3 {

	public static void main(String[] args) {
		City c1 = new City("Valmiera", "Latvia", 25000, true);
		City c2 = new City("Kiev", "Ukraine", 2000000, true);
		City c3 = new City("Brenguli", "Latvia", 1000, false);
		City c4 = new City("Cesis", "Latvia", 15000, true);
		City c5 = new City("Tartu", "Estonia", 100000, true);
		City c6 = new City("Islamabad", "Pakistan", 1000000, true);
		City c7 = new City("Durshanbe", "Tajikistan", 700000, true);
		int sum = 0;
		int div = 0;
		for (City s : City.all) {
			if(s.isCool() && s.isSmall()) {
				sum += s.population;
				div++;
			}
		}
		try {
			int avg = sum / div;
			System.out.println("Average population of small cities is: " + avg);
			} catch (Exception zeException) {
				System.out.println("There are no Cool Small cities!");
		}
		
		Set<String> set = new HashSet<String>();
		for (City s : City.all) {
			set.add(s.country);
		}
		System.out.println("All the countries in list are: " + set);
		
		int bigStan = 0;
		for (City s : City.all) {
			if(s.isStan() && s.population > bigStan) {
				bigStan = s.population;
			}
		}
		System.out.println("The largest stan city is " + bigStan);
		
		// 2. uzd
		InstagramPost p1 = new InstagramPost("Joe", "Some text", 100);
		InstagramPost p2 = new InstagramPost("Jerry", "Other text", 200);
		InstagramPost p3 = new InstagramPost("Tom", "This is text", 150);
		InstagramPost p4 = new InstagramPost("Jerry", "#flatEarth text", 400);
		InstagramPost p5 = new InstagramPost("Jerry", "It's me again", 0);
		InstagramPost p6 = new InstagramPost("Tom", "Nope!", 500);
		InstagramPost.likesForUser("Tom");
		InstagramPost.isLame();
		InstagramPost.isLonely();
		InstagramPost.isLameLonely();
	}

}