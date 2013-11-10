package seph;

public class Polynomials2 {
	
	int polynomial[] = {2, 7};
	int multiplier = 3;
	public void multiply() {
		int quantity = polynomial.length;
		int count = 1;
		
		System.out.print("(");
		for(int i = 0; i < quantity; i++){
			count = count + 1;
		int finalpolynomial = polynomial[i] * multiplier;
		System.out.print(finalpolynomial);
		
		//when i gets to a certain size, don't pring a plus sign
		
		if(i + 1 < quantity)
		{
			System.out.print(" + ");
		}
		
		}
		System.out.print(")");
	}
	
public static void main(String[] args) {
	Polynomials2 poly = new Polynomials2();
	poly.multiply();
}
}
