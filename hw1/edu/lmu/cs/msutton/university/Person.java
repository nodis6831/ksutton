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
	 *            The person's gender. True for male, false for female.
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

	/**
	 * 
	 * @return the phone
	 */
	public Phone getPhone() {
		return phone;
	}

	/**
	 * 
	 * @param phone
	 */
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

	/**
	 * 
	 * @author Kelly Sutton
	 * @author Garrett Shannon
	 * 
	 */
	class Phone {

		private final int areaCode;

		private final int prefix;

		private final int suffix;

		/**
		 * 
		 * @param a
		 *            Area code of the phone number
		 * @param p
		 *            Prefix of the phone number
		 * @param s
		 *            Suffix of the phone number
		 */
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
