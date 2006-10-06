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
	 *            the grade as a double
	 */
	public Grade(double grade) {
		this.grade = grade;
	}

	/**
	 * 
	 * @return the grade as a bouble
	 */
	public double getGrade() {
		return grade;
	}

	/**
	 * 
	 * @return a string representation of the letter grade
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
	 * Returns a brief description of the Grade. The exact details of the
	 * representation are unspecified and subject to change, but the following
	 * may be regarded as typical: "94.76(A)"
	 */
	@Override
	public String toString() {
		return this.grade + "(" + this.getLetterGrade() + ")";
	}


	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(grade);
		result = PRIME * result + (int) (temp ^ (temp >>> 32));
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
		final Grade other = (Grade) obj;
		if (Double.doubleToLongBits(grade) != Double.doubleToLongBits(other.grade))
			return false;
		return true;
	}


}
