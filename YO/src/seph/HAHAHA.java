package seph;

import java.util.ArrayList;

public class HAHAHA {
	int first = 0;
	int second = 1;
	int index = 0;
	
	/**
	 * 
	 *  JOSH 
	 *  what are you using this array for
	 * */
	ArrayList<Integer> arrlist = new ArrayList<Integer>(5);

	private void print() {
		index = index + 1;
		System.out.println(index + ":" + first);
	}

	private void sum() {
		int sum = first + second;
		first = second;
		second = sum;
	}

	public static void main(String[] args) {
		HAHAHA HA = new HAHAHA();
		while (HA.first < 1000) {
			HA.print();
			HA.sum();
		}
	}
}
