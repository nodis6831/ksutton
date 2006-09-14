package edu.lmu.cs.msutton.university;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael Sutton
 * @author Garrett Shannon
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

	public String getCountry() {
		return country;
	}

	public int getCredits() {
		return credits;
	}

	public double getGpa() {
		return gpa;
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

		@Override
		public String toString() {
			List tmp = new ArrayList();
			for (int i = 0; i < sectionList.size(); i++) {
				tmp.add(sectionList.get(i));
				tmp.add(gradeList.get(i));
			}

			return tmp.toString();
		}
	}

}
