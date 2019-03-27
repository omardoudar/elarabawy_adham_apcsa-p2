

/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
		
		String[] ranks = {"A", "B", "C"};
		String[] suits = {"Giraffes", "Lions"};
		int[] points = {2, 1, 6};
		
		Deck dck1 = new Deck(ranks, suits, points);
		Deck dck2 = new Deck(ranks, suits, points);
		Deck dck3 = new Deck(ranks, suits, points);
		
		//Test Decks
		System.out.println("BEGIN DECK 1 TEST:\n");
		System.out.println(dck1);
		System.out.println("DEALING 1 CARD:\n");
		dck1.deal();
		System.out.println(dck1);
		
		System.out.println("BEGIN DECK 2 TEST:\n");
		System.out.println(dck2);
		System.out.println("DEALING 2 CARDS:\n");
		
		dck2.deal();
		dck2.deal();
		System.out.println(dck2);
		
		System.out.println("BEGIN DECK 3 TEST:\n");
		System.out.println(dck3);
		System.out.println("DEALING 4 CARDS:\n");

		dck3.deal();
		dck3.deal();
		dck3.deal();
		dck3.deal();

		System.out.println(dck3);
		

		System.out.println("BEGIN SHUFFLE TESTS");
		

		String[] d52Ranks = {"ace", "two", "three", "four", "five",
								   "six", "seven", "eight", "nine", "ten", "jack",
								   "queen", "king"};
		int[] d52Points = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
		String[] d52Suits = {"spades", "hearts", "diamonds", "clubs"};
		

		Deck d52 = new Deck(d52Ranks, d52Suits, d52Points);
		System.out.println(d52);
		System.out.println("SHUFFLE");
		d52.shuffle();
		System.out.println(d52);
		System.out.println("SHUFFLE");
		d52.shuffle();
		System.out.println(d52);
	}
}
