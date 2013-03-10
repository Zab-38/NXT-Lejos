package com.josh.lejos;

import javax.microedition.lcdui.Screen;

import org.scifair.util.BaseLejos;

import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.addon.OpticalDistanceSensor;
import lejos.util.Timer;
import lejos.util.TimerListener;

public class TestIRSensor extends BaseLejos {

	Timer timer =null;
	OpticalDistanceSensor sensor = new OpticalDistanceSensor(SensorPort.S1);
	int distance = 0;
	int x = 0;
	int time = 0;
	int move = x;

	public int getdistance() {

		return sensor.getDistance();

	}

	public void determineRange() {

		distance = getdistance();

	}
	
	public void sendinfo() {
	try {
		Thread.sleep(100);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	}

	@Override
	public void run() {
		createAndStartTimer();
		
		
		while (true) {
			if (time > 0) {
				timer.stop();
				
				Motor.A.setSpeed(0);
				
			}
			else
			{   

				motor();
				determineRange();
				wave();
				sendinfo();
			}
		}
	}



	

	public void motor() {
		Motor.A.setSpeed(36);
		Motor.A.forward();
	}

	public void createAndStartTimer() {
		timer = new Timer(10000, new TimerListener() {

			@Override
			public void timedOut() {
				time = time + 1;
			

			}
		});
		timer.start();
	}

	public void wave() {
      
		int y = 64 - distance / 15;
		// LCD.drawString("x",distance/150, vertical);
		LCD.setPixel(x, y, 1);

		x = x + 1;

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args)

	{
		TestIRSensor sensor = new TestIRSensor();
		sensor.run();

	}
}
