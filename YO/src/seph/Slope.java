package seph;

public class Slope {
  double x1 = 1;
  double y1 = 2;
  double x2 = 3;
  double y2 = 4;
  double ydouble = y2 - y1;
  double xdouble = x2 - x1;
  public void calculate() {
	  double last = ydouble / xdouble;
	  System.out.println(last);
  }
  
  public static void main(String[] args) {
	Slope s = new Slope();
	s.calculate();
	
}
}
