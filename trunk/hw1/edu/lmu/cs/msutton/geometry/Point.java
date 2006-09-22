/**
 * A simple immutable Point class
 * Kelly Sutton, Garrett Shannon
 * CMSI 281, Fall 2006
 */

package edu.lmu.cs.msutton.geometry;

public class Point {

	private double x;

	private double y;

	public static final Point ORIGIN = new Point(0, 0);

	/**
	 * @param x
	 * @param y
	 */
	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}

	/**
	 * @return true iff this == that
	 */
	public boolean equals(Object that) {

		if (that instanceof Point) {

			Point p = (Point) that;

			if ((this.x == p.x) && (this.y == p.y)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * @Override
	 * Returns a brief description of the Card. The exact details of the
	 * representation are unspecified and subject to change, but the following
	 * may be regarded as typical:
	 */
	// TODO Define / give example of typical string output in the comment
	@Override
	public String toString() {
		return "(" + this.x + "," + this.y + ")";
	}

}
