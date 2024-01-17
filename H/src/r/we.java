package r;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class we {
	static int round = 1;
	static int score = 0;
	public static void main(String[] args) {
		List<String> qList = new ArrayList<String>();
		List<String> aList = new ArrayList<String>();

		try {
			String path = "C:\\Users\\Marts Druvis Lauma\\Desktop\\info.txt";
			File file = new File(path);
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) { //looping question lines
			String[] parts = sc.nextLine().split(";"); //split into array
			askQuestion(parts); //passing each question to its method
			}
			sc.close(); //closing the Scanner
			System.out.println("Your final score is: "+score+"/10");
			} catch (Exception e) {
			System.out.println("Couldn't read file");
			}
			}
		static void askQuestion(String[] questionArray) {
			Scanner a = new Scanner(System.in);
			System.out.println("=== Round "+round+" ===");
			System.out.println(questionArray[0]); //prints 0th element - the question
			//gets position of correct answer
			int correct = Integer.parseInt(questionArray[questionArray.length-1]);
			//loops all answer options (all array except 0th and last elements)
			for (int i=1; i<questionArray.length-1; i++) {
				String option = questionArray[i];
				System.out.println(i+") " +option);
			}
			//prints correct answer
			String aa = a.nextLine();
			if(aa.matches(questionArray[correct])) { 
				System.out.println("Correct!");
				score ++;
			} else {
				System.out.println("Incorrect!");
			}
			System.out.println("Your answer: "+aa);
			System.out.println("Correct answer: " + questionArray[correct]);
			System.out.println("-----------------" +System.lineSeparator());
			round++;
			a.close();
		}

	
}
