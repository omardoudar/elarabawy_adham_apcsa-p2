//Name: Adham Elarabawy

public class MatrixCount1 {
	
	private static int[][] matrix = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 0 }, { 6, 7, 1, 2, 5 }, { 6, 7, 8, 9, 0 },
			{ 5, 4, 3, 2, 1 } };

	public static int count(int val) {
		
		int count = 0;
		for(int[] x : matrix) {
			
			for(int y : x) {
				
				if(y == val)
					count++;
			}
		}
		return count;
	}
}
