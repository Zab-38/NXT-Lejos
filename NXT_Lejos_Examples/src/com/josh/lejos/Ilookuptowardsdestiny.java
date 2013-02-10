package com.josh.lejos;

import com.josh.lejos.util.BaseLejos;

import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.Sound;
import lejos.nxt.addon.AngleSensor;

public class Ilookuptowardsdestiny extends BaseLejos {
	AngleSensor sensor = new AngleSensor(SensorPort.S1);
	
	int motorY = 0;
	private void northlook() {
		
		
		int angle = sensor.getAngle();
		
	}
	
	
	private void displayData() {
		int angle = sensor.getAngle();
		LCD.drawString("ang: " + angle + "    ", 0, 0);
	}
	
	private void setMotorPosition()
	{
		int angle = 0;  //how do you determine how much of an angle to rotate;
		
//		angle = //????
		
		Motor.A.rotate(angle );
		//set motor position here
		
		
	}

	
	
	@Override
	public void run() {

		while (true) {
			displayData();
			setMotorPosition();
		}

	};
	
public static void main(String[] args) {

}
}
