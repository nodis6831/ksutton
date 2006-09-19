package edu.lmu.cs.msutton.university;

/**
 * @author Kelly Sutton
 * @author Garrett Shannon
 */
public class Person {
	protected boolean male;

	protected String name;

	protected Phone phone;

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

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

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

	class Phone {
		private final int areaCode;

		private final int prefix;

		private final int suffix;

		public Phone(int a, int p, int s) {
			this.areaCode = a;
			this.prefix = p;
			this.suffix = s;
		}

		@Override
		public String toString() {
			return "(" + this.areaCode + ") - " + this.prefix + " - "
					+ this.suffix;
		}
	}

}
