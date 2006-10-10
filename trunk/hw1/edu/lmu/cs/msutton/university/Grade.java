package edu.lmu.cs.msutton.university;

/**
 * 
 * @author Kelly Sutton
 * @author Garrett Shannon
 * 
 */
public class Grade {
	private double grade;
	private double gradePoints;

	/**
	 * 
	 * @param grade
	 *            the grade as a double
	 */
	public Grade(double grade) {
		this.grade = grade;
		if (this.grade < 60.0)
			gradePoints = 0.0;
		else if (this.grade < 63.0 && this.grade >= 60.0)
			gradePoints = .7;
		else if (this.grade < 66.0 && this.grade >= 63.0)
			gradePoints = 1.0;
		else if (this.grade < 70.0 && this.grade >= 66.0)
			gradePoints = 1.3;
		else if (this.grade < 73.0 && this.grade >= 70.0)
			gradePoints = 1.7;
		else if (this.grade < 76.0 && this.grade >= 73.0)
			gradePoints = 2.0;
		else if (this.grade < 80.0 && this.grade >= 76.0)
			gradePoints = 2.3;
		else if (this.grade < 83.0 && this.grade >= 80.0)
			gradePoints = 2.7;
		else if (this.grade < 86.0 && this.grade >= 83.0)
			gradePoints = 3.0;
		else if (this.grade < 90.0 && this.grade >= 86.0)
			gradePoints = 3.3;
		else if (this.grade < 93.0 && this.grade >= 90.0)
			gradePoints = 3.7;
		else
			gradePoints = 4.0;		
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
	 * @return the grade points
	 */
	public double getGradePoints(){
		return gradePoints;
	}
	
	/**
	 * 
	 * @return a string representation of the letter grade
	 */
	public String getLetterGrade() {
		if (grade < 60.0)
			return "F";
		else if (grade < 63.0 && grade >= 60.0)
			return "D-";
		else if (this.grade < 66.0 && grade >= 63.0)
			return "D";
		else if (grade < 70.0 && grade >= 66.0)
			return "D+";
		else if (grade < 73.0 && grade >= 70.0)
			return "C-";
		else if (grade < 76.0 && grade >= 73.0)
			return "C";
		else if (grade < 80.0 && grade >= 76.0)
			return "C+";
		else if (grade < 83.0 && grade >= 80.0)
			return "B-";
		else if (grade < 86.0 && grade >= 83.0)
			return "B";
		else if (grade < 90.0 && grade >= 86.0)
			return "B+";
		else if (grade < 93.0 && grade >= 90.0)
			return "A-";
		else if (grade < 96.0 && grade >= 93.0)
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
