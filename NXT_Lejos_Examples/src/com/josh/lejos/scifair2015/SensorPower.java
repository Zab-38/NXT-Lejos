package com.josh.lejos.scifair2015;

import org.scifair.util.BaseLejos;

import lejos.nxt.SensorPort;

public class SensorPower extends BaseLejos {

	public void run() {
		for (;;) {
			try {
				SensorPort.S1.setPowerType(1);
				Thread.sleep(2000);

				SensorPort.S1.setPowerType(0);
				Thread.sleep(500);

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
