package seph;

public class Eulers {
	int denominator = 1;
	int increase = 1;
	
	public void changedenominator() {
	    denominator = denominator * increase;
	    increase = increase + 1;
	}
	//WHAT IS WRONG HEEEREEE :( (not just there but you will see what i mean when it is run :D)
	public int count() {
		int count = 0;
		count = count + 1;
		return count;
	}
	
	public void print() {
		System.out.println(denominator);
	} 
	public static void main(String[] args) {
		Eulers e = new Eulers();
		
		while (e.count() < 100);
		{
			e.changedenominator();
			e.print();
			e.count();
		}
		
	}
}
