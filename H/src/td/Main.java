package td;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Integer[] oldNr = {4, 2, 5, 0, -4, 8};
		String[] oldNames = {"rweg", "wtwtwwt", "wttSVED", " rhgwerh"};
		List<Integer> nr = Arrays.asList(oldNr);
		List<String> names = Arrays.asList(oldNames);
		names.add("erer");
		for (int i = 0; i < oldNames.length; i++) {
			names.add(oldNames[i]);
		}
		for (int i = 0; i < oldNr.length; i++) {
			nr.add(oldNr[i]);
		}
		
		names.stream().filter(e -> e.contains("e")).collect(Collectors.toList());
		System.out.println(names);
		/*
		Thread aa = new kas(1, "aa");
		aa.start();
		Thread bb = new kas(5, "bb");
		bb.start();
		Thread cc = new Thread() {
			public void run() {
				System.out.println("grr");
			}
		};
		cc.start();
		try {
			Thread.sleep(20);
			} catch (Exception e) {
			System.out.println("Problems here");
			}
		
		new kas(4, "re");
		
		String es = "es";
		int ez = 10;
		System.out.println(es + " (" + ez + ")");
		System.out.println("Lir");
*/
	}
}
