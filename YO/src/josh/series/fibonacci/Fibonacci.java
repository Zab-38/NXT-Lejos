package josh.series.fibonacci;


public class Fibonacci {
	private int firstnumber = 0;
	
	

	private  int secondnumber = 1;
	private int counter = 0;

	
	
	public int getFirstnumber() {
		return firstnumber;
	}

	public int getSecondnumber() {
		return secondnumber;
	}
	
	public void sysout() {
		counter = counter + 1;
		System.out.println(counter + "=" + firstnumber);
	}

	/**
	 * 
	 */
	public void calculateNextTerm() {
		int sum = firstnumber + secondnumber;
		firstnumber = secondnumber;
		secondnumber = sum;
	}

	public static void main(String[] args) {
		Fibonacci fib = new Fibonacci();
		while (fib.counter < 100) {
			fib.sysout();
			fib.calculateNextTerm();
}}}
