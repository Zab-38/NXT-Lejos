package angles;

import communications.BaseLejos;



public class PolarCoord extends BaseLejos{

	public class Point
	{
		public double x;
		public double y;
	}
	
	double convertAngleToRadians(double angle)
	{
		return Math.toRadians(angle);
	}
	
	Point convert(double angle, double hypotenuse)
	{
		double radians = convertAngleToRadians(angle);
		double x = hypotenuse * Math.cos(radians);
		double y=  Math.sqrt( hypotenuse * hypotenuse - x*x) ;
		Point p = new Point();
		p.x = x;
		p.y = y;
		return p;
	}
	
	public static void main(String[] args) {
		PolarCoord a = new PolarCoord();
		Point p = a.convert(90, 5);
		
		System.out.println(p.x +" ," + p.y);
		a.run();
 		
	}
}
