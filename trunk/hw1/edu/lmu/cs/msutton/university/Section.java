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
	public Section(String deparment, int course, int section) {
		this.department = new String(department);
		this.course = course;
		this.section = section;
	}
	
	public String toString() {
		return department + " " + course + " Section " + section;
	}
}
