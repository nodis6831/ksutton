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

	private int year;

	private boolean fallSemester;

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
	 * @param year
	 *            the year
	 * @param fallSemester
	 *            the semester
	 */
	public Section(String department, int course, int section, int creditHours,
			int year, boolean fallSemester) {
		this.department = department;
		this.course = course;
		this.section = section;
		this.creditHours = creditHours;
		this.year = year;
		this.fallSemester = fallSemester;
	}

	public int getCourse() {
		return course;
	}

	public int getCreditHours() {
		return creditHours;
	}

	public String getDepartment() {
		return department;
	}

	public int getSection() {
		return section;
	}

	public boolean isFallSemester() {
		return fallSemester;
	}

	public int getYear() {
		return year;
	}

	/**
	 * Returns a brief description of the Card. The exact details of the
	 * representation are unspecified and subject to change, but the following
	 * may be regarded as typical: "Department:department Course:# Section:#
	 * Credits:crdits Semester:semester Year:year" "Department:History
	 * Course:101 Section:02 Credits:3 Semester:Fall Year:2005"
	 */

	@Override
	public String toString() {
		if (fallSemester)
			return department + " " + course + " " + section + " "
					+ creditHours + " Fall " + year;
		else
			return department + " " + course + " " + section + " "
					+ creditHours + " Spring " + year;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + course;
		result = PRIME * result + creditHours;
		result = PRIME * result
				+ ((department == null) ? 0 : department.hashCode());
		result = PRIME * result + (fallSemester ? 1231 : 1237);
		result = PRIME * result + section;
		result = PRIME * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Section other = (Section) obj;
		if (course != other.course)
			return false;
		if (creditHours != other.creditHours)
			return false;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (fallSemester != other.fallSemester)
			return false;
		if (section != other.section)
			return false;
		if (year != other.year)
			return false;
		return true;
	}

}
