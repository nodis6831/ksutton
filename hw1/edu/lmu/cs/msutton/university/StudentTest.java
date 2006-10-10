package edu.lmu.cs.msutton.university;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

/**
 * A JUnit test class for class Student
 * 
 * @author Kelly Sutton
 * @author Garrett Shannon
 * 
 */
public class StudentTest {
	Student s = new Student("Billy", true, 1987, "USA");
	Student t = s;
	Student u = new Student("Billy", true, 1987, "USA");

	Phone p = new Phone(858, 451, 6718);
	Phone q = new Phone(619, 922, 8100);
	
	@Test
	public void testStudent() {
		
		assertEquals(s.getCountry(), "USA");
		assertEquals(s.getYob(), 1987);
		assertEquals(s.isMale(), true);
		assertEquals(s.getName(), "Billy");
		try{
			assertEquals(s.getPhone().toString(), "(858)-451-6718");
		}
		catch( Exception e){
			Assert.assertTrue(e instanceof IllegalStateException);
		}
		s.setPhone(p);
		assertEquals(s.getPhone().toString(), "(858)-451-6718");
		s.setPhone(q);
		assertEquals(s.getPhone().toString(), "(619)-922-8100");
		assertEquals(t, s);
		Assert.assertFalse(u.equals(s)); 
		Assert.assertFalse(t.equals(u));
		t.setPhone(q);
		u.setPhone(q);
		assertEquals(u, s);
		assertEquals(t, u);
	}	

	@Test
	public void testToString() {
		assertEquals(s.toString(), "Billy Male 1987 USA");
	}

	@Test
	public void testUpdateTranscript() {
		Section a = new Section("History", 152, 02, 3, 2006, true);
		Grade aGrade = new Grade(93.54);
		Section b = new Section("Science", 101, 01, 3, 2006, true);
		Grade bGrade = new Grade(85.05);
		Section c = new Section("Math", 101, 17, 3, 2006, true);
		Grade cGrade = new Grade(70.99);
		
		
		//assertEquals(s.credits(), 3);
		//assertEquals(s.gpa(), 4.0);
		s.updateTranscript(c, cGrade);
		System.out.println(s.gpa());
		s.updateTranscript(b, bGrade);
		s.updateTranscript(a, aGrade);


	}
}