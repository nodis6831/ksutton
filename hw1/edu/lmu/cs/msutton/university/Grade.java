package edu.lmu.cs.msutton.university;

/**
 * 
 * @author Kelly Sutton
 * @author Garrett Shannon
 * 
 */
public class Grade {
	private double grade;

	/**
	 * 
	 * @param grade
	 *            the grade
	 */
	public Grade(double grade) {
		this.grade = grade;
	}

	/**
	 * 
	 * @return the grade
	 */
	public double getGrade() {
		return grade;
	}

	/**
	 * 
	 * @return the letter grade
	 */
	public String getLetterGrade() {
		if (this.grade < 60.0)
			return "F";
		else if (this.grade < 63.0 && this.grade >= 60.0)
			return "D-";
		else if (this.grade < 66.0 && this.grade >= 63.0)
			return "D";
		else if (this.grade < 70.0 && this.grade >= 66.0)
			return "D+";
		else if (this.grade < 73.0 && this.grade >= 70.0)
			return "C-";
		else if (this.grade < 76.0 && this.grade >= 73.0)
			return "C";
		else if (this.grade < 80.0 && this.grade >= 76.0)
			return "C+";
		else if (this.grade < 83.0 && this.grade >= 80.0)
			return "B-";
		else if (this.grade < 86.0 && this.grade >= 83.0)
			return "B";
		else if (this.grade < 90.0 && this.grade >= 86.0)
			return "B+";
		else if (this.grade < 93.0 && this.grade >= 90.0)
			return "A-";
		else if (this.grade < 96.0 && this.grade >= 93.0)
			return "A";
		else
			return "A+";
	}

	/**
	 * Returns a brief description of the Card. The exact details of the
	 * representation are unspecified and subject to change, but the following
	 * may be regarded as typical:
	 * "94.76(A)"
	 */
	@Override
	public String toString() {
		return this.grade + "(" + this.getLetterGrade() + ")";
	}

	//TODO equals method
}
