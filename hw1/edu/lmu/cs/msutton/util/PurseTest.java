package edu.lmu.cs.msutton.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;
import org.junit.Test;

/**
 * A test class for the Purse class
 * 
 * @author Kelly Sutton
 * @author Garrett Shannon
 */
public class PurseTest {

	/**
	 * Make sure the constructor create the TreeMap
	 */
	@Test
	public void testConstruction() {
		Purse a = new Purse();
		assertNotNull(a);
	}

	/**
	 * Simple test for an empty purse
	 */
	@Test
	public void testGetCoins() {
		Purse b = new Purse();
		assertTrue(0 == b.getNumCoinsOf("pennies"));
		assertTrue(0 == b.getNumCoinsOf("nickels"));
		assertTrue(0 == b.getNumCoinsOf("dimes"));
		assertTrue(0 == b.getNumCoinsOf("quarters"));
	}

	/**
	 * Test of adding coins to the purse
	 */
	@Test
	public void testAddCoins() {
		Purse c = new Purse();
		c.addNumCoinsOf(5, "pennies");
		assertTrue(5 == c.getNumCoinsOf("pennies"));

		c.addNumCoinsOf(10, "pennies");
		assertTrue(15 == c.getNumCoinsOf("pennies"));

		c.addNumCoinsOf(50, "quarters");
		assertTrue(50 == c.getNumCoinsOf("quarters"));
	}

	/**
	 * Tests the method totalNumCoins()
	 */
	@Test
	public void testTotalNumCoins() {
		Purse d = new Purse();
		d.addNumCoinsOf(10, "pennies");
		d.addNumCoinsOf(10, "nickels");
		d.addNumCoinsOf(10, "dimes");
		d.addNumCoinsOf(10, "quarters");

		assertTrue(40 == d.totalNumCoins());
	}

	/**
	 * Tests the method totalValue()
	 */
	@Test
	public void testTotalValue() {
		Purse p = new Purse();
		p.addNumCoinsOf(10, "pennies");
		p.addNumCoinsOf(10, "nickels");
		p.addNumCoinsOf(10, "dimes");
		p.addNumCoinsOf(10, "quarters");

		assertTrue(4.10 == p.totalValue());
	}
}
