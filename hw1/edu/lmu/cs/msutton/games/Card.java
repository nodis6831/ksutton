package edu.lmu.cs.msutton.games;

public class Card {
	public enum Suit {
		SPADES, HEARTS, DIAMONDS, CLUBS;
	}

	public enum Rank {
		ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;
	}

	private Suit suit;

	private Rank rank;

	public Card(Suit s, Rank r) {
		this.suit = s;
		this.rank = r;
	}

	public Rank getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}

	@Override
	public String toString() {
		return this.rank + " of " + this.suit;
	}
}