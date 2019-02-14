//(c) A+ Computer Science
//www.apluscompsci.com

//Name - 
//Date - 
//Class - 
//Lab - 

public class StringEquality {

	private String wordOne, wordTwo;
	private boolean isEqual;
	public StringEquality(String one, String two) {
		wordOne = one;
		wordTwo = two;
		checkEquality();
	}
	public void checkEquality() {
		if(wordOne.equals(wordTwo)) {
			isEqual = true;
		} else {
			isEqual = false;
		}
	}

	public String toString() {
		if(isEqual) {
			return wordOne + " has the same letters as " + wordTwo;
		}
		return wordOne + " does not have the same letters as " + wordTwo;
	}
}