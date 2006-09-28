package edu.lmu.cs.msutton.util;

/**
 * A Purse class
 * 
 * @author Kelly Sutton
 * @author Garrett Shannon
 */

public class Purse {

	// TODO should these be arrays?
	private int numPennies;

	private int numNickels;

	private int numDimes;

	private int numQuarters;

	/**
	 * A very lame method that return the number of coins of a specified
	 * denomination.
	 * 
	 * @param denomination
	 *            The denomination coin count that the user wishes returned.
	 * @return The number of coins of the specified denomination. 0 = pennies, 1 =
	 *         nickels, 2 = dimes, 3 = quarters
	 */
	public int getNumCoinsOf(int denomination) {
		switch (denomination) {
		case 0:
			return numPennies;
		case 1:
			return numNickels;
		case 2:
			return numDimes;
		case 3:
			return numQuarters;
		default:
			throw new IllegalArgumentException(); //TODO are switch statements evil for CMSI 281?
		}
	}

	/**
	 * Add a number of coins of a certain denomination to the Purse object.
	 * 
	 * @param number The number of coins to add
	 * @param denomination The particular denomination of coins to add
	 */
	public void addNumCoinsOf(int number, int denomination) {

		switch (denomination) {
		case 0:
			numPennies += number;
		case 1:
			numNickels += number;
		case 2:
			numDimes += number;
		case 3:
			numQuarters += number;
		default:
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * 
	 * @return The total number of coins.
	 */
	public int totalNumCoins() {
		return numPennies + numNickels + numDimes + numQuarters;
	}

	/**
	 * 
	 * @return The total dollars.
	 */
	public double totalvalue() {
		return (0.01 * numPennies) + (0.05 * numNickels) + (0.10 * numDimes)
				+ (0.25 * numQuarters);
	}

	/**
	 * Returns a brief description of the Card. The exact details of the
	 * representation are unspecified and subject to change, but the
	 * following may be regarded as typical:
	 * 
	 *  "2 pennie(s), 1 nickel(s), 3 dime(s), and 4 quarter(s)"
	 */
	
	@Override
	public String toString(){
		return this.numPennies + " pennie(s), " + this.numNickels + " nickel(s), " + this.numDimes + " dime(s), and " + this.numQuarters + " quarter(s)";
	}
}
