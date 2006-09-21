package edu.lmu.cs.msutton.geometry;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * JUnit tests for the Line class.
 * 
 * @author Kelly Sutton
 * @author Garrett Shannon
 */

public class LineTest {

	/**
	 * This unit test will test the constructor for the Line class and compares
	 * the line to an identical line and a unique line using equals().
	 * 
	 */
	@Test
	public void testDefaultLine() {
		Line line = new Line(new Point(0, 0), new Vector(1, 1));
		assertTrue(line.equals(new Line(new Point(0, 0), new Vector(1, 1))));
		assertFalse(line.equals(new Line(new Point(0, 0), new Vector(3, 4))));
	}

	/**
	 * Tests three identical lines defined by opposing vectors of different
	 * magnitudes.
	 * 
	 */
	@Test
	public void testTwoOppositeLinesForEquality() {
		Line a = new Line(new Point(0, 0), new Vector(1, 1));
		Line b = new Line(new Point(0, 0), new Vector(-1, -1));
		assertTrue(a.equals(b));

		Line c = new Line(new Point(0, 0), new Vector(10, 10));
		assertEquals(a,b);
		assertEquals(b,c);
		assertEquals(c,a);
		
	}

	/**
	 * Tests line rotation.
	 *
	 */
	@Test
	public void testLineRotation(){
		Line a = new Line(new Point(0,0), new Vector(1,1));
		Line b = new Line(new Point(0,0), new Vector(1,0));
		
		assertFalse(a.equals(b));
		
		b.rotateLine(Math.PI / 4);
		assertEquals(a,b);
	}
}
