package edu.lmu.cs.msutton.math;

import java.util.ArrayList;
import java.util.List;

public class ArrayPolynomial extends Polynomial {

	private List coefficients = new ArrayList();

	public ArrayPolynomial(String coefficients) {

		for (String string : coefficients) {
			this.coefficients.add(Double.parseDouble(string));
		}
	}
	
	public ArrayPolynomial(double[] coefficients){
		for(double[] double : coefficients){
			this.coefficients.add(double);
		}
	}
}
