package seph;

import java.util.ArrayList;

public class Elements {
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
			System.out.println(sort.asList(massvalues));
			
		}
		
		//for(Element i:elementList)
		//{
		//	System.out.println(i.mass);
		//}
	
	}
	
	
public static void main(String[] args) {
	Elements ele = new Elements();
	ele.definemass();
}
}
