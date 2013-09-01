package seph;

public class Sop {
	int first = 0;
	int second = 1;
	int value = 0;

	private void print() {

		value = value + 1;
		System.out.println(value + ":" + first);
	}

	private void sum() {
		int sum = first + second;
		first = second;
		second = sum;
	}

	public static void main(String[] args) {
		Sop s = new Sop();
		while (s.value < 1000) {
			s.print();
			s.sum();
		}
	}
}
