package edu.lmu.cs.msutton.university;

/**
 * @author Kelly Sutton
 * @author Garrett Shannon
 */
public class Person {

	private String name;

	private boolean male;

	private int yob;

	private Phone phone;

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
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + (male ? 1231 : 1237);
		result = PRIME * result + ((name == null) ? 0 : name.hashCode());
		result = PRIME * result + ((phone == null) ? 0 : phone.hashCode());
		result = PRIME * result + yob;
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
		final Person other = (Person) obj;
		if (male != other.male)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (yob != other.yob)
			return false;
		return true;
	}

	class Phone {

		private final int areaCode;

		private final int prefix;

		private final int suffix;

		/**
		 * 
		 * @param areaCode
		 *            the area code *
		 * @param prefix
		 *            the prefix
		 * @param suffix
		 *            the suffix
		 */
		public Phone(int areaCode, int prefix, int suffix) {
			this.areaCode = areaCode;
			this.prefix = prefix;
			this.suffix = suffix;
		}

		/**
		 * Returns a brief description of the Card. The exact details of the
		 * representation are unspecified and subject to change, but the
		 * following may be regarded as typical: "(AAA)-PPP-SSS"
		 * "(310)-338-2768"
		 */

		@Override
		public String toString() {
			return "(" + this.areaCode + ")-" + this.prefix + "-" + this.suffix;
		}

		@Override
		public int hashCode() {
			final int PRIME = 31;
			int result = 1;
			result = PRIME * result + areaCode;
			result = PRIME * result + prefix;
			result = PRIME * result + suffix;
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
			final Phone other = (Phone) obj;
			if (areaCode != other.areaCode)
				return false;
			if (prefix != other.prefix)
				return false;
			if (suffix != other.suffix)
				return false;
			return true;
		}
	}

}
