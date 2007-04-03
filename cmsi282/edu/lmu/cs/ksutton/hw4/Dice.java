package edu.lmu.cs.ksutton.hw4;

import java.util.Random;

/**
 * The most simple Dice class ever
 * @author Kelly Sutton
 */
public class Dice {
	
	private int sides;
	
	private Random generator;
	
	/**
	 * Default constructor that creates a 6-sided die object
	 */
	public Dice(){
		sides = 6;
		generator = new Random();
	}
	
	/**
	 * Create a die with a specific number of sides
	 * @param s The number of sides on the diee
	 */
	public Dice(int s){
		sides = s;
		generator = new Random();
	}
	
	public int roll(){
		return generator.nextInt(sides) + 1;
	}
}
