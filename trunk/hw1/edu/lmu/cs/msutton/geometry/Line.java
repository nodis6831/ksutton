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
	 * @param obj
	 *            A Line object NOTE: To avoid rounding error, equals() returns
	 *            true of the direction of the vectors are within 0.001 of
	 *            eachother
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {

		if (obj instanceof Line) {

			Line that = (Line) obj;

			if (this.isPointOnLine(that.p) //make sure the two lines have a point in common
					&& (this.v.directionAsRadians() == that.v.directionAsRadians() //test if the vectors point in the same direction
							|| this.v.directionAsRadians() == Math.PI + that.v.directionAsRadians() //test if the vectors point in opposite directions
							|| Math.abs(this.v.directionAsRadians()	- that.v.directionAsRadians()) < 0.001)) { //test if the vectors point in a close enough direction
				return true;
			}
		}

		return false;
	}

	/**
	 * @Override Returns a brief description of the Line. The exact details of
	 *           the representation are unspecified and subject to change, but
	 *           the following may be regarded as typical:
	 *           
	 *           "(0,0) <1,2>"
	 */
	@Override
	public String toString() {

		return this.p.toString() + " " + this.v.toString();

	}

	private boolean isPointOnLine(Point point) {

		// point-slope formula
		if (point.getY() - this.p.getY() == (this.v.getJ() / this.v.getI())
				* (point.getX() - this.p.getX())) {
			return true;
		} else if (this.v.getI() == 0.0 && point.getX() == this.p.getX()) { // vertical line
			return true;
		}
		return false;
	}

}
