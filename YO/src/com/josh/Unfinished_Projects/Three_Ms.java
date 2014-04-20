package com.josh.Unfinished_Projects;

import java.util.Arrays;

public class Three_Ms {
	int a[] = {26,5,10,2};
	int total = 0;
	public void calcTotal (){
	
		for(int i = 0; i< a.length ; i++)
		{
 	     total = total + a[i];
		}
		System.out.println();
	}
	
	public void printMean() {
	double mean = (double) total / (double) a.length;
		System.out.println(mean);
	}
	
	
	/**
	 * 
	 * @param index1 index of one item in array
	 * @param index2 index of other item in array
	 */
	public void swap (int index1 , int index2)
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
	
	public void median () {
		Arrays.sort(a);  
		System.out.println("Minimum = " + a[0]);  
		System.out.println("Maximum = " + a[a.length-1]);  

	}
public static void main(String[] args) {
	Three_Ms m = new Three_Ms();
	
//	m.printArray();
	
	m.calcTotal();
	
	
	m.printMean();
	m.median();
	
	
}
}
