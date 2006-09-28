/**
 * A simple immutable Point class
 * 
 * @author Kelly Sutton
 * @author Garrett Shannon
 */

package edu.lmu.cs.msutton.geometry;

public class Point {

	private final double x;

	private final double y;

	public static final Point ORIGIN = new Point(0, 0);

	/**
	 * @param x
	 *            The x-coordinate
	 * @param y
	 *            The y-coordinate
	 */
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * @return the x
	 */
	public final double getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public final double getY() {
		return y;
	}

	/**
	 * @return true iff this == that
	 */
	@Override
	public final boolean equals(Object obj) {

		if (obj instanceof Point) {

			Point that = (Point) obj;

			return this.x == that.x && this.y == that.y;

		}

		return false;
	}

	/**
	 * @Override Returns a brief description of the Point. The exact details of
	 *           the representation are unspecified and subject to change, but
	 *           the following may be regarded as typical:
	 * 
	 * "(1,2)"
	 */
	@Override
	public final String toString() {
		return "(" + this.x + "," + this.y + ")";
	}

	@Override
	public final int hashCode() {
		int result = 17;
		result = 37 * result + (int) Double.doubleToLongBits(this.x);
		result = 37 * result + (int) Double.doubleToLongBits(this.y);
		return result;
	}

}
