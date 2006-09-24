package edu.lmu.cs.msutton.math;

/**
 * A class representing a single variable polynomial with real number
 * coefficients using an array. When creating the ArrayPolynomial, you must use
 * an array of doubles where the index of each element represents the power of
 * the x term to which it is a coefficient.
 * 
 * @author Kelly Sutton
 * @author Garrett Shanno
 * 
 */
public class ArrayPolynomial {

	private double[] coefficients;

	/**
	 * 
	 * @param coefficients
	 *            polynomial coefficients
	 */
	public ArrayPolynomial(double[] coefficients) {
		this.coefficients = coefficients;
	}

	/**
	 * 
	 * @param coefficients
	 *            polynomial coefficients
	 */
	public ArrayPolynomial(String coefficients) {
		// TODO write this if we want to be able to create from Strings
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @return the derivative
	 */
	public ArrayPolynomial derivative() {
		double[] derivative = new double[this.coefficients.length - 1];

		for (int i = 0; 1 < derivative.length; i++) {
			derivative[i] = this.coefficients[i + 1];
		}
		// TODO is there a better way to do this for loop?
		return new ArrayPolynomial(derivative);
	}

	/**
	 * 
	 * @return the degree
	 */
	public int getDegree() {
		return this.coefficients.length;
	}

	/**
	 * Returns a brief description of the Card. The exact details of the
	 * representation are unspecified and subject to change, but the following
	 * may be regarded as typical: "Polynomial: 3 + -2.32X^1 + 7.002X^2 +
	 * -33X^3"
	 */
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer("Polynomial: ");
		buffer.append(coefficients[0] + " + ");
		for (int i = 1; i < coefficients.length - 1; i++) {
			buffer.append(coefficients[i] + "X^" + i + " + ");
		}
		buffer.append(coefficients[coefficients.length - 1] + "X^"
				+ (coefficients.length - 1));
		return buffer.toString();
	}

	/**
	 * 
	 * @param d
	 *            number to evaluate at
	 * @return value of the polynomial
	 */
	public double valueAt(double d) {
		// TODO write this
		throw new UnsupportedOperationException();
	}

}
