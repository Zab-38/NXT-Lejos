package seph;

public class Primedeterminator {
	int x = 1;
	double input = 1000;
	double comparison = input - 1;

	public boolean isPrime() {
		double divisor = 0;
		double modulusanswer = 0;

		while (x < input - 2) {
			x = x + 1;
			divisor = input - x;

			modulusanswer = input % divisor;
			if (modulusanswer == 0) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Primedeterminator prime = new Primedeterminator();

		System.out.println("Is this prime: " + prime.isPrime());
	}
}
