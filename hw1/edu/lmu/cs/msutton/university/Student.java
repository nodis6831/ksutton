//TODO Should the phone class be completely immutable even through the Student class or is it ok for Student to reference a new Phone
package edu.lmu.cs.msutton.university;

import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import edu.lmu.cs.msutton.university.Person.Phone;

/**
 * A simple Student class
 * 
 * @author Kelly Sutton
 * @author Garrett Shannon
 * 
 */
public class Student {
	private final Person person;

	private String country;

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
		person = new Person(name, male, yob);
		this.country = country;
	}

	/**
	 * forwarding method
	 * 
	 * @return the name
	 */
	public String getName() {
		return person.getName();
	}

	/**
	 * forwarding method
	 * 
	 * @return the phone
	 */
	public Phone getPhone() {
		return person.getPhone();
	}

	/**
	 * forwarding method
	 * 
	 * @param phone
	 */
	public void setPhone(Phone phone) {
		person.phone = phone;
	}

	/**
	 * forwarding method
	 * 
	 * @return the year of birth
	 */
	public int getYob() {
		return person.getYob();
	}

	/**
	 * forwarding method
	 * 
	 * @return the gender
	 */
	public boolean isMale() {
		return person.isMale();
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
	 * @return the credits hours
	 */
	public int getCreditHours() {
		return transcript.getCreditHours();
	}

	/**
	 * 
	 * @return the gpa
	 */
	public double getGpa() {
		return transcript.computeGpa();
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
	 * @author Garrett Shannon Some code borrowed form class MoneyBag
	 */
	private class Transcript {

		private Map<Section, Grade> contents = new TreeMap<Section, Grade>();

		private int creditHours = 0;

		private double gradePoints = 0;

		/**
		 * 
		 * @param section
		 *            the section
		 * @param grade
		 *            the grade
		 */
		void add(Section section, Grade grade) {
			contents.put(section, grade);
			creditHours += section.getCreditHours();
			gradePoints += grade.getGrade();
		}

		/**
		 * 
		 * @return the overall gpa
		 */
		double computeGpa() {
			return gradePoints / (double) creditHours;

		}

		/**
		 * 
		 * @return the total crdit hours
		 */
		public int getCreditHours() {
			return creditHours;
		}

		/**
		 * Returns a brief description of the Card. The exact details of the
		 * representation are unspecified and subject to change, but the
		 * following may be regarded as typical: "Section:History Grade:95.34(A) | "
		 */

		@Override
		public String toString() {
			StringBuffer buffer = new StringBuffer("Section: ");
			for (Entry<Section, Grade> entry : contents.entrySet()) {
				buffer.append(entry.getKey() + " Grade:" + entry.getValue()
						+ " | ");
			}
			return buffer.toString();
		}
		
		//TODO equals method
	}

}
