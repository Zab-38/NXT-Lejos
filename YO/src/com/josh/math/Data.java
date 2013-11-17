package com.josh.math;

import java.util.ArrayList;

public class Data {

	ArrayList<String> list = new  ArrayList<>();
	
	public void storeData()
	{
		list.add("Arnold");
		list.add("Josh");
	}
	
	public void printData()
	{
		for(String s:list)
		{
			System.out.println(s);
		}
	}
	
	public static void main(String[] args) {
		Data d = new  Data();
		d.storeData();
		d.printData();
		
		
	}
	
}
