//(c) A+ Computer Science
//www.apluscompsci.com

//Name - 
//Date - 
//Class - 
//Lab - 

import java.util.Scanner;

public class WordsCompareRunner {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("ENTER THE FIRST STRING :: ");
		String wordOne = sc.next();
		System.out.print("ENTER THE SECOND STRING :: ");
		String wordTwo = sc.next();
		System.out.println(new WordsCompare(wordOne, wordTwo).toString());
		
		// test
		System.out.println(new WordsCompare("abe", "ape").toString());
		System.out.println(new WordsCompare("giraffe", "gorilla").toString());
		System.out.println(new WordsCompare("one", "two").toString());
		System.out.println(new WordsCompare("fun", "funny").toString());
		System.out.println(new WordsCompare("123", "19").toString());
		System.out.println(new WordsCompare("193", "1910").toString());
		System.out.println(new WordsCompare("goofy", "godfather").toString());
		System.out.println(new WordsCompare("funnel", "fun").toString());
	}
}