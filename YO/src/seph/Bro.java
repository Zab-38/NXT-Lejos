package seph;

import java.util.ArrayList;

public class Bro {
	int first = 0;
	int second = 1;
	int array = 0;

	ArrayList<Integer> arrlist = new ArrayList<Integer>(1);

	private void print() {
		arrlist.add(first);

		int sum = 0;
		int index = 0;
		for(Integer i : arrlist)
		{
			sum = sum + arrlist.get(index++);
		}
		System.out.println(index + ":" + first);

	}

	private void count() {
		int sum = first + second;
		first = second;
		second = sum;

	}

	public static void main(String[] args) {
		Bro bo = new Bro();

		while (bo.first < 1000) {
			bo.print();
			bo.count();
		}
	}
}
