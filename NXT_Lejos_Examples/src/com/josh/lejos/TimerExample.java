package com.josh.lejos;

import com.josh.lejos.util.BaseLejos;

import lejos.nxt.LCD;
import lejos.util.Timer;
import lejos.util.TimerListener;

public class TimerExample  extends BaseLejos{

	
	Timer timer = null;
	
    public TimerExample()
    {
		timer = new Timer(500, new TimerListener() {
			
			@Override
			public void timedOut() {
				display();
			}
		});
		
		timer.start();
    }
	private void display()
	{
		System.out.println("hello");
	}
	
	public static void main(String[] args) {
		TimerExample example = new TimerExample();
		example.run();
				
				
	}
}
