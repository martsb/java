package majasDarbi;

public class MartsBicevskisH3 {

	public static void main(String[] args) {
		
		//1
		double[] arr1 = {1.5, 3, 4.01, 6};
		int value1 = 0;
		Darray(arr1, value1);
		
		//2
		int rangeFrom = 15;
		int rangeTo = 35;
		int div = 9;
		division(rangeFrom, rangeTo, div);
		
		//3
		int[] arr2 = {12, 1, 16, 9};
		int border1 = 3;
		int border2 = 12;
		avrValue(arr2, border1, border2);
		
		//4
		int[] list1 = {5, 1, 7, 6};
		int[] list2 = {8, 1, 2, 6};
		int diff = lists(list1, list2);
		System.out.println("Returned value: " + diff);
		
	}
	
	//4
	static int lists(int[] a, int[] b) {
		int diff = 0;
		if(a.length == b.length) {
			
			for (int i = 0; i < a.length; i++) {	
				if(a[i] != b[i]) {
					diff ++;
				}
			}		
			System.out.println("Arrays have same length, " + diff + " values differ.");
			
			
		} else {
			System.out.println("Array have different length.");
		}
		return diff;
	}
	
	//3
	static void avrValue(int[] a, int b, int c) {
		double total = 0;
		double elem = 0;
		for (int i = 0; i < a.length; i++) {
			if(a[i] >= b && a[i] <= c) {
				total += a[i];
				elem++;
			}
		}
		System.out.println("Avarage value is: " + total/elem);
	}
	//2
	static void division(int a, int b, int c) {
		for (int i = a ; i <= b; i++) {
			if(i % c == 0) {
				System.out.println(i + " is the first one between " + a + " and " + b + " that can be divided with " + c);
				break;
			}
		}
	}
	//1
	static void Darray(double[] a, int b) {
		for (int i = 0; i < a.length; i++) {
			if(a[i] % 1 == 0) {
				b += a[i];
				continue;
			}
		}
		System.out.println("Sum1 = " + b);
	}
	
	
	
}
