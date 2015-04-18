package com.josh.lejos.scifair2015;

import lejos.nxt.Motor;
import lejos.nxt.SensorPort;

import org.scifair.util.BaseLejos;

public class Lasertest extends BaseLejos {
int max = 0;
	public void change() {
		for (;;) {

			try {	   SensorPort.S1.setPowerType(0);
				 Motor.A.setSpeed(10);
				   Motor.A.forward();
				   max = max + 1;
				   if (max > 18) {
					   System.exit(1);
				   }
				   Thread.sleep (1000);
				   SensorPort.S1.setPowerType(1);
				   Motor.A.stop();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void startRotation() {
	}

	public static void main(String[] args) {
		Lasertest lt = new Lasertest();

		//lt.startRotation();
		lt.change();
	}
}
