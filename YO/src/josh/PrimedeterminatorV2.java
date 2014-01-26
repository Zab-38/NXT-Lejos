package josh;

public class PrimedeterminatorV2



{
	
	public boolean isPrimeNumber(int num )
	{
		
		for(int div = 2; div < (num-1)/2+2; div++)
		{
			if(num %div==0)return false;
		}

		return true;
		
	}

	public static void main(String[] args) {
		PrimedeterminatorV2 prime = new PrimedeterminatorV2();

		for(int i=1 ;i<10;i++)
		{
			if(prime.isPrimeNumber(i))
			{
				System.out.println(i + ", ");
			}
		}
	}
}
