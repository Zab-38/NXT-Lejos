package com.josh.cartesian;

public class FractionConversion {
	int numerator = 124;
	int denominator = 7;
	int excess = numerator / denominator;
	int remainder = numerator - excess * denominator;
	int whole = excess;

	public void print() {
		System.out.println(whole + " " + remainder + "/" + denominator);
	}

	public static void main(String[] args) {

		FractionConversion c = new FractionConversion();
		c.print();
	}

}
