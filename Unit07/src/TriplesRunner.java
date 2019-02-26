//(c) A+ Computer Science
// www.apluscompsci.com
//Name: Adham Elarabawy

import static java.lang.System.*;

import java.util.Scanner;

public class TriplesRunner
{
   public static void main(String args[])
   {
	   Scanner kb = new Scanner(in);
	   out.println("Enter a number :: ");
	   int i = kb.nextInt();

	   Triples obj = new Triples(i);
	   out.println(obj);
   }
}