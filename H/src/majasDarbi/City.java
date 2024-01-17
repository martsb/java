package majasDarbi;
import java.util.ArrayList;

public class City {
	String name;
	String country;
	int population = 0;
	boolean hasStadium;
	
	static ArrayList<City> all = new ArrayList<City>();
	
	City(String n, String c, int p, boolean s){
		this.name = n;
		this.country= c;
		this.population = p;
		this.hasStadium = s;
		
		City.all.add(this);
		
	}
	boolean isSmall() {
		if(this.population < 30000) {
			return true;
		} else {
			return false;
		}
	}
	boolean isCool() {
		if((this.country == "Latvia" || this.country == "Ukraine") && this.hasStadium == true) {
			return true;
		} else {
			return false;
		}
	}
	boolean isStan() {
		if(this.country.endsWith("stan")) {
			return true;
		} else {
			return false;
		}
	}
}

