
/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 * 
	 * @param args
	 *            is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 1 *** */
		
		
		Card card1 = new Card("5", "Hearts", 5);
		Card card2 = new Card("9", "Spades", 9);
		Card card3 = new Card("5", "Hearts", 5);
		

		System.out.println(card1 + " " + card2 + " " + card3);
		

		System.out.println(card1.matches(card2));
		System.out.println(card1.matches(card3));
	}
}
