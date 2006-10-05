package edu.lmu.cs.msutton.util;

import java.util.TreeMap;

/**
 * A Purse class
 * 
 * @author Kelly Sutton
 * @author Garrett Shannon
 */

public class Purse {

	private final TreeMap<String, Integer> purse;

	public Purse() {
		purse = new TreeMap();
		purse.put("pennies", 0);
		purse.put("nickels", 0);
		purse.put("dimes", 0);
		purse.put("quarters", 0);
	}

	/**
	 * A method that returns the number of coins of a specified denomination.
	 * 
	 * @param denomination
	 *            The denomination coin count that the user wishes returned.
	 * @return The number of coins of the specified denomination. 0 = pennies, 1 =
	 *         nickels, 2 = dimes, 3 = quarters
	 */
	public int getNumCoinsOf(String denomination) {
		return purse.get(denomination);
	}

	/**
	 * A method that adds coins of a specific denomination
	 * 
	 * @param number
	 *            An int of the number of coins to add
	 * @param denomination
	 *            The correct String of the denomination of coins being added
	 */
	public void addNumCoinsOf(int number, String denomination) {
		purse.put(denomination, number);
	}

	/**
	 * 
	 * @return The total number of coins.
	 */
	public int totalNumCoins() {
		return this.getNumCoinsOf("pennies") + this.getNumCoinsOf("nickels")
				+ this.getNumCoinsOf("dimes") + this.getNumCoinsOf("quarters");
	}

	/**
	 * @return The total dollars.
	 */
	public double totalValue() {
		return (0.01 * this.getNumCoinsOf("pennies"))
				+ (0.05 * this.getNumCoinsOf("nickels"))
				+ (0.10 * this.getNumCoinsOf("dimes"))
				+ (0.25 * this.getNumCoinsOf("quarters"));
	}

	/**
	 * Returns a brief description of the Purse. The exact details of the
	 * representation are unspecified and subject to change, but the following
	 * may be regarded as typical:
	 * 
	 * "2 pennie(s), 1 nickel(s), 3 dime(s), and 4 quarter(s)"
	 */

	@Override
	public String toString() {
		return this.getNumCoinsOf("pennies") + " pennie(s), "
				+ this.getNumCoinsOf("nickels") + " nickel(s), "
				+ this.getNumCoinsOf("dimes") + " dime(s), and "
				+ this.getNumCoinsOf("quarters") + " quarter(s)";
	}
}
