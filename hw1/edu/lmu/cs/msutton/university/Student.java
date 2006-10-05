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

	private final String country;

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
		person.setPhone(phone);
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
	public int credits() {
		return transcript.creditHours;
	}

	/**
	 * 
	 * @return the gpa
	 */
	public double gpa() {
		return transcript.gradePoints / (double) transcript.creditHours;
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

	@Override
	/**
	 * Returns a brief description of the Student. The exact details of the
	 * representation are unspecified and subject to change, but the following
	 * may be regarded as typical:
	 * 
	 * "name male yob phone country" "Kelly Sutton Male 1987 (123)-451-6718 USA"
	 */
	public String toString() {
		return person + country;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((country == null) ? 0 : country.hashCode());
		result = PRIME * result + ((person == null) ? 0 : person.hashCode());
		result = PRIME * result
				+ ((transcript == null) ? 0 : transcript.hashCode());
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
		final Student other = (Student) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (person == null) {
			if (other.person != null)
				return false;
		} else if (!person.equals(other.person))
			return false;
		if (transcript == null) {
			if (other.transcript != null)
				return false;
		} else if (!transcript.equals(other.transcript))
			return false;
		return true;
	}

	/**
	 * A simple transcript class
	 * 
	 * @author Kelly Sutton
	 * @author Garrett Shannon Some code borrowed form class MoneyBag
	 */
	private class Transcript {
		public Map<Section, Grade> contents = new TreeMap<Section, Grade>();

		public int creditHours = 0;

		public double gradePoints = 0;

		public void add(Section section, Grade grade) {
			contents.put(section, grade);
			creditHours += section.getCreditHours();
			gradePoints += grade.getGrade();
		}

		/**
		 * Returns a brief description of the Transcript. The exact details of the
		 * representation are unspecified and subject to change, but the
		 * following may be regarded as typical: "Section:History Grade:95.34(A) | "
		 */
		// TODO fix this description and the toString method
		@Override
		public String toString() {
			StringBuffer buffer = new StringBuffer();
			for (Entry<Section, Grade> entry : contents.entrySet()) {
				buffer.append(entry.getKey() + " Grade:" + entry.getValue()
						+ " | ");
			}
			return buffer.toString();
		}

		@Override
		public int hashCode() {
			final int PRIME = 31;
			int result = 1;
			result = PRIME * result
					+ ((contents == null) ? 0 : contents.hashCode());
			result = PRIME * result + creditHours;
			long temp;
			temp = Double.doubleToLongBits(gradePoints);
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
			final Transcript other = (Transcript) obj;
			if (contents == null) {
				if (other.contents != null)
					return false;
			} else if (!contents.equals(other.contents))
				return false;
			if (creditHours != other.creditHours)
				return false;
			if (Double.doubleToLongBits(gradePoints) != Double
					.doubleToLongBits(other.gradePoints))
				return false;
			return true;
		}

	}

}
