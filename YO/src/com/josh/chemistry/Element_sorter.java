package com.josh.chemistry;

import java.util.ArrayList;
import java.util.Arrays;


public class Element_sorter {
	String elements[] = {"Hi","Derp","Lol"};
	int massvalues[] = {10, 7, 19};
	
	ArrayList<Element> elementList = new ArrayList<Element>();
	public void definemass () {
		
		for(int i=0; i < elements.length; i++)
		{
			
			Element e = new Element();
			e.mass = massvalues[i];
			e.name = elements[i];
			elementList.add(e);
			e.sort(massvalues);
			
		}
		
		//for(Element i:elementList)
		//{
		//	System.out.println(i.mass);
		//}
	
	}
	
	
public static void main(String[] args) {
	Element_sorter ele = new Element_sorter();
	ele.definemass();
}
}
