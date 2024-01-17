package majasDarbi;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class fp {

	public static void main(String[] args) {
		try {
			String path = "C:\\Users\\Marts Druvis Lauma\\Desktop\\task1.txt";
			File file = new File(path);
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
			yes(sc.nextLine());
			}
			sc.close();
			} catch (IOException e) {
			System.out.println("Couldn't read file");
			}
	}
	static void yes(String a) {
		String[] parts = a.split(".");
		if(parts.length < 3) {
			
		}
	}

}
