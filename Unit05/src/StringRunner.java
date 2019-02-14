//(c) A+ Computer Science
//www.apluscompsci.com

//Name - 
//Date - 
//Class - 
//Lab - 

import java.util.Scanner;

public class StringRunner {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("ENTER A STRING :: ");
		String tempValue = sc.next();
		System.out.println(new StringOddOrEven(tempValue).toString());
		
		//Test
		System.out.println(new StringOddOrEven("cat").toString());
		System.out.println(new StringOddOrEven("boot").toString());
		System.out.println(new StringOddOrEven("it").toString());
		System.out.println(new StringOddOrEven("a").toString());
		System.out.println(new StringOddOrEven("eleven").toString());
		System.out.println(new StringOddOrEven("thirteen").toString());
		System.out.println(new StringOddOrEven("odd").toString());
		System.out.println(new StringOddOrEven("even").toString());
	}
}