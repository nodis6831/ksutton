package edu.lmu.cs.msutton.university;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple Student class
 * 
 * @author Kelly Sutton
 * @author Garrett Shannon
 * 
 */
public class Student extends Person {
	private String country;

	private int credits;

	private double gpa;

	private final Transcript transcript = new Transcript();

	/**
	 * 
	 * @param name The student's name
	 * @param male The student's gender. true for male, false for female
	 * @param yob The student's year of birth
	 * @param country The student's country
	 */
	public Student(String name, boolean male, int yob, String country) {
		super(name, male, yob);
		this.country = country;
	}

	/**
	 * 
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * 
	 * @return the credits
	 */
	public int getCredits() {
		return credits;
	}

	/**
	 * 
	 * @return the gpa
	 */
	public double getGpa() {
		return gpa;
	}

	public void updateTranscript(Section section, Grade grade) {
		transcript.add(section, grade);
	}

	/**
	 * Prints the transcript
	 *
	 */
	public void printTranscript() {
		System.out.println(transcript);
	}

	/**
	 * A simple transcript class
	 * 
	 * @author Kelly Sutton
	 * @author Garrett Shannon
	 */
	private class Transcript {
		private List sectionList = new ArrayList();

		private List gradeList = new ArrayList();

		/**
		 * 
		 * @param section The section
		 * @param grade The grade
		 */
		void add(Section section, Grade grade) {
			sectionList.add(section);
			gradeList.add(grade);
		}

		@Override
		public String toString() {
			List tmp = new ArrayList();
			for (int i = 0; i < sectionList.size(); i++) {
				tmp.add(sectionList.get(i));
				tmp.add(gradeList.get(i));
			}

			return tmp.toString();
		}
	}

}
