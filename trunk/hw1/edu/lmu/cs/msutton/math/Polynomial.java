package edu.lmu.cs.msutton.math;

/**
 * 
 * @author Kelly Sutton
 * @author Garrett Shannon
 * 
 * A simple interface to represent single variable polynomials with real number
 * coefficients.
 * 
 */
public interface Polynomial {
	/**
	 * 
	 * @return the derivative
	 */
	Polynomial derivative();

	/**
	 * 
	 * @return the degree
	 */
	int getDegree();

	/**
	 * 
	 * @return String representation
	 */
	String toString();

	/**
	 * 
	 * @param d
	 *            number to evaluate at
	 * @return value of the polynomial
	 */
	double valueAt(double d);

}
