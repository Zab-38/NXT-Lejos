package angles;

import lejos.geom.Point;

public class Angles {

	
	double angleToRadian(double angle)
	{
		return angle*Math.PI/180.0;
	}
	Point convert(double angle, double hypotenuse)
	{
//		hypotenuse*Math.cos(angle);
		return null;
	}
	
	public static void main(String[] args) {
		Angles a = new Angles();
		
		double result = a.angleToRadian(180);
		System.out.println(result);
		
	}
}
