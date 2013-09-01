package seph;

public class ArniePie {

	double sum  = 0;
	double denominator = 1;
	double sign = 1;
	
	
	public double nextTerm()
	{
		double term = 1.0/denominator*sign;
		sign = sign * -1;
		denominator = denominator + 2;
		return term;
	}
	
	public double calculateSum()
	{
		sum+= nextTerm();
		return sum;
	}
	
	

	public static void main(String[] args) {
		
		ArniePie pi = new ArniePie();
		
		for(int i  = 0; i < 100000; i++)
		{
			System.out.println(pi.calculateSum()*4);
		}
	}
	
	
	
}


