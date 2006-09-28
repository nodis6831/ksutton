package edu.lmu.cs.msutton.math;

/**
 * A rather stupid Ratio interface
 * 
 * @author Kelly Sutton
 * @author Garrett Shannon
 */

public interface Ratio {

	/**
	 * @return The numerator
	 */
	long getNum();

	/**
	 * @return The denominator
	 */
	long getDen();

	boolean equals(Object obj);

	String toString();
}
