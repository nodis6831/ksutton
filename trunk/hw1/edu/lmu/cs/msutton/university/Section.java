package edu.lmu.cs.msutton.university;

/**
 * 
 * @author Kelly Sutton
 * @author Garrett Shanno
 * 
 * 
 */
public class Section {
	private String department;

	private int course;

	private int section;

	/**
	 * 
	 * @param deparment
	 *            the department
	 * @param course
	 *            the course number
	 * @param section
	 *            the section number
	 */
	public Section(String department, int course, int section) {
		this.department = department;
		this.course = course;
		this.section = section;
	}
	/**
	 * Returns a brief description of the Card. The exact details of the
	 * representation are unspecified and subject to change, but the following
	 * may be regarded as typical:
	 * "Department # Section #" "History 101 Section 02"
	 */
	
	@Override	
	public String toString() {
		return department + " " + course + " Section " + section;
	}
}
