package com.josh.lejos.scifair2015;

import org.scifair.util.BaseLejos;

import lejos.nxt.Motor;
import lejos.nxt.SensorPort;

public class SensorPower extends BaseLejos {
	
	VoltmeterSensor s = new VoltmeterSensor(SensorPort.S2);

	public void run() {
		for (;;) {
			try {
				SensorPort.S1.setPowerType(1);
				System.out.println(s.readVoltage());
				Motor.A.setSpeed(0);
		    	Motor.A.backward();
				Thread.sleep(250);
				SensorPort.S1.setPowerType(0);
				Motor.A.setSpeed(9);
		    	Motor.A.backward();
				Thread.sleep(250);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	public static void main(String[] args) {

		SensorPower sp = new SensorPower();
		sp.run();

	}
}
