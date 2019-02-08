//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date - 
//Class -
//Lab  -

import static java.lang.System.*;
import java.util.Scanner;

public class StringOddOrEven
{
	private String word;

	public StringOddOrEven()
	{
	}

	public StringOddOrEven(String s)
	{
	}

	public void setString(String s)
	{
		this.word = s;
	}

 	public boolean isEven()
 	{
		if(word.length()%2 == 0){
			return true;
		} else {
			return false;
		}
	}

 	public String toString()
 	{
 		if(isEven()){
			return word + " is even";
		} else {
			return word + " is odd";
		}
	}
}