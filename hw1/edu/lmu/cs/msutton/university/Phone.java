package edu.lmu.cs.msutton.university;

public class Phone {

	private final int areaCode;

	private final int prefix;

	private final int suffix;

	/**
	 * 
	 * @param areaCode
	 *            the area code
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
	 * representation are unspecified and subject to change, but the following
	 * may be regarded as typical: "(AAA)-PPP-SSS" "(310)-338-2768"
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
