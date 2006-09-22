package edu.lmu.cs.msutton.university;

import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

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
	 * @param name
	 *            The student's name
	 * @param male
	 *            The student's gender. true for male, false for female
	 * @param yob
	 *            The student's year of birth
	 * @param country
	 *            The student's country
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

	/**
	 * Updates the transcript with a new section and a grade for that section
	 * 
	 * @param section
	 *            The section
	 * @param grade
	 *            The grade
	 */
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
	 * Some code borrowed form class MoneyBag
	 */
	private class Transcript {

		private Map<Section, Grade> contents = new TreeMap<Section, Grade>();

		/**
		 * 
		 * @param section the section
		 * @param grade the grade
		 */
		void add(Section section, Grade grade) {
			contents.put(section, grade);
		}

		@Override
		public String toString() {
			StringBuffer buffer = new StringBuffer("Section: ");
			for (Entry<Section, Grade> entry : contents.entrySet()) {
				buffer.append(entry.getKey() + " Grade: " + entry.getValue()
						+ " ");
			}
			return buffer.toString();
		}
	}

}
