package majasDarbi;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MartsBicevskisH5 {

	public static void main(String[] args) {
		try {
			String path = "C:\\Users\\Marts Druvis Lauma\\Desktop\\info.txt";
			File file = new File(path);
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
			printWorkdayInfo(sc.nextLine());
			}
			sc.close();
			} catch (IOException e) {
			System.out.println("Couldn't read file");
			}
			th a = new th("a", "a", 1);
			System.out.println(a);
			}
			static void printWorkdayInfo(String dayInfo) {
			//Split into array of day name and hour info
			String[] parts = dayInfo.split(":");
			//if invalid data, returns from method
			if (parts.length!=2) return;
			String day = parts[0];
			if (parts[1].equals("-")) {
			System.out.println(day+" ==> We are closed");
			return;
			}
			//Splits hour info into from/to parts.
			String[] hours = parts[1].split("-");
			//Again - if invalid, returns
			if (hours.length!=2) return;
			//Normalizing data
			String from = hours[0]+":00";
			String to = hours[1]+":00";
			//Prints info
			System.out.println(day+" ==> " +from+ " - " +to);

						
		

	}
			

}
