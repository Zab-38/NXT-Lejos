package com.josh.lejos.scifair2015;

import lejos.nxt.SensorPort;

import org.scifair.util.BaseLejos;

public class VoltApp extends BaseLejos {

	VoltmeterSensor s = new VoltmeterSensor(SensorPort.S1);
	

	public void run() {
	
		for (;;) {

			System.out.println(s.readVoltage());
		}
	}
	
	
	public static void main(String[] args) {
		VoltApp va = new VoltApp();
		va.run();
		
	}

}
