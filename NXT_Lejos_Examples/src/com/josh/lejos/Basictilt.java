package com.josh.lejos;

import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.addon.AngleSensor;

import com.josh.lejos.util.BaseLejos;

public class Basictilt extends BaseLejos {
	AngleSensor sensor = new AngleSensor(SensorPort.S1);

	public Basictilt() {


	}
	
	
	private void displayData()
	{
		long angle = sensor.getAngle();
		long accAngle = sensor.getAccumulatedAngle();
		long rotationsPerminute = sensor.getRotationsPerMinute();
		long rpm = sensor.getRPM();
		LCD.drawString("ang: " + Long.toString(angle), 0, 0);
		LCD.drawString("accang: " + Long.toString(accAngle), 0, 1);
		LCD.drawString("Rot: " + Long.toString(rotationsPerminute), 0, 2);
		LCD.drawString("RPM: " + Long.toString(rpm), 0, 3);
		if (angle == 883)
		{
			LCD.drawString("You are flat   ", 0, 4);
		}	
		else {
				LCD.drawString("You're not flat", 0, 4);}
		}
	
	
	@Override
	public void run() {
		
		while(true)
		{
			displayData();
		}

	};
	
	public static void main(String[] args) {
		Basictilt tilt = new Basictilt();
		tilt.run();
	}

}	

