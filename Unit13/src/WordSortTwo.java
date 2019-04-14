//Name: Adham Elarabawy

public class WordSortTwo {
	
	private String[] tempArr;

	public WordSortTwo(String sentence) {
		
		tempArr = sentence.split(" ");
	}

	public void sort() {
		
		boolean action = true;
		while(action) {
			action = false;
			
			for(int i = 1; i < tempArr.length; i++) {
				if(tempArr[i - 1].compareTo(tempArr[i]) > 0) {
					
					String temp = tempArr[i - 1];
					
					tempArr[i - 1] = tempArr[i];
					tempArr[i] = temp;
					
					action = true;
				}
			}
		}
	}

	public String toString() {
		String output = "";
		
		for(String s : tempArr) {
			output += s + "\n";
		}
		
		return output + "\n\n";
	}
}