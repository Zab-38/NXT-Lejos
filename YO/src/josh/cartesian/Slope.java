package josh.cartesian;

public class Slope {
  
	
	double x1 = 1;
  double y1 = 2;
  double x2 = 3;
  double y2 = 4;
  double ydouble = y2 - y1;
  double xdouble = x2 - x1;
  public double calculate(Point point1, Point point2) {
	  
	  double slope = (point2.y - point1.y) / (point2.x - point1.x);
	  return slope;
	  
  }
  
  public static void main(String[] args) {
	Slope s = new Slope();
	Point p1 = new Point(0, 0);
	Point p2 = new Point(1,1);
	
	System.out.println(s.calculate(p1, p2));
	
}
}
