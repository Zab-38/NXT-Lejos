package com.josh.lejos;
import org.scifair.util.BaseLejos;

import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import lejos.nxt.Motor;

public class Tacotest extends BaseLejos {
	
	int Tachocount = Motor.A.getTachoCount();
	public Tacotest(){
		Button.ENTER.addButtonListener(new ButtonListener() 
		{
			@Override
			public void buttonReleased(Button b) {

			}

			@Override 
			public void buttonPressed(Button b) {
	            	Motor.A.setSpeed(100);
					Motor.A.backward();
					int Tachocount = Motor.A.getTachoCount();
				System.out.println(Tachocount);
					
					
			}
		});

	} 
	public static void main(String[] args) {
		Tacotest taco = new Tacotest();
		taco.run();
	}
	
	
}