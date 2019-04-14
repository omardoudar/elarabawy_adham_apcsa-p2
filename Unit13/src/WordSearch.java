//Name: Adham Elarabawy

public class WordSearch {

	private String[][] oMatrix;
	private int rows;
	private int columns;

	public WordSearch(int size, String str) {
		
		oMatrix = new String[size][size];
		
		int index = 1;
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {

				oMatrix[i][j] = str.substring(index - 1, index);
				
				index++;
			}
		}
		
		rows = oMatrix.length;
		columns = oMatrix[0].length;
	}

	public boolean isFound(String word) {
		
		for(int i = 0; i < oMatrix.length; i++) {
			for(int j = 0; j < oMatrix[i].length; j++) {
				if(checkRight(word, i, j) || checkLeft(word, i, j) || 
						checkUp(word, i, j) || checkDown(word, i, j) || 
							checkDiagUpRight(word, i, j) || 
								checkDiagUpLeft(word, i, j) || 
									checkDiagDownRight(word, i, j) || 
										checkDiagDownLeft(word, i, j)) {
					
					return true;
				}
			}
		}
		return false;
	}

	public boolean checkRight(String w, int r, int c) {
		
		String test = "";
		
		for(int i = 0; i < w.length(); i++) {
			String check = getInBounds(r + i, c);
			if(check.equals(""))
				return false;
			test += check;
		}
		
		if(test.equals(w))
			return true;
		
		
			return false;
	}

	public boolean checkLeft(String w, int r, int c) {
		String test = "";
		
		for(int i = 0; i < w.length(); i++) {
			String check = getInBounds(r - i, c);
			
			if(check.equals(""))
				return false;
			test += check;
		}
		if(test.equals(w))
			return true;
		
		return false;
	}

	public boolean checkUp(String w, int r, int c) {
		String test = "";
		for(int i = 0; i < w.length(); i++) {
			String check = getInBounds(r, c - i);
			if(check.equals(""))
				return false;
			test += check;
		}
		if(test.equals(w))
			return true;
		
		return false;
	}

	public boolean checkDown(String w, int r, int c) {
		String test = "";
		
		for(int i = 0; i < w.length(); i++) {
			
			String check = getInBounds(r, c + i);
			
			if(check.equals(""))
				return false;
		
				test += check;
		}
		
		if(test.equals(w))
			return true;
		
		return false;
	}

	public boolean checkDiagUpRight(String w, int r, int c) {
		String test = "";
		
		for(int i = 0; i < w.length(); i++) {
		
			String check = getInBounds(r + i, c - i);
		
			if(check.equals(""))
				return false;
		
				test += check;
		}
		if(test.equals(w))
		
		return true;
		
		return false;
	}

	public boolean checkDiagUpLeft(String w, int r, int c) {
		String test = "";
		
		for(int i = 0; i < w.length(); i++) {
			String check = getInBounds(r - i, c - i);
		
			if(check.equals(""))
				return false;
		
				test += check;
		}
		
		if(test.equals(w))
			return true;
		
		return false;
	}

	public boolean checkDiagDownLeft(String w, int r, int c) {
		
		String test = "";
		
		for(int i = 0; i < w.length(); i++) {
			String check = getInBounds(r - i, c + i);
		
			if(check.equals(""))
				return false;
		
				test += check;
		
		}
		if(test.equals(w))
		
		return true;
		
		return false;
	}

	public boolean checkDiagDownRight(String w, int r, int c) {
		String test = "";
		
		for(int i = 0; i < w.length(); i++) {
		
			String check = getInBounds(r + i, c + i);
		
			if(check.equals(""))
				return false;
		
				test += check;
		}
		if(test.equals(w))
			return true;
		
		return false;
	}
	
	private String getInBounds(int r, int c) {
		
		if(c >= 0 && c < rows) {	
			if(r >= 0 && r < columns) {
				return oMatrix[c][r];
			}
		}
		return "";
	}

	public String toString() {
		
		String matrix = "";
		
		for(String[] i : oMatrix) {
		
			for(String j : i) {
		
				matrix += j + " ";
			}
		
			matrix += "\n";
		}
		return matrix;
	}
}
