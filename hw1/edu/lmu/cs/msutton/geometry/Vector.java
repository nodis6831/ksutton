package edu.lmu.cs.msutton.geometry;

/**
 * A simple vector class. Each vector is defined by its x-magnitude (i) and its
 * y-magnitude (j)
 * 
 * @author Kelly Sutton
 * @author Garrett Shannon
 */
public class Vector {

	private double i;

	private double j;

	/**
	 * Constructor for two-dimensional vector
	 * 
	 * @param i
	 *            magnitude of x vector
	 * @param j
	 *            magnitude of y vector
	 */
	public Vector(double i, double j) {

		this.i = i;
		this.j = j;
	}

	/**
	 * Creates a new Vector object from an angle (in radians) and magnitude.
	 * This is a static constructor because we already have the constructor Vector( double, double)
	 * 
	 * @param angle
	 *            The angle of the Vector object
	 * @param magnitude
	 *            The magnitude of the Vector object
	 */
	public static Vector fromAngleAndMagnitude(double angle, double magnitude) {

		return new Vector(magnitude * Math.cos(angle), magnitude
				* Math.sin(angle));
	}

	/**
	 * Creates a new Vector object from the origin to a Cartesian coordinate
	 * 
	 * @param x
	 *            The x-component (i) of the Vector object
	 * @param y
	 *            The y-component (j) of the Vector object
	 * @return A new Vector object
	 */
	public static Vector fromPoint(double x, double y) {

		return new Vector(x, y);
	}

	/**
	 * @return the i
	 */
	public double getI() {
		return i;
	}

	/**
	 * @return the j
	 */
	public double getJ() {
		return j;
	}

	/**
	 * @return A double of the direction as radians
	 */
	public double directionAsRadians() {

		return Math.atan(this.j / this.i);
	}

	/**
	 * Returns a brief description of the Vector. The exact details of the
	 * representation are unspecified and subject to change, but the following
	 * may be regarded as typical:
	 * 
	 * "<1,2>"
	 */
	@Override
	public String toString() {

		return "<" + this.i + "," + this.j + ">";

	}
}
