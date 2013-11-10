package seph;

public class PrimedeterminatorV1 {
	
	public boolean isPrimeNumber(int num )
	{
		
		for(int div = 2; div < (num-1)/2+1; div++)
		{
			if(num %div==0)return false;
		}

		return true;
		
	}

	public static void main(String[] args) {
		PrimedeterminatorV1 prime = new PrimedeterminatorV1();

		for(int i=49000000 ;i<50000000;i++)
		{
			if(prime.isPrimeNumber(i))
			{
				System.out.println(i + ", ");
			}
		}
	}
}
