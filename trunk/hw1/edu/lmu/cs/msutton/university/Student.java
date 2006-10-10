package edu.lmu.cs.msutton.university;

import java.math.BigDecimal;
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
public class Student {
	private final Person person;

	private final String country;

	private Transcript transcript = new Transcript();

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

	public Student(Person person, String country) {
		this.person = person;
		this.country = country;
	}

	/**
	 * forwarding method
	 * 
	 * @return the name of the student
	 */
	public String getName() {
		return person.getName();
	}

	/**
	 * forwarding method
	 * 
	 * @return the phone of the student
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
	 * @return the year of birth of the student
	 */
	public int getYob() {
		return person.getYob();
	}

	/**
	 * forwarding method
	 * 
	 * @return the gender of the student. True for male false for female
	 */
	public boolean isMale() {
		return person.isMale();
	}

	/**
	 * 
	 * @return the country of the student
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * 
	 * @return the total credit hours the student is taking
	 */
	public int credits() {
		if (transcript == null | transcript.contents.size() == 0)
			throw new IllegalStateException("No Transcript");
		int creditHours = 0;
		for (Entry<Section, Grade> entry : transcript.contents.entrySet()) {
			creditHours += entry.getKey().getCreditHours();
		}
		return creditHours;
	}

	/**
	 * 
	 * @return the gpa of the student to two decimal places
	 */
	public double gpa() {
		if (transcript == null | transcript.contents.size() == 0)
			throw new IllegalStateException("No Transcript");
		int creditHours = 0;
		double qualityPoints = 0;
		for (Entry<Section, Grade> entry : transcript.contents.entrySet()) {
			creditHours += entry.getKey().getCreditHours();
			qualityPoints += entry.getKey().getCreditHours()
					* entry.getValue().getGradePoints();
		}
		int decimalPlace = 2;
		BigDecimal bd = new BigDecimal(qualityPoints / creditHours);
		bd = bd.setScale(decimalPlace, BigDecimal.ROUND_FLOOR);
		return (bd.doubleValue()); //rounds double to 2 decimal places

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
 * 
 * @return the transcript
 */
	public String printTranscript() {
		return transcript.toString();
	}

	@Override
	/**
	 * Returns a brief description of the Student. The exact details of the
	 * representation are unspecified and subject to change, but the following
	 * may be regarded as typical:
	 * 
	 * "name male yob country" "Kelly Sutton Male 1987 USA"
	 */
	public String toString() {
		return person + " " + country;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = super.hashCode();
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

		/**
		 * Adds a section and its corresponding grade to the transcript
		 * 
		 * @param section
		 * @param grade
		 */
		public void add(Section section, Grade grade) {
			contents.put(section, grade);
		}

		/**
		 * Returns a brief description of the Transcript. The exact details of
		 * the representation are unspecified and subject to change, but the
		 * following may be regarded as typical: "section : grade || section :
		 * grade"
		 */
		@Override
		public String toString() {
			if (this == null | contents.size() == 0)
				throw new IllegalStateException("No Transcript");
			StringBuffer buffer = new StringBuffer("|| ");
			for (Entry<Section, Grade> entry : contents.entrySet()) {
				buffer.append(entry.getKey() + " : " + entry.getValue()
						+ " || ");
			}
			return buffer.toString();
		}

		@Override
		public int hashCode() {
			final int PRIME = 31;
			int result = 1;
			result = PRIME * result
					+ ((contents == null) ? 0 : contents.hashCode());
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
			return true;
		}

	}

}
