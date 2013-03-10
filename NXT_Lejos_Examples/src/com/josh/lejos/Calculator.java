package com.josh.lejos;

import org.scifair.util.BaseLejos;

import lejos.nxt.Button;
import lejos.nxt.ButtonListener;

public class Calculator extends BaseLejos{
	int first = 0;
	int second = 0;
	int result;
	int operations = 0;
	int state = 0;

	public Calculator() {
		
		super();
		
		Button.RIGHT.addButtonListener(new ButtonListener() {

			@Override
			public void buttonReleased(Button b) {

			}

			@Override
			public void buttonPressed(Button b) {
				
				if(state==0)
				{
					first = first + 1;
					
				}
				System.out.println(first);
				if(state==1)
				{
				operations = operations + 1;
				}
				System.out.println(operations);
				if(state==2)
				{
					second = second + 1;
				}
				System.out.println(second);


			}
		});
		Button.LEFT.addButtonListener(new ButtonListener() {

			@Override
			public void buttonReleased(Button b) {

			}

			@Override
			public void buttonPressed(Button b)
			
			{if(state==0)
			{
				first = first - 1;
				
			}
			System.out.println(first);
			if(state==1)
			{
			operations = operations - 1;
			}
			System.out.println(operations);
			if(state==2)
			{
				second = second - 1;
			}
			System.out.println(second);
			
			
			
		}});
		Button.ENTER.addButtonListener(new ButtonListener() {

			@Override
			public void buttonReleased(Button b) {

			}

			@Override
			public void buttonPressed(Button b) {
				
				state = state + 1;
				if(state==3)
				if(operations==1) 
				{
					System.out.println(first + second);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}//hahhahahah
				if(state==3)
					if(operations==2) 
					{
						System.out.println(first - second);
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
					}//hahhahahah
				if(state==3)
					if(operations==3) 
					{
						System.out.println(first * second);
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
					}//hahhahahah
				if(state==3)
					if(operations==4) 
					{
						System.out.println(first / second);
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
					}//hahhahahah
				
			}
		});
		
		
//		Button.waitForAnyPress();
	}
	

	
	
	
	public static void main(String[] args) {
		Calculator e = new Calculator();
		e.run();
		
	}
}
