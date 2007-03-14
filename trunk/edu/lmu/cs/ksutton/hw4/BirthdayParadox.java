package edu.lmu.cs.ksutton.hw4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class BirthdayParadox {

	public static Random generator = new Random();

	public static ArrayList<Integer> a = new ArrayList<Integer>();
	
	public static void main(String[] args){
		
		
		int n;
		int match = 0;
		
		try{
			n = Integer.parseInt(args[0]);
		}
		catch (Exception e){
			throw new IllegalArgumentException("The number of people must be greater than 0");
		}
		
		for( int i = 0; i < 1000000; i++){
			match += computeBirthdays(n);
		}
		
		System.out.println("The estimated probably that two people will have the same birthday in a room of " + n + " people is:\n" + (double)match / 1000000.0 );
		
	}
	
	public static int computeBirthdays(int n){
		
		//Generate random birthdays for each person
		for (int i = 0; i < n; i++){
			a.add(generator.nextInt(365));
		}
		
		//Sort the birthdays
		Collections.sort(a);
		
		//See if there's a match
		for (int j = 0; j < n - 1; j++){
			if (a.get(j) == a.get(j+1)){
				a.clear();
				return 1; //we found a match
			}
			else
				j++; //no match found, keep moving
		}
		
		a.clear();
		return 0;
	}
}
