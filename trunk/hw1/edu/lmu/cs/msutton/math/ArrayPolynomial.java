package edu.lmu.cs.msutton.math;

import java.util.Arrays;

/**
 * A class representing a single variable polynomial with real number
 * coefficients using an array. When creating the ArrayPolynomial, you must use
 * an array of doubles where the index of each element represents the power of
 * the x term to which it is a coefficient.
 * 
 * @author Kelly Sutton
 * @author Garrett Shannon
 * 
 */
public class ArrayPolynomial implements Polynomial {

	private double[] coefficients;

	public static final ArrayPolynomial ZERO = new ArrayPolynomial(0);

	/**
	 * 
	 * @param coefficients
	 *            polynomial coefficients
	 */
	public ArrayPolynomial(double[] coefficients) {
		this.coefficients = new double[coefficients.length];
		System.arraycopy(coefficients, 0, this.coefficients, 0,
				coefficients.length); // defensive copy
	}

	private ArrayPolynomial(int i) {
		this.coefficients = new double[] { i };
	}

	/**
	 * 
	 * @return the derivative
	 */
	public ArrayPolynomial derivative() {
		double[] derivative;
		if (coefficients.length == 0 | coefficients == null)
			throw new IllegalStateException("Polynomial is undefined.");
		if (coefficients.length == 1)
			return ZERO;
		derivative = new double[this.coefficients.length - 1];
		System
				.arraycopy(this.coefficients, 1, derivative, 0,
						derivative.length);
		return new ArrayPolynomial(derivative);
	}

	/**
	 * 
	 * @return the degree
	 */
	public int getDegree() {
		if (coefficients.length == 0 | coefficients == null)
			throw new IllegalStateException("Polynomial is undefined.");
		int i = (this.coefficients.length - 1);
		while (this.coefficients[i] == 0.0 && i > 0) {// skips terms with a
			// coefficient of zero
			i--;
		}
		return i;
	}

	/**
	 * 
	 * @param d
	 *            number to evaluate at
	 * @return value of the polynomial
	 */
	public double valueAt(double d) {
		if (coefficients.length == 0 | coefficients == null)
			throw new IllegalStateException("Polynomial is undefined.");
		double sum = 0;
		for (int i = 0; i < coefficients.length; i++) {
			sum += (Math.pow(d, i)) * coefficients[i];
		}
		return sum;
	}

	/**
	 * Returns a brief description of the ArrayPolynomial. The exact details of
	 * the representation are unspecified and subject to change, but the
	 * following may be regarded as typical: "3 + -2.32X^1 + 7.002X^2 + -33X^3 +
	 * 5X^5" Note* It skips coefficients of zero
	 */
	@Override
	public String toString() {
		StringBuffer buffer;
		if (coefficients.length == 0 | coefficients == null)
			throw new IllegalStateException("Polynomial is undefined.");
		if (this.equals(ZERO))
			return "0";
		if (coefficients[0] == 0.0) {
			buffer = new StringBuffer(); // don't print a term if the
			// coefficient is zero
		} else {
			buffer = new StringBuffer(coefficients[0] + " + ");// don't print
			// the X for the
			// first term
		}
		for (int i = 1; i < coefficients.length - 1; i++) {
			if (coefficients[i] == 0.0) {// don't print a term if the
				// coefficient is zero
			} else {
				buffer.append(coefficients[i] + "X^" + i + " + ");
			}
		}
		if (coefficients[coefficients.length - 1] == 0) {
			buffer.setLength(buffer.length() - 3);// trims the string to the
			// end of the most recent term if the last coefficient is zero
		} else {
			buffer.append(coefficients[coefficients.length - 1] + "X^"
					+ (coefficients.length - 1));
		}
		return buffer.toString();
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + Arrays.hashCode(coefficients);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final ArrayPolynomial other = (ArrayPolynomial) obj;
		if (!Arrays.equals(coefficients, other.coefficients))
			return false;
		return true;
	}

}
