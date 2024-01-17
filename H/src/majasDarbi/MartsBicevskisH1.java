package majasDarbi;

public class MartsBicevskisH1 {

	public static void main(String[] args) {
	int[] array1 = new int[] {3, 0, 1, 4, -5, 2, -6};
	int[] array2 = new int[] {6, 4, 0, -6, 3, 0,  8};
	int zeros1 = 0;
	int zeros2 = 0;
	int sum1 = 0;
	int sum2 = 0;

	
	for(int i=0; i<array1.length; i++) {
		sum1 += array1[i];
		if (array1[i] == 0) {
		zeros1++;
	}
		}
 	
	for(int i=0; i<array2.length; i++) {
		sum2 += array2[i];
		if (array2[i] == 0) {
		zeros2++;
    }
		}
	
	if(zeros1 > zeros2) {
		System.out.println("The most zeros are in the " + zeros1 + " array. " + zeros1 + " in total.");
	}
	else if(zeros1 < zeros2) {
		System.out.println("The most zeros are in the " + zeros2 + " array. " + zeros2 + " in total.");
	}
	else {
		System.out.println("There are equal anount of zeros. " + zeros1 + " in each.");
	}
	
	if(sum1 > sum2) {
		System.out.println("The array1 has the largest total value.");
	}
	else if(sum1 < sum2) {
		System.out.println("The array2 has the largest total value.");
	}
	else {
		System.out.println("The arrays have equal value.");
	}
	
	}
}