package com.josh.math;

public class Slope {
double x = 6;
double y = 2;


public Slope(double _x , double _y) {

	x = _x;
	y = _y;
}

private void remake() {
	System.out.println("Slope = " + x + "/" + y);
}

public static void main(String[] args) {
	Slope po = new Slope(3,5);
	po.remake();
}
}
