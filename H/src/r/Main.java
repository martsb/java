package r;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

	public static void main(String[] args) {
		Plane p1 = new Plane("Airlines", 52, 1200, 42, 2, "Landplane");
		Plane p2 = new Plane("Airlines", 53, 1300, 33, 4, "Seaplane");
		Plane p3 = new Plane("Airlines", 67, 1500, 31, 2, "Landplane");
		Boat b1 = new Boat("Seaways", 14, 350, 21, "Ship", 6);
		Boat b2 = new Boat("Seaways", 13, 420, 42, "Yacht", 4);
		Boat b3 = new Boat("Seaways", 15, 440, 13, "Kayak", 2);
		Vehicle v1 = new Vehicle("Ford", 5, 240, 6);
		
		System.out.println("The average fuel spent by passenger for this vehicle is " + p1.getFuelPerPassenger());
		System.out.println("Is first vehicle faster than second? " + b1.isFaster(b2));
		System.out.println("This boat has " + b1.getPaddleCount() + " paddles");
		System.out.println("Can this plane land on water? " + p1.canLandOnWater());
		System.out.println("Boats on average have " + Boat.getAvgPaddleCount() + " paddles");
		System.out.println(p2.canLandOnWaterCount() + " plane(s) can land on water");
		System.out.println("There are " + Boat.getBoatCount() + " boats in here");
		System.out.println(v1);
		
		String url = "https://sportacentrs.com/jaunumi?page=1";
		Document doc = Weber.getPage(url);
		Elements titles = doc.select("h2.title");
		for (Element title : titles) {
			System.out.println(title.text());
			Element time = title.selectFirst("time");
			System.out.println(time.text());
		}
		try {
			String path = "C:/Users/user/Desktop/was.docx";
			File file = new File(path);
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
			printWorkdayInfo(sc.nextLine());
			}
			sc.close();
			} catch (IOException e) {
			System.out.println("Couldn't read file");
			}
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
		}
}
