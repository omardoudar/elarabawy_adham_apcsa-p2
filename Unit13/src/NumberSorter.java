//Name: Adham Elarabawy

public class NumberSorter {

	private static int getNumDigits(int number) {
		int count = 0;
		while(number > 0) {
			count++;
			number/=10;
		}
		return count;
	}

	public static int[] getSortedDigitArray(int number) {
		int[] done = new int[getNumDigits(number)];
		
		int index = 0;
		while(number > 0) {
			done[index] = number % 10;
			number /= 10;
			index++;
		}
		boolean action = false;
		while(action) {
			action = true;	
			for(int i = 1; i < done.length; i++) {
				if((done[i - 1] + "").compareTo(done[i] + "") > 0) {
					
					int temp = done[i - 1];

					done[i - 1] = done[i];
					done[i] = temp;

					action = true;
				}
			}
		}
		return done;
	}
}