package seph;

public class Point {
double x = 6;
double y = 2;


public Point(double _x , double _y) {

	x = _x;
	y = _y;
}

private void remake() {
	System.out.println("Slope = " + x + "/" + y);
}

public static void main(String[] args) {
	Point po = new Point(3,5);
	po.remake();
}
}
