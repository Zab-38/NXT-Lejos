package com.josh.Unfinished_Projects;

public class PowerMultiplier {
	// Unchanging base exponent. long means the int can be longer.
	private long base = 0;

	// this uses base and exports it to other locations of the program.
	public PowerMultiplier(long base) {

		// "this" means that it is using the base in this specific class, not
		// another one.
		this.base = base;
	}

	public long powermultiply(int exponent) {

		long answer = 1;
		// this is the loop that declares the answers.
		if (exponent > 0) {
			for (int i = 0; i < exponent; i++) {
				answer = answer * base;
			}
		}
		return answer;
	}

	public long lastDigit(int exponent) {

		int[] digits = { 1, 3, 9, 7 };

		int lastDigit = digits[exponent % 4];

		return lastDigit;
	}

	public static void main(String[] args) {
		PowerMultiplier p = new PowerMultiplier(3);
		System.out.println("*******THIS IS BY BRUTE FORCE*******************************");

		// this line indicates the number below this word number.
		for (int i = 0; i < 8; i++) {
			// prints out the answer.
			System.out.println("7^" + i + ": " + p.powermultiply(i));
		}

		System.out.println("*******THIS IS MORE EFFICIENT AND ELEGENT*******************************");

		for (int i = 0; i < 8; i++) {
			System.out.println("7^" + i + ": " + p.lastDigit(i));

		}

		System.out.println("********THIS IS THE FAST ANSWER TO 7^1000******************************");

		System.out.println("7^1000 = " + p.lastDigit(1000));

	}
}
