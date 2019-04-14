import java.util.Random;
//Name: Adham Elarabawy

public class NumberShifter {
	
	public static int[] makeLucky7Array(int size) {
		
		int[] nums = new int[size];
		Random rand = new Random();
		for(int i = 0; i < size; i++) {
			nums[i] = rand.nextInt(10) + 1;
		}
		return nums;
	}

	public static void shiftEm(int[] array) {
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] == 7) {

				for(int j = i; j > 0; j--) {
					array[j] = array[j - 1];
				}
				array[0] = 7;
			}
		}
	}
}