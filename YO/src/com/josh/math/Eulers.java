package com.josh.math;

public class Eulers {
	double denominator = 1;
	double increase = 1;
	int count = 0;
	double sum = 0;

	public void changedenominator() {
		denominator = denominator * increase;
		increase = increase + 1;
	}

	public void addNextTermToSum() {

		sum = sum + 1.0 / denominator;
		System.out.println(sum + 1);
	}

	public int add() {

		count = count + 1;
		return count;
	}

	public static void main(String[] args) {
		Eulers e = new Eulers();

		while (e.count < 25) {
			e.changedenominator();
			e.addNextTermToSum();
			e.add();
		}

	}
}
