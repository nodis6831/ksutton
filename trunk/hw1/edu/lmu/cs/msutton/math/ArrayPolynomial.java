package edu.lmu.cs.msutton.math;


/**
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

	}

	/**
	 * 
	 * @param coefficients
	 *            polynomial coefficients
	 */
	public ArrayPolynomial(String coefficients) {

	}

	/**
	 * 
	 * @return the derivative
	 */
	public ArrayPolynomial derivative() {
		double[] derivative = new double[this.coefficients.length - 1];
		// TODO Copy oirginal polynomial coefficients into the derivative array
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
	 * 
	 * @return String representation
	 */
	public String toString() {
		//TODO write this
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param d
	 *            number to evaluate at
	 * @return value of the polynomial
	 */
	public double valueAt(double d) {
		//TODO write this
		throw new UnsupportedOperationException();
	}

}
