package r;

public class r2 {

		public static void main(String[] args) {
			//Task 1
			int[] array = {-4, 3, 0, 10, 9, -8};
			int what = thatStuff(array, array[1]);
			int that = thatStuff(array, array[0]);
			System.out.println("what is " +what);
			System.out.println("that is " +that);
			
			//Task 2
			int[] nums = {2, 3, -4, -1, 0, 10};
			int[] numbers = {0, -3, 3, -4};
			boolean whatWeGot = loop(array);
			boolean whatWeHave = loop(nums);
			boolean whatWeTook = loop(numbers);
			if (whatWeGot || whatWeHave && whatWeTook) {
				System.out.println("Bingo");
			} else {
				System.out.println("Bango");
			}
			
			//Task 3
			int yes = 3;
			double[] sums = {yes, yes + 0.4, 2.44, 3, Math.PI};
			double[] dums = {yes, -4.3, -2.84, 5};
			double[] bums = {};
			gotcha(sums, 5);
			System.out.println("---");
			gotcha(dums, yes);
			System.out.println("---");
			gotcha(bums, yes * 2);
		}
		
		static void gotcha(double[] nums, int yes) {
			System.out.println("I gotcha " +yes);
			for (int x = 0; x < nums.length; x++) {
				if (nums[x] > yes) {
					System.out.println("Got " +nums[x]);
				} else {
					System.out.println("Cha " +nums[x]);
				}
			}
			System.out.println("You gotcha!");
		} 
		
		public static boolean loop(int[] numbers) {
			System.out.println("Is the loop");
			boolean result = true;
			for (int i=0; i<numbers.length;i++) {
				if (numbers[i] > 0) {
					System.out.println("Large " +numbers[i]);
					result = true;
				} else {
					System.out.println("Small " +numbers[i]);
					result = false;
				}
			}
			return result;
		}
		
		public static int thatStuff(int[] data, int element) {
			if (data.length > element) {
				System.out.println("That " +data.length);
			} else {
				System.out.println("That one " +element);
			}
			return data[2] * element;
		}

	}