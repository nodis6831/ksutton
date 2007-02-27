package edu.lmu.cs.ksutton.hw3;

public class EditDistanceComputer {

	private static String s1;
	private static String s2;
	
	private static int count = 0;
	
	public static void main(String[] args){
	
		if (args[0] == null || args[1] == null)
			throw new IllegalArgumentException();
		
		s1 = args[0];
		s2 = args[1];
		
		for (int i = 0; i < s1.length() || i < s2.length(); i++){
			
			//We've run out of s1
			if( i >= s1.length()){
				count += s2.length() - s1.length();
				break;
			}
			//We've run out of s2
			else if( i >= s2.length()){
				count += s1.length() - s2.length();
				break;
			}
			
			//The characters match, do not add
			else if(s1.charAt(i) != s2.charAt(i))
				count++;
		}
		
		System.out.println("The edit distance between \"" + s1 + "\" and \"" + s2 +"\" is: " + count);
		
	}
	
}
