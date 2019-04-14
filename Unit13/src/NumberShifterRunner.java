//(c) A+ Computer Science
//www.apluscompsci.com

//Name: Adham Elarabawy

import java.io.IOException;
import java.util.Arrays;

public class NumberShifterRunner {
	
	public static void main(String args[]) throws IOException {
		
		for(int i = 0; i < 3; i++) {
			
			int[] rand = NumberShifter.makeLucky7Array(20);
			System.out.println(Arrays.toString(rand));

			NumberShifter.shiftEm(rand);

			System.out.println(Arrays.toString(rand));
			System.out.println();
		}
	}
}
