package edu.lmu.cs.msutton.hash;

/**
 * A class to represent a country! How exciting!
 * 
 * @author Garrett Shannon
 * @author Kelly Sutton
 */

public class Country {
	public String name, language;

	public int area, population;

	public Country(String n, String l, int a, int p) {
		name = n;
		language = l;
		area = a;
		population = p;
	}

	public String toString() {
		return "(" + name + "," + language + "," + area + "," + population
				+ ")";
	}
}
