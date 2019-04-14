//Name: Adham Elarabawy

public class NumberSorterRunner {
	
	public static void main(String args[]) {
		int[] tests = { 567891, 901912468, 864213507, 898777, 234422 };
		for (int test : tests) {

			int[] temp = NumberSorter.getSortedDigitArray(test);
			for (int item : temp) {
				System.out.print(item + " ");
			}
			System.out.println();
		}
	}
}