package edu.lmu.cs.msutton.geometry;

public class Line {

	private Point p;

	private Vector v;

	public Line(Point point, Vector vector) {

		this.p = point;
		this.v = vector;

	}

	public Line(Point point, double i, double j) {

		this.p = point;
		this.v = new Vector(i, j);

	}

	/*
	 * Shifts a line by shifting its Point @param x The (+/-) x shift @param y
	 * The (+/-) y shift
	 */
	public void shiftLine(double x, double y) {

		this.p = new Point((p.getX() + x), (p.getY() + y));

	}

	/*
	 * Rotates the line by a set number of degrees
	 */
	public void rotateLine(double theta) {

		double i = 1;
		double j = Math.tan(theta); 

		this.v = new Vector(i, j);
	}

	public Point getP() {
		return this.p;
	}

	public Vector getV() {
		return this.v;
	}

	/*
	 * Returns true iff this == that @param that A Line object (non-Javadoc)
	 * NOTE: To avoid rounding error, equals() returns true of the direction of the vectors are within 0.001 of eachother
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {

		if (obj instanceof Line) {

			Line that = (Line) obj;

			if (	this.isPointOnLine(that.p) && 
					(		this.v.directionAsDegrees() == that.v.directionAsDegrees()
						||	this.v.directionAsDegrees() == 180.0 + that.v.directionAsDegrees()
						||  Math.abs( this.v.directionAsDegrees() - that.v.directionAsDegrees() ) < 0.001 )){ //The lines are close enough
					return true;
				}
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() @override
	 */
	public String toString() {

		return this.p.toString() + " " + this.v.toString();

	}

	public boolean isPointOnLine( Point point ){

		//point-slope formula
		if( point.getY() - this.p.getY() == (this.v.getJ() / this.v.getI()) * ( point.getX() - this.p.getX() ) ){
			return true;
		}
		return false;
	}

	private class Vector {
		// TODO should Vector be its own public class? Is this okay with Ray?
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
			super();
			this.i = i;
			this.j = j;
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

		public double directionAsDegrees() {

			return Math.atan(this.j / this.i);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString() @override
		 */
		public String toString() {

			return "<" + this.i + "," + this.j + ">";

		}
	}
}
