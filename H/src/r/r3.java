package r;

public class r3 {

	public static void main(String[] args) {
		
		int[] array = {4, 0, -3, 1, -6};
		boolean NegBigger = comp(array);
		System.out.println("Are negatives bigger than positives? " + NegBigger);
		
		int[] list = {4, 7, 9, 14, 14};
		asc(list);
		
		int side1 = 10;
		int side2 = 12;
		form(side1, side2);
		
		int cipars = 5;
		cip(cipars);
		
		int[] list2 = {5, 2, -3, 0};
		cip(list2);
		
		int look = 14;
		int times = count(list, look);
		System.out.println(look + " is found " + times + " times in this array!");
		
		int number = 1;
		printer(number);
		
		String[] name = {"eve", "esa", "ras", "ra"};
		int[] sallary = {200, 300, 400, 100};
		richest(name, sallary);
		
		boolean eee = name[1].substring(name[1].length()-1).equals("a");
		System.out.println(name[1].substring(name[1].length()-1));
		System.out.println(eee);
		System.out.println(name[1].lastIndexOf("sa"));
		

	}
	static void richest(String[] a, int[] b) {
		int big = 0;
		for (int i = 0 ; i < b.length ; i++) {
			if(b[i]>big && a[i].substring(a[i].length()-1).equals("a") || a[i].substring(a[i].length()-1).equals("e")) {
				big = b[i];
			}
		}
		for (int j = 0; j < b.length; j++) {
			if(b[j] == big) {
				System.out.println(a[j] + " has the largest sallary of " + b[j]);
			}
		}
	}
	static void printer(int a) {
		if(a==-2) System.out.println("Minus Two");
		if(a==-1) System.out.println("Minus One");
		if(a==0) System.out.println("Zero");
		if(a==1) System.out.println("One");
		if(a==2) System.out.println("Two");
	}
	static int count(int[] a, int b) {
		int c = 0;
		for (int i : a) {
			if(i == b) c++;
		}
		return c;
	}
	static void cip(int[] a) {
		for (int i = 0; i < a.length; i++) {
			if(a[i] > 0) System.out.println("Pozitive!");
			if(a[i] < 0) System.out.println("Negative!");
			if(a[i] == 0) System.out.println("Neutral!");
			
		}
	}
	static void cip(int a) {
		if(a > 0) System.out.println("Pozitive!");
		if(a < 0) System.out.println("Negative!");
		if(a == 0) System.out.println("Neutral!");
	}
	
	static void form(int a, int b) {
		if(a <=0 || b <=0) {
			System.out.println("Invalid input!");
		}
		else if(a != b) {
			System.out.println("It is a rectangle!");
		} else {
			System.out.println("It is a square!");
		}
	}
	
	static void asc(int[] a) {
		for (int i = 1; i < a.length; i++) {
			if(a[i] > a[i-1]) {
				continue;
			} else {
				System.out.println("This list is not in ascending order!");
				return;
			}
		}
		System.out.println("This list is in ascending order!");
		
	}
	
	static boolean comp(int[] a) {
		int pos = 0;
		int neg = 0;
		for (int i : a) {
			if(i>0) {
				pos += i;
			} else {
				neg += i;
			}
		}
		System.out.println("Result is " + (pos + neg));
		if(pos + neg < 0) {
			return true;
		} else if(pos + neg > 0) {
			return false;
		} else {
			System.out.println("They are equal");
			return false;
		}
	}

}
