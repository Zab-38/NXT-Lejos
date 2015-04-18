package com.bitcold.charts.tookit;

public class DoubleDoubleValue extends DataCoordinates<Double, Double> {
	
	Double[] getXs()
	{
		return listx.toArray(new Double[listx.size()]);
	}
	
	Double[] getYs()
	{
		return listy.toArray(new Double[listy.size()]);
	}

}
