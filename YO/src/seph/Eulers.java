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
		
//		 1 + 1/1! + 1/2! + 1/3! + 1/4! + 1/5! + 1/6! + 1/7! +
//		 in other words: answer + 1/denominator 

//		IT IS NOT  1+ 1! + 2! + 3! 
		answer = answer + denominator;
	}
	
	public void answer() {
		
//		  this is incorrect, answer is simply the sum of all the terms
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
