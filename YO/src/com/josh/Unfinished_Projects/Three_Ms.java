package com.josh.Unfinished_Projects;

public class Three_Ms {
	int a[] = {26,5,10,2};
	
	public void mean (){
		double total = 0;
		for(int i = 0; i< a.length ; i++)
		{
 		total = total + a[i];	
		}
	}
	
	
	/**
	 * 
	 * @param index1 index of one item in array
	 * @param index2 index of other item in array
	 */
	public void swap (int index1, int index2)
	{
		int temp = a[index1];
	   a[index1] = a[index2];
	   a[index2] = temp;
		
	}
	
	public void printArray()
	{
		for(int i = 0;i < a.length; i++)
		{
			System.out.print(a[i] + " ");
		}
		System.out.println();
		System.out.println("**************");
	}
public static void main(String[] args) {
	Three_Ms m = new Three_Ms();
	
	m.printArray();
	m.swap(0, 1);
	
	m.printArray();
	
	
}
}
