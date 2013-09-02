package seph;

public class Eulers {
	double denominator = 1;
	double increase = 1;
	double answer = 0;
	public void change() {
		denominator = denominator * increase;
		increase = increase + 1;
	}
	
	public void print() {
		System.out.println(denominator);
	}
	
	public void add() {
		answer = answer + denominator;
	}
	
	public void answer() {
		answer = answer / 10;
		System.out.println(answer);
	}
	
	
public static void main(String[] args) {
	Eulers e = new Eulers();
	for(int i  = 0; i < 10; i++)
	{
	e.print();
	e.change();
	e.add();
	}
	e.answer();
	
}
}
