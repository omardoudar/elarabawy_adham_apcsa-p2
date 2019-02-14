//(c) A+ Computer Science
//www.apluscompsci.com

//Name - 
//Date - 
//Class - 
//Lab - 

public class WordsCompare {
	
	private String wordOne, wordTwo;
	private int compare;

	public WordsCompare(String one, String two) {
		wordOne = one;
		wordTwo = two;
		compare();
	}

	public void compare() {
		compare = wordOne.compareTo(wordTwo);
	}

	public String toString() {
		if (compare < 0){
			return wordOne + " should be placed before " + wordTwo;
		}
		return wordOne + " should be placed after " + wordTwo;
	}
}