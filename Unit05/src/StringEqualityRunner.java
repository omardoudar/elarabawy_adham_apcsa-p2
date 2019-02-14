import java.util.Scanner;

//(c) A+ Computer Science
//www.apluscompsci.com

//Name - 
//Date - 
//Class - 
//Lab - 

public class StringEqualityRunner {
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("ENTER THE FIRST STRING :: ");
		String firstString = sc.next();
		System.out.print("ENTER THE SECOND STRING :: ");
		String secondString = sc.next();
		System.out.println(new StringEquality(firstString, secondString).toString());
		
		// test
		System.out.println(new StringEquality("hello", "goodbye").toString());
		System.out.println(new StringEquality("one", "two").toString());
		System.out.println(new StringEquality("three", "four").toString());
		System.out.println(new StringEquality("TCEA", "UIL").toString());
		System.out.println(new StringEquality("State", "Champtions").toString());
		System.out.println(new StringEquality("ABC", "ABC").toString());
		System.out.println(new StringEquality("ABC", "CBA").toString());
		System.out.println(new StringEquality("Same", "Same").toString());
	}
}