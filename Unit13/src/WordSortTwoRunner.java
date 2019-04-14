//Name: Adham Elarabawy

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class WordSortTwoRunner {
	
	public static void main(String args[]) throws IOException {
		
		Scanner file = new Scanner(new File("src/wordsorttwo.dat"));
		int size = file.nextInt();
		
		file.nextLine();
		
		for (int i = 0; i < size; i++) {
			String sentence = file.nextLine();
			
			WordSortTwo ws2 = new WordSortTwo(sentence);
			
			ws2.sort();
			
			System.out.println(ws2);
		}
	}
}