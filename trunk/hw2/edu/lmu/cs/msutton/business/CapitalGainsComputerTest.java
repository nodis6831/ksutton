package edu.lmu.cs.msutton.business;

import static edu.lmu.cs.msutton.business.CapitalGainsComputer.boughtTransactions;
import static edu.lmu.cs.msutton.business.CapitalGainsComputer.soldTransactions;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * The JUnit tests for CapitalGainsComputer
 * 
 * @author Kelly Sutton
 * @author Garrett Shannon
 */

public class CapitalGainsComputerTest {

	@Test(expected = IllegalStateException.class)
	public void testAllBuyTransactions() {
		soldTransactions = null;
		boughtTransactions = new Transaction[] {
				new Transaction(100, 25.00, "2005-03-15"),
				new Transaction(200, 25.00, "2005-03-15"),
				new Transaction(400, 25.00, "2005-03-15"),
				new Transaction(1200, 25.00, "2005-03-15"),
				new Transaction(100, 25.00, "2005-03-15"),
				new Transaction(200, 20.00, "2005-08-15") };

		assertNotNull(boughtTransactions);

		CapitalGainsComputer.computeCapitalGains();

	}

	@Test(expected = IllegalStateException.class)
	public void testAllSellTransactions() {
		boughtTransactions = null;

		soldTransactions = new Transaction[] {
				new Transaction(100, 25.00, "2005-03-15"),
				new Transaction(200, 25.00, "2005-03-15"),
				new Transaction(400, 25.00, "2005-05-15"),
				new Transaction(1200, 25.00, "2005-06-15"),
				new Transaction(100, 25.00, "2005-07-15"),
				new Transaction(200, 20.00, "2005-08-15") };

		assertNotNull(soldTransactions);

		CapitalGainsComputer.computeCapitalGains();

		soldTransactions = null;
	}

	@Test
	public void testBookExample() {
		boughtTransactions = new Transaction[] {
				new Transaction(100, 25.00, "2005-03-15"),
				new Transaction(200, 20.00, "2005-08-15") };

		soldTransactions = new Transaction[] {
				new Transaction(60, 30.00, "2005-03-15"),
				new Transaction(240, 50.00, "2005-10-15") };

		assertEquals(7300, CapitalGainsComputer.computeCapitalGains());

	}

	@Test
	public void anotherTestCase() {
		boughtTransactions = new Transaction[] {
				new Transaction(100, 25.00, "2006-03-15"),
				new Transaction(2400, 5.00, "2008-03-15"),
				new Transaction(60, 30.00, "2008-03-15"),
				new Transaction(200, 20.00, "2005-08-15") };

		soldTransactions = new Transaction[] {
				new Transaction(60, 30.00, "2008-03-15"),
				new Transaction(600, 30.00, "2008-03-15"),
				new Transaction(15, 50.00, "2008-03-15"),
				new Transaction(240, 50.00, "2009-10-15") };

		assertEquals(25975, CapitalGainsComputer.computeCapitalGains());

	}
}
