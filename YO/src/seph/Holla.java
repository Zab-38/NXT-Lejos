package seph;

public class Holla {
	int first = 0;
	int second = 1;
	int number = 0;
	
	private void print() {
		number = number + 1;
		System.out.println(number + ":" + first);
	
	}
	
	private void sum() {
    int sum = first + second;
    first = second;
    second = sum;
	}
	
public static void main(String[] args) {
	Holla hol = new Holla();
	
	while (hol.number < 1000) {
		hol.print();
		hol.sum();
	}
}
}
