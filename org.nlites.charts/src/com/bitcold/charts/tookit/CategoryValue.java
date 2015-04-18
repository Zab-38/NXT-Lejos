package com.bitcold.charts.tookit;

public class CategoryValue extends DataCoordinates<String, Double> {
	
	public String[] getCategories()
	{
		return listx.toArray(new String[listx.size()]);
	}
	
	public Double[] getValues()
	{
		return listy.toArray(new Double[listy.size()]);
	}

}
