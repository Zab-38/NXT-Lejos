package com.josh.Unfinished_Projects;

public class Evenumbercount {
	int first = 2;
	int last = 9;

	public void calculate() {
		for (int i = first; i < last; i++) {

		}
	}
	
	public boolean isEven(int num)
	{
		int result = num/2;
		if (result*2 == num) return true;
		return false;
		
	}
	
	public boolean isEvenUsingModulus(int num)
	{
		int remainder = num%2;
		if (remainder == 0) return true;
		else return false;
		
		
	}

	public static void main(String[] args) {
		Evenumbercount e = new Evenumbercount();
		e.calculate();
	}
}
