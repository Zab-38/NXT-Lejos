package com.bitcold.charts.tookit;

import java.util.ArrayList;
import java.util.List;

public class DataCoordinates<X,Y> {
	
	List <X> listx = new ArrayList<X>();
	List <Y> listy = new ArrayList<Y>();
	
	
	
	public List<X> getListx() {
		return listx;
	}

	
	public List<Y> getListy() {
		return listy;
	}
	
	

	public void add(X x, Y y)
	{
		listx.add(x);
		listy.add(y);
	}
	

}
