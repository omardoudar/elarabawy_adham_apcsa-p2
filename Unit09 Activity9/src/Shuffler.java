

import java.util.List;
import java.util.Random;

/**
 * This class provides a convenient way to test shuffling methods.
 */
public class Shuffler {

	/**
	 * The number of consecutive shuffle steps to be performed in each call
	 * to each sorting procedure.
	 */
	@SuppressWarnings("unused")
	private static final int SHUFFLE_COUNT = 8;

	/**
	 * The number of values to shuffle.
	 */
	@SuppressWarnings("unused")
	private static final int VALUE_COUNT = 52;

	/**
	 * Tests shuffling methods.
	 * @param args is not used.
	 */
	public static void main(String[] args) {
	}
	
	/**
	 * Apply a "perfect shuffle" to the argument.
	 * The perfect shuffle algorithm splits the deck in half, then interleaves
	 * the cards in one half with the cards in the other.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static int[] perfectShuffle(int[] values) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 3 *** */
		int[] shuffled = new int[values.length];
		int k = 0;
		for(int i = 0; i < (values.length + 1) / 2; i++) {
			shuffled[k] = values[i];
			k+=2;
		}
		k = 1;
		for(int i = (values.length + 1) / 2; i < values.length; i++) {
			shuffled[k] = values[i];
			k+=2;
		}
		return shuffled;
	}

	/**
	 * Apply an "efficient selection shuffle" to the argument.
	 * The selection shuffle algorithm conceptually maintains two sequences
	 * of cards: the selected cards (initially empty) and the not-yet-selected
	 * cards (initially the entire deck). It repeatedly does the following until
	 * all cards have been selected: randomly remove a card from those not yet
	 * selected and add it to the selected cards.
	 * An efficient version of this algorithm makes use of arrays to avoid
	 * searching for an as-yet-unselected card.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static Card[] selectionShuffle(Card[] values) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 3 *** */
		
		Random rand = new Random();
		for(int i = 1; i < values.length; i++) {
			int r = rand.nextInt(i);
			Card temp = values[i];
			values[i] = values[r];
			values[r] = temp;
		}
		
		return values;
	}
	
	/**
	 * Apply an "efficient selection shuffle" to the argument.
	 * The selection shuffle algorithm conceptually maintains two sequences
	 * of cards: the selected cards (initially empty) and the not-yet-selected
	 * cards (initially the entire deck). It repeatedly does the following until
	 * all cards have been selected: randomly remove a card from those not yet
	 * selected and add it to the selected cards.
	 * An efficient version of this algorithm makes use of arrays to avoid
	 * searching for an as-yet-unselected card.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static List<Card> selectionShuffle(List<Card> values) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 3 *** */
		
		Random rand = new Random();
		for(int i = 1; i < values.size(); i++) {
			int r = rand.nextInt(i);
			Card temp = values.get(i);
			values.set(i, values.get(r));
			values.set(r, temp);
		}
		
		return values;
	}
}
