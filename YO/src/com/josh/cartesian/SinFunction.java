package com.josh.cartesian;

public class SinFunction implements IFunction {

	@Override
	public double function(double x) {
		return 10*Math.sin(x);
	}

}
