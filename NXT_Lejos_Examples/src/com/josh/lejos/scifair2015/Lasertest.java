package com.josh.lejos.scifair2015;

import lejos.nxt.Motor;
import org.scifair.util.BaseLejos;

public class Lasertest extends BaseLejos {
	int rotateBool = 0;

	public void change() {
		for (;;) {

			try {
				rotateBool = 1;
				Thread.sleep(500);
				System.out.println("dur");
				rotateBool = 0;
				Thread.sleep(500);
				System.out.println("bur");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void startRotation() {
		for (;;) {
			if (rotateBool == 1) {
				Motor.A.setSpeed(40);
				Motor.A.backward();
			}

		}
	}

	public static void main(String[] args) {
		Lasertest lt = new Lasertest();

		lt.startRotation();
		lt.change();
	}
}
