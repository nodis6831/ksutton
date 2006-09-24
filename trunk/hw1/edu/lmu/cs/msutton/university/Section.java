package edu.lmu.cs.msutton.university;

/**
 * 
 * @author Kelly Sutton
 * @author Garrett Shannon
 * 
 * 
 */
public class Section {
	private String department;

	private int course;

	private int section;

	private int creditHours;

	/**
	 * 
	 * @param deparment
	 *            the department
	 * @param course
	 *            the course number
	 * @param section
	 *            the section number
	 * @param credits
	 *            the credit hours
	 */
	public Section(String department, int course, int section, int creditHours) {
		this.department = department;
		this.course = course;
		this.section = section;
		this.creditHours = creditHours;
	}

	/**
	 * 
	 * @return the course number
	 */
	public int getCourse() {
		return course;
	}

	/**
	 * 
	 * @return the credits
	 */
	public int getCreditHours() {
		return creditHours;
	}

	/**
	 * 
	 * @return the department name
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * 
	 * @return the section number
	 */
	public int getSection() {
		return section;
	}

	/**
	 * Returns a brief description of the Card. The exact details of the
	 * representation are unspecified and subject to change, but the following
	 * may be regarded as typical: "Department # Section # (Credits)" "History
	 * 101 Section 02 (3)"
	 */

	@Override
	public String toString() {
		return department + " " + course + " Section " + section + " ("
				+ creditHours + ")";
	}
}
