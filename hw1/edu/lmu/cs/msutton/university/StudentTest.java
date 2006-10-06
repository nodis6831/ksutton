package edu.lmu.cs.msutton.university;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


/**
 * A JUnit test class for class Student
 * 
 * @author Kelly Sutton
 * @author Garrett Shannon
 * 
 */
public class StudentTest {
	@Test
	public void testGetters() {
		Student s = new Student("Billy", true, 1987, "USA" );
		assertEquals(s.getCountry(), "USA");
		assertEquals(s.getYob(), 1987);
		assertEquals(s.isMale(), true);
		assertEquals(s.getName(), "Billy");

	}
	
	@Test
	public void testPhone() {
		
	}

	@Test
	public void testToString() {

	}

	@Test
	public void testUpdateTranscript() {

	}
	
	@Test
	public void testPrintTranscript() {
		
	}
	//TODO test the final-ness of the Transcript private field
}