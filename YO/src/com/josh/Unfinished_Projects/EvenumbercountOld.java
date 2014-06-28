package com.josh.Unfinished_Projects;

public class EvenumbercountOld {

	public void calculate(int first, int last) {
		for (int i = first + 1; i < last; i++) {
			System.out.println(i + " = " + isEven(i));
		}
	}

	public boolean isEven(int num) {
		int result = num / 2;
		if (result * 2 == num)
			return true;
		return false;

	}

	// public boolean isEvenUsingModulus(int num)
	// {
	// int remainder = num%2;
	// if (remainder == 0) return true;
	// else return false;
	//
	//
	// }

	public static void main(String[] args) {
		EvenumbercountOld e = new EvenumbercountOld();

		e.calculate(2, 10);
	}
}
