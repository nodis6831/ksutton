package edu.lmu.cs.msutton.university;

public class StudentTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Student s = new Student("Kelly", true, 1987, "USA");
		s.updateTranscript(Section.ENGLISH, Grade.BPLUS);
		s.printTranscript();
	}

}
