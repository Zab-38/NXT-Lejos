package josh.series.fibonacci;

public class Fibonacciedit_counter {
	int first = 0;
	int second = 1;
	int value = 0;

	public void print() {
		value = value + 1;
		System.out.println(value + ":" + first);
	}

	public void count() {
		int sum = first + second;
		first = second;
		second = sum;

	}

	public static void main(String[] args) {
		Fibonacciedit_counter hmo = new Fibonacciedit_counter();
		while (hmo.value < 10) {
			hmo.print();
			hmo.count();
		}
	}
}
