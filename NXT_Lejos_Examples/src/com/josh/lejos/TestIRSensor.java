package com.josh.lejos;

import javax.microedition.lcdui.Screen;

import com.josh.lejos.util.BaseLejos;

import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.addon.OpticalDistanceSensor;

public class TestIRSensor extends BaseLejos {

	OpticalDistanceSensor sensor = new OpticalDistanceSensor(SensorPort.S1);
	int distance = 0;
	int x = 0;

	public int getdistance() {

		return sensor.getDistance();

	}

	public void display() {

		distance = getdistance();

	}

	@Override
	public void run() {
		while (true) {
			clearscreen();
			display();
			wave();
		}
	}

	public void clearscreen() {
		if (x > 100) {
			LCD.clear();
			x = 0;
		}
		;

	}

	public void wave() {

		int y = 64 - distance / 15;
		// LCD.drawString("x",distance/150, vertical);
		LCD.setPixel(x, y, 1);
		LCD.setPixel(x + 1, y, 1);
		LCD.setPixel(x, y + 1, 1);
		LCD.setPixel(x + 1, y + 1, 1);
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
