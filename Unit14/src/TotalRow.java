//Name: Adham Elarabawy

import java.util.*;

public class TotalRow {
	
	public static List<Integer> getRowTotals(int[][] m) {

		List<Integer> added = new ArrayList<Integer>();
		
		int sum;
		
		for(int[] i : m) {
			sum = 0;
			
			for(int j : i) {
				sum += j;
			}
			added.add(sum);
		}
		
		return added;
	}
}
