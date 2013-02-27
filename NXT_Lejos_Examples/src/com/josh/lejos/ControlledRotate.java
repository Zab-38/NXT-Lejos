package com.josh.lejos;

import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import lejos.nxt.Motor;

import com.josh.lejos.util.BaseLejos;
 
public class ControlledRotate extends BaseLejos {


	public ControlledRotate()
	{
		
		Button.ENTER.addButtonListener(new ButtonListener() {
			
			@Override
			public void buttonReleased(Button b) {
			   Motor.A.backward();
			   Motor.A.setSpeed(750);
			}
			
			@Override
			public void buttonPressed(Button b) {

				Motor.A.forward();
				Motor.A.setSpeed(36);
//				Motor.A.rotateTo(360);
				

				
				
			}
		});
	}
	
	public static void main(String[] args) {
		ControlledRotate smr = new ControlledRotate();
		smr.run();
	}
}
