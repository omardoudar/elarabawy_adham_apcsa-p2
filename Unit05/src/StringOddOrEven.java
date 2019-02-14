//(c) A+ Computer Science
//www.apluscompsci.com

//Name - 
//Date - 
//Class - 
//Lab - 

public class StringOddOrEven {
	
	private String temp;

	public StringOddOrEven(String s) {
		temp = s;
	}

	public boolean isEven() {
		
		if(temp.length() % 2 == 0) {
			return true;
		}
		return false;
	}

	public String toString() {
		
		if(isEven()) {
			return temp + " is even.";
		}
		return temp + " is odd.";
	}
}