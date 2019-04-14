//Name: Adham Elarabawy

public class Grid {
	
	private String[][] grid;

	public Grid(int rows, int cols, String[] vals) {
		
		grid = new String[cols][rows];
		
		for(int i = 0; i < cols; i++) {
			
			for(int jTemp = 0; jTemp < rows; jTemp++) {
				int x = (int) Math.floor(Math.random() * vals.length);
		
				grid[i][jTemp] = vals[x];
			}
		}

		for(int i = 0; i < cols; i++) {
		
			for(int jTemp = 0; jTemp < rows; jTemp++) {
				
				System.out.print(grid[i][jTemp] + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("\n" + findMax(vals));
	}

	public String findMax(String[] vals) {
		
		int[] counts = new int[vals.length];
		
		for(int i = 0; i < vals.length; i++) {
		
			int count = countVals(vals[i]);
		
			counts[i] = count;
		
			System.out.println(vals[i] + " count is " + count);
		}
		
		int max = counts[0];
		String letter = vals[0];
		
		for(int i = 1; i < counts.length; i++) {
		
			if(counts[i] > max) {
		
				max = counts[i];
				letter = vals[i];
			}
		}
		return letter + " occurs the most.";
	}

	private int countVals(String val) {
		
		int count = 0;
		for(String[] i : grid) {
		
			for(String jTemp : i) {
		
				if(jTemp.equals(val))
					count++;
			}
		}
		
		return count;
	}

	public String toString() {
		String output = "";
		return output;
	}
}