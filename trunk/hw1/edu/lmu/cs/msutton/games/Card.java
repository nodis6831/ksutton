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
	public enum Suit {
		SPADES, HEARTS, DIAMONDS, CLUBS;
	}

	/**
	 * 
	 * @author Kelly Sutton
	 * @author Garrett Shannon
	 * 
	 */
	public enum Rank {
		ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;
	}

	private Suit suit;

	private Rank rank;

	/**
	 * 
	 * @param s
	 *            The desired suit of the Card object
	 * @param r
	 *            The desired rank of the Card object
	 */
	public Card(Suit s, Rank r) {
		this.suit = s;
		this.rank = r;
	}

	/**
	 * 
	 * @return the rank
	 */
	public Rank getRank() {
		return rank;
	}

	/**
	 * 
	 * @return the suit
	 */
	public Suit getSuit() {
		return suit;
	}

	@Override
	public String toString() {
		return this.rank + " of " + this.suit;
	}
}