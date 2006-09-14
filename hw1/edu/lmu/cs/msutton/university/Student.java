package edu.lmu.cs.msutton.university;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Garrett Shannon
 * @author Kelly Sutton
 * 
 */
public class Student extends Person {
	private String country;

	private int credits;

	private double gpa;

	private final Transcript transcript = new Transcript();

	public Student(String name, boolean male, int yob, String country) {
		super(name, male, yob);
		this.country = country;
	}

	public void updateTranscript(Section section, Grade grade) {
		transcript.add(section, grade);
	}

	public void printTranscript() {
		System.out.println(transcript);
	}

	private class Transcript {
		private List sectionList = new ArrayList();

		private List gradeList = new ArrayList();

		void add(Section section, Grade grade) {
			sectionList.add(section);
			gradeList.add(grade);
		}

		public String toString() {
			List tmp = new ArrayList;
			s.
			
			return sectionList.toString() + gradeList.toString()
		}
	}

}
