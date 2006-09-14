package edu.lmu.cs.msutton.geometry;

public class LineTest {

	public static void main(String[] args) {

		System.out.println("LineTest started...");

		Point p = new Point(0, 0);
		Point q = new Point(10, 10);

		assert p.equals(Point.ORIGIN);
		assert !q.equals(Point.ORIGIN);

		Line m = new Line(Point.ORIGIN, 1, 1);
		Line n = new Line(Point.ORIGIN, -1, -1);
		Line a = new Line(Point.ORIGIN, 4, 3);
		Line b = new Line(Point.ORIGIN, 1, 0);
		
		System.out.println( b.toString() );
		b.rotateLine( Math.PI / 4 );
		System.out.println( b.toString() );
		
		assert m.equals(n);
		assert m.equals(b);
		assert n.equals(b);
		assert !a.equals(m);
		

		System.out.println("Complete.");
	}

}
