package com.josh.lejos;

import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import lejos.nxt.Motor;

import com.josh.lejos.util.BaseLejos;

public class Motortaco extends BaseLejos
{
	int tacocount = 0;
	
	boolean isRunning = false;
	
	
	public Motortaco(){

	{
		
		Button.ENTER.addButtonListener(new ButtonListener() {
			@Override
			public void buttonReleased(Button b) {

			}

			@Override
			public void buttonPressed(Button b) {
                if (tacocount == 10001)
                {
                	Motor.A.setSpeed(720);
    				Motor.A.backward();
                }
				tacocount = tacocount + 1;
				
				Motor.A.setSpeed(720);
				Motor.A.forward();
				isRunning = true;
				
				
			}
		});
		
		Button.LEFT.addButtonListener(new ButtonListener() {
			@Override
			public void buttonReleased(Button b) {

			}

			@Override
			public void buttonPressed(Button b) {

			tacocount = Motor.A.getTachoCount();
				System.out.println(tacocount);
			}
		});}
	}
	
	
	
	@Override
	public void run()
	{
		while(true)
		{
			if(tacocount > 10000 ){
			tacocount = 0;
			}
			
			if (tacocount == 0)
			{
				Motor.A.setSpeed(0);
				Motor.A.backward();
			}
			if(!isRunning){
				
				Motor.A.setSpeed(0);
				Motor.A.forward();
				
				}		
			if(tacocount == 1) {
				Motor.A.setSpeed(720);
				Motor.A.forward();
				
			
			}
			
		}

	}
 

	public static void main(String[] args) {

			Motortaco speed = new Motortaco();
			speed.run();

	}
}
