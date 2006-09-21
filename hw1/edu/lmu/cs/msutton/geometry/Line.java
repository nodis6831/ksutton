package edu.lmu.cs.msutton.geometry;

/**
 * A simple vector-based line class
 * 
 * @author Kelly Sutton
 * @author Garrett Shannon
 */
public class Line {

	private Point p;

	private Vector v;

	/**
	 * @param point
	 *            The point from which the Line object is defined
	 * @param vector
	 *            The vector of the Line object
	 */
	public Line(Point point, Vector vector) {

		this.p = point;
		this.v = vector;

	}

	/**
	 * A simple Line constructor which takes a point and two vector components
	 * 
	 * @param point
	 *            The point from which the line will be defined
	 * @param i
	 *            The x-component of the vector
	 * @param j
	 *            The y-component of the vector
	 */
	public Line(Point point, double i, double j) {

		this.p = point;
		this.v = new Vector(i, j);

	}

	/**
	 * Shifts a line by shifting its Point
	 * 
	 * @param x
	 *            The (+/-) x shift
	 * @param y
	 *            The (+/-) y shift
	 */
	public void shiftLine(double x, double y) {

		this.p = new Point((p.getX() + x), (p.getY() + y));

	}

	/**
	 * Rotates the line <b>clockwise</b> by a set number of degrees
	 */
	public void rotateLine(double theta) {

		double i = 1;
		double j = Math.tan(theta);

		this.v = new Vector(i, j);
	}

	/**
	 * 
	 * @return The private Point member object
	 */
	public Point getP() {
		return this.p;
	}

	/**
	 * 
	 * @return The private Vector member object
	 */
	public Vector getV() {
		return this.v;
	}

	/**
	 * @return true iff this == that
	 * @param that
	 *            A Line object NOTE: To avoid rounding error, equals() returns
	 *            true of the direction of the vectors are within 0.001 of
	 *            eachother
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {

		if (obj instanceof Line) {

			Line that = (Line) obj;

			if (this.isPointOnLine(that.p)
					&& (this.v.directionAsDegrees() == that.v.directionAsDegrees()
							|| this.v.directionAsDegrees() == 180.0 + that.v.directionAsDegrees() 
							|| Math.abs(this.v.directionAsDegrees() - that.v.directionAsDegrees()) < 0.001)) { 
				return true;
			}
		}

		return false;
	}

	/**
	 * 
	 * @see java.lang.Object#toString() @override
	 */
	public String toString() {

		return this.p.toString() + " " + this.v.toString();

	}

	public boolean isPointOnLine(Point point) {

		// point-slope formula
		if (point.getY() - this.p.getY() == (this.v.getJ() / this.v.getI())
				* (point.getX() - this.p.getX())) {
			return true;
		}
		return false;
	}

}
