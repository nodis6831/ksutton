package edu.lmu.cs.msutton.games;

/**
 * 
 * @author Kelly Sutton
 * @author Garrett Shannon
 */
public class Card {
	/**
	 * 
	 * @author Kelly Sutton
	 * @author Garrett Shannon
	 * 
	 */
	public static enum Suit {
		SPADES("Spades"), HEARTS("Hearts"), DIAMONDS("Diamonds"), CLUBS("Clubs");
		private String name;

		/**
		 * Assigns each field a String with only the first letter capitalized
		 */
		private Suit(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return this.name;
		}
	}

	/**
	 * 
	 * @author Kelly Sutton
	 * @author Garrett Shannon
	 * 
	 */
	public static enum Rank {
		ACE("Ace"), TWO("Two"), THREE("Three"), FOUR("Four"), FIVE("Five"), SIX(
				"Six"), SEVEN("Seven"), EIGHT("Eight"), NINE("Nine"), TEN("Ten"), JACK(
				"Jack"), QUEEN("Queen"), KING("King");
		private String name;

		/**
		 * Assigns each field a String with only the first letter capitalized
		 */
		private Rank(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return this.name;
		}
	}

	private Suit suit;

	private Rank rank;

	/**
	 * 
	 * @param suit
	 *            The desired suit of the Card object
	 * @param rank
	 *            The desired rank of the Card object
	 */
	public Card(Rank rank, Suit suit) {
		this.suit = suit;
		this.rank = rank;
	}

	/**
	 * 
	 * @return the rank
	 */
	public Rank getRank() {
		return this.rank;
	}

	/**
	 * 
	 * @return the suit
	 */
	public Suit getSuit() {
		return this.suit;
	}

	@Override
	/**
	 * Returns a brief description of the Card. The exact details of the
	 * representation are unspecified and subject to change, but the following
	 * may be regarded as typical:
	 * 
	 * "Rank of Suit" "Five of Spades"
	 */
	public String toString() {
		return this.rank + " of " + this.suit;
	}
}