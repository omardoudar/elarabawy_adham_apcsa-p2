//Name: Adham Elarabawy

public class RecursionFunOne {
	
	public static int countEvenDigits(int num) {
		
		int count = 0;
		
		if(num % 2 == 0)
			count = 1;
		

		if(num / 10 == 0)
			return count;
		
			
		return count + countEvenDigits(num / 10);
	}
}