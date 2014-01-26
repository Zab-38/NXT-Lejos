package com.josh.math;

public class PiFromLeibnitz {

	double denominator = 1;
	double sign = 1;
    double both = 0;
	public double flipSign() {
		sign = sign * -1.0;
		return sign;
	}

	public double nextTerm() {
		double term = 1.0 / denominator * sign;
		flipSign();
		denominator = denominator + 2;
		both = both + term;
		return term;
	}
	
	public void answer(){
		both = both * 4;
		System.out.println(both);
	}

	public static void main(String[] args) {

		PiFromLeibnitz pi = new PiFromLeibnitz();

		for (int i = 0; i < 100; i++) {

			System.out.println(pi.nextTerm());
			
		}
		pi.answer();
		

	}

}