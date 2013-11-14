package com.josh.cartesian;

public class Slope {
  
	
  public double calculate(Point point1, Point point2) {
	  
	  double slope = (point2.y - point1.y) / (point2.x - point1.x);
	  return slope;
	  
  }
  
  public static void main(String[] args) {
	Slope s = new Slope();
	Point p1 = new Point(1, 4);
	Point p2 = new Point(7,-1);
	
	System.out.println(s.calculate(p1, p2));
	
}
}
