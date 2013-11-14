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
		
		sum = sum + 1.0/denominator;
		System.out.println(sum+1);
	} 
	//WHAT IS WRONG HEEEREEE :( (not just there but you will see what i mean when it is run :D)
	public int add() {
		
		//count will exist and not exist in this method.  I think you want count to exist inside the class
		
		count = count + 1;
		return count;
	}
	//The natural longarithm is the area under a certain marked area on a x y grid.
	public static void main(String[] args) {
		Eulers e = new Eulers();
		
		while (e.count < 25)
		{
			e.changedenominator();
			e.addNextTermToSum();
			e.add();
		}
		
	}
}
