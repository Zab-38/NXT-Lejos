package josh.series.fibonacci;

/*
  http://www.mathsisfun.com/numbers/nature-golden-ratio-fibonacci.html
 *
 * 
 * Approximate the golden ratio using the fibonacci sequence
 * Golden ratio is the ratio between the sum of two distances of a line divided by the distance of the second value of one part of the line. 
 */
public class GoldenRatio {
	
	
	public double calculateGoldenRatio(int termId)
	{
		Fibonacci fibonacci = new Fibonacci();
		
		for(int i = 0; i < termId; i++)
		{
			fibonacci.calculateNextTerm();
		}
		
		double result = 0;
		
//do calculation here
		result = (double)fibonacci.getSecondnumber()/(double)fibonacci.getFirstnumber();
		
		return result;
	}

	
	public static void main(String[] args) {

		GoldenRatio gr = new GoldenRatio();
		System.out.println(gr.calculateGoldenRatio(25));
		
	}
}