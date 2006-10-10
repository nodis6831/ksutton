package edu.lmu.cs.msutton.util;

import java.util.TreeMap;

/**
 * A Purse class
 * 
 * @author Kelly Sutton
 * @author Garrett Shannon
 */

public interface Purse {

	final TreeMap<String, Integer> purse = new TreeMap<String, Integer>();

	/**
	 * A method that returns the number of coins of a specified denomination.
	 * 
	 * @param denomination
	 *            The denomination coin count that the user wishes returned.
	 * @return The number of coins of the specified denomination. 0 = pennies, 1 =
	 *         nickels, 2 = dimes, 3 = quarters
	 */
	public int getNumCoinsOf(String denomination);

	/**
	 * A method that adds coins of a specific denomination
	 * 
	 * @param number
	 *            An int of the number of coins to add
	 * @param denomination
	 *            The correct String of the denomination of coins being added
	 */
	public void addNumCoinsOf(int number, String denomination);

	/**
	 * 
	 * @return The total number of coins.
	 */
	public int totalNumCoins();

	/**
	 * @return The total dollars.
	 */
	public double totalValue();

}
