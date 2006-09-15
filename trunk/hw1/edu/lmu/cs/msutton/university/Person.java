/*
 * Note: The field for Phone and all its related methods have been commented out
 * as it is not used by the Student class which is the main focus of this execise.
 */
package edu.lmu.cs.msutton.university;

/**
 * @author Kelly Sutton
 * @author Garrett Shannon
 */
public class Person {
	protected boolean male;

	protected String name;

	// protected Phone phone;

	protected int yob;

	/**
	 * A person class
	 * 
	 * @param name
	 *            The person's name
	 * @param male
	 *            The person's gender. true for male, false for female
	 * @param yob
	 *            The person's year of birth.
	 */
	public Person(String name, boolean male, int yob) {
		this.name = name;
		this.male = male;
		this.yob = yob;
	}

	/**
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	// public Phone getPhone() {
	// return phone;
	// }

	/**
	 * 
	 * @return the year of birth
	 */
	public int getYob() {
		return yob;
	}

	/**
	 * 
	 * @return the gender
	 */
	public boolean isMale() {
		return male;
	}

	// public void setPhone(Phone phone) {
	// this.phone = phone;
	// }
}
