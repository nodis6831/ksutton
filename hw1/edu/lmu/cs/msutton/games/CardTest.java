package edu.lmu.cs.msutton.games;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.lmu.cs.msutton.games.Card.Rank;
import edu.lmu.cs.msutton.games.Card.Suit;

/**
 * 
 * @author Kely Sutton
 * @author Garrett Shannon JUnit tests for the Card class.
 * 
 */

public class CardTest {
	@Test
	public void testGetters() {
		Card card = new Card(Rank.FIVE, Suit.SPADES);
		assertEquals(card.getRank(), Rank.FIVE);
		assertEquals(card.getSuit(), Suit.SPADES);
	}

	@Test
	public void testToString() {
		Card card = new Card(Rank.FIVE, Suit.SPADES);
		assertEquals(card.toString(), "Five of Spades");

	}

}
