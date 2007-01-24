package edu.lmu.cs.ksutton.hw1;

import java.math.BigInteger;

public class NumericalMethods {

	public static BigInteger fibonacci(int n){
		
		BigInteger a = new BigInteger("0");
		BigInteger b = new BigInteger("1");
		BigInteger f = new BigInteger("-1");
		
		if (n <= 0){
			throw new IllegalArgumentException();
		}
			
		
		if (n == 1){
			return a;
		}
		
		else if (n == 2){
			return b;
		}
		
		else{ //n > 2
			for (int i = 0; i <= n; i++){
				f = a.add(b);
				a = b;
				b = f;
			}
			return f;
		}
	}
}
