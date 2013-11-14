
package com.josh.math;

public class Polynomials {
	
	
	private int[] calculateMultipliedPolynomial(int multiplier, int[] polynomial)
	{
		int answer[] = new int[polynomial.length];
		
	   for(int i = 0; i < polynomial.length; i++)
	   {
		answer[i ]= multiplier*polynomial[i];    
	   }
	   return answer;
	}
	
	
	private void printPolynomial(int p[])
	{
	  System.out.print("(");
	  for(int i = 0; i< p.length; i++)
	   {System.out.print(p[i]);
	   if(i == p.length - 1)break;
	   System.out.print(", ");
	   }
	  System.out.print(")");
	}
	
	
	
public static void main(String[] args) {
	Polynomials poly = new Polynomials();
	
	int firstPolynomial[] = {2,4,5};
	int secondPolynomial[] = {3,5,5,1,2};
	//poly.answer();
	int[] polynomialarray = poly.calculateMultipliedPolynomial(2,firstPolynomial);
	poly.printPolynomial(polynomialarray);
	
	polynomialarray = poly.calculateMultipliedPolynomial(3, secondPolynomial);
	poly.printPolynomial(polynomialarray);
}
}
