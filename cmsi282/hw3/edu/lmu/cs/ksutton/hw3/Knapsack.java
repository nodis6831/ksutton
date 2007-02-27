package edu.lmu.cs.ksutton.hw3;

import java.util.HashMap;

public class Knapsack {

	private static HashMap<Integer, Integer> objects = new HashMap<Integer, Integer>();
	
	private static int[][] solutions = new int[85][85]; //[value][weights]
	
	
	public static void main(String[] args){
	
		objects.put(16, 14);
		objects.put(14, 13);
		objects.put(18, 22);
		objects.put(15, 20);
		objects.put(7, 12);
		objects.put(21, 25);
		objects.put(45, 51);
		objects.put(5, 9);
		objects.put(9, 13);
		objects.put(22, 22);
		objects.put(19, 17);
		objects.put(24, 23);
		
		int size = Integer.parseInt(args[0]);
		
		for (int i = 0; i < size; i++){
			
		}
				
	}
}
