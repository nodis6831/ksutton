package edu.lmu.cs.msutton.university;

/**
 * @author Kelly Sutton
 * @author Garrett Shannon
 */
public class Person {

	private final String name;

	private final boolean male;

	private final int yob;

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
		if (phone == null)
			throw new IllegalStateException("The phone has not been set");
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
	 * @return the gender, true for male, false for female
	 */
	public boolean isMale() {
		return male;
	}

	@Override
	/**
	 * Returns a brief description of the Person. The exact details of the
	 * representation are unspecified and subject to change, but the following
	 * may be regarded as typical:
	 * 
	 * "name male yob" "Kelly Sutton Male 1987"
	 */
	public String toString() {
		if(male) {
			return name + " Male " + yob;
		}
		else return name + " Female " + yob; 
	}
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
}
