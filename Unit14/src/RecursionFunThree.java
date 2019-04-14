//Name: Adham Elarabawy

public class RecursionFunThree {
	public static int luckyThrees(long number) {
		
		int count = 0;

		if(number == 3)
			return 0;
				
		if(number % 10 == 3)
			count = 1;
		
		if(number / 10 == 0)
			return count;
		
		return count + luckyThrees(number / 10);
	}
}