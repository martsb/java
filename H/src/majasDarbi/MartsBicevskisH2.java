package majasDarbi;

public class MartsBicevskisH2 {

	public static void main(String[] args) {
		int[] array1 = new int[] {3, 4, -3, 0, 12};
		
		numbers(array1, 3, 7);

		System.out.println();
		
		int[] array2 = new int[] {4, 2, -5, 7};
		int[] array3 = new int[] {8, 3, -9, 2};
		for(int i = 0; i < array2.length ;i++) {
			for(int e = 0; e < array3.length ;e++) {
						compare(array2[i], array3[e], i+1, e+1);
			}
		}	
		System.out.println(cube(1, 6, 4));

		
		
				}
	//task 1
	static void numbers(int[] array, int border1, int border2) {
		int count = 0;
		for(int i = 0; i < array.length ;i++) {
			if (array[i] >= border1 && array[i] <= border2) {
				 count++;
			}
		}
		System.out.print( "There are " + count + " numbers in the array are between " + border1 + " and " + border2 + ". These are: ");
		for(int i = 0; i < array.length ;i++) {
			if (array[i] >= border1 && array[i] <= border2) {
				System.out.print(array[i] + " ");
			}
		}

	}
	//task 3
	static boolean cube(int a, int b, int c) {
		
				return a == b && b == c;
	}
	//task 2
	static void compare(int a, int b, int i, int e) {
		if(a == b) {
			System.out.println("Position " + i + " has the same value as Position " + e + ", which is: " + a);
		}
	}
	
}


				
				
			
			
		
			
			
	
	
	
	//*public static void printRange(int from, int to) {
	
	//	System.out.println("Nunbers");
	//	System.out.print("[");
	//	for(int i = 0; i < 2 ;i++)
	//		if()
	//		System.out.print(i + " ");
	//	System.out.println("]");

	


