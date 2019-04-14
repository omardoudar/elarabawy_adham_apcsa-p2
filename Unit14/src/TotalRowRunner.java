import java.util.List;
//Name: Adham Elarabawy

public class TotalRowRunner {

	public static void main(String args[]) throws Exception {

		printIt((new int[][] { { 1, 2, 3 }, { 5, 5, 5, 5 } }));

		printIt((new int[][] { { 1, 2, 3 }, { 5 }, { 1 }, { 2, 2 } }));
		
		printIt((new int[][] { { 1, 2 }, { 5, 5 }, { 5, 5 }, { 4, 5, 6, 7 }, { 123124, 12312 } }));
	}

	private static void printIt(int[][] matrix) {

		List<Integer> tempTotals = TotalRow.getRowTotals(matrix);
		
		System.out.println("Row totals are :: " + tempTotals);
	}
}
