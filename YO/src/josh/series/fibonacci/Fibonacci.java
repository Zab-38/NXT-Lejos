package josh.series.fibonacci;

import seph.Sop;

public class Fibonacci {
	int firstnumber = 0;
	int secondnumber = 1;
	int numinplace = 0;

	private void sysout() {

		numinplace = numinplace + 1;
		System.out.println(numinplace + "=" + firstnumber);
	}

	private void add() {
		int sum = firstnumber + secondnumber;
		firstnumber = secondnumber;
		secondnumber = sum;
	}

	public static void main(String[] args) {
		Fibonacci fib = new Fibonacci();
		while (fib.numinplace < 100) {
			fib.sysout();
			fib.add();
}}}
