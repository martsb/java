package r;

public class r1 {

	public static void main(String[] args) {
		
		int[] array2 = new int[] {3, 1, 5};
		int[] array3 = new int[] {4, 2, 6};
		System.out.println("");
		for(int i = 0; i < array2.length ;i++) {
			for(int e = 0; e < array3.length ;e++) {
						System.out.println(array2[i] + " " + array3[e]);
			}
		}
	
		
			printRange(2, 10);
			printRange(-4, 5);
			printRange(-4, -15);
			int[] values = {1, 4, 7, 4};
			changeArray(values, 777, 4);
			System.out.println(getLargest(0,0,200));
		}
		static int getLargest(int a, int b, int c) {
			if (a>b && a>c) return a;
			if(b>c) return b;
			return c;
		}
		
		static void changeArray(int[] array, int add, int toReplace) {
			int[] newArray = new int[array.length + 1];
			for (int i= 0; i < array.length; i++) {
				newArray[i] = array[i];
				if (newArray[i] == toReplace) {
					newArray[i] = 0;
				}
			}
			newArray[newArray.length - 1] = add;
			
		}
		static void printRange(int from, int to) {
			if(from > to) {
				int temp = from;
				from = to;
				to = temp;
			}
			System.out.println("Nunbers");
			System.out.print("[");
			for(int i = from; i<=to ;i++)
				System.out.print(i + ", ");
			System.out.println("]");
		}
		/* 
		That 6      
		That one -4
		what is 0
		that is 0
		
		Is the loop
		Small -4
		Large 3
		Small 0
		Large 10
		Large 9
		Small -8
		
		Large 2
		Large 3
		Small -4
		Small -1
		Small 0
		Large 10
		
		Small 0
		Small -3
		Large 3
		Small -4
		Bango
		
		I gotcha 5
		Cha 3
		Cha 3.4
		Cha 2.44
		Cha 3
		Chat 3.14
		You gotcha!
		---
		Cha 3
		Cha -4.3
		Cha -2.84
		Got 5
		You gotcha!
		---
		You gotcha!
		
		 */
	}

	



