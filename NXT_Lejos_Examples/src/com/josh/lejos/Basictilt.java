package com.josh.lejos;

import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.Sound;
import lejos.nxt.addon.AngleSensor;
import com.josh.lejos.util.BaseLejos;
public class Basictilt extends BaseLejos {
	AngleSensor sensor = new AngleSensor(SensorPort.S1);

	public Basictilt() {

	}

	private void displayData() {
		int angle = sensor.getAngle();
	//	long accAngle = sensor.getAccumulatedAngle();
	//	long rotationsPerminute = sensor.getRotationsPerMinute();
	//	long rpm = sensor.getRPM();
		LCD.drawString("ang: " + angle + "    ", 0, 0);
	//	LCD.drawString("accang: " + Long.toString(accAngle), 0, 1);
	//	LCD.drawString("Rot: " + Long.toString(rotationsPerminute), 0, 2);
	//	LCD.drawString("RPM: " + Long.toString(rpm), 0, 3);

		int notekey = angle *5;
		
		if (angle > 90) {
			LCD.drawString("You are flat     ", 0,4 );
		}
		else if
		(angle > 0) {
			LCD.drawString("You are not flat", 0,4 );
		}
		if(notekey > 100)
		Sound.playTone(notekey, 500);

	}

	@Override
	public void run() {

		while (true) {
			displayData();
		}

	};

	public static void main(String[] args) {
		Basictilt tilt = new Basictilt();
		tilt.run();
	}

}
