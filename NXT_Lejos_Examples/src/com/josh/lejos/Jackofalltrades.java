package com.josh.lejos;

import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;

public class Jackofalltrades {
	int i = 10;
	int counter = 0;

	UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S4);

	public Jackofalltrades() {
		Button.ESCAPE.addButtonListener(new ButtonListener() {

			@Override
			public void buttonReleased(Button b) {
				counter = counter + 1;

				if (counter == 1) {
					System.out.println("Are you sure you want to exit?");
				}

				if (counter == 2) {
					System.exit(1);
				}

			}

			@Override
			public void buttonPressed(Button b) {
			}
		});

		Button.RIGHT.addButtonListener(new ButtonListener() {
			public void buttonReleased(Button b) {
			}

			@Override
			public void buttonPressed(Button b) {
				// increase the i
				i = i + 10;
				move(i);
			}
		});
	}

	public void move(int speed) {
		if (i <= 60000000) {
			{
				Motor.A.setSpeed(720);
				Motor.A.backward();
				Motor.B.setSpeed(i);
				Motor.B.backward();
				Motor.C.setSpeed(i);
				Motor.C.backward();
			}
		}

	}

	public void startLoop() {
		move(i);

		while (true) {

			int distance = sonic.getDistance();
			if (distance < 25) {
				Motor.A.setSpeed(720);
				Motor.A.forward();
			} else {
				Motor.A.setSpeed(720);
				Motor.A.backward();
			}

			// this will loop until

		}

	}

	{

		Button.LEFT.addButtonListener(new ButtonListener() {
			public void buttonReleased(Button b) {// add one to i
			}

			@Override
			public void buttonPressed(Button b) {
				// increase the i
				i = i - 10;
				move(i);
			}
		});
	}

	public void move1(int speed) {
		if (i <= 60000000) {
			{
				Motor.A.setSpeed(720);
				Motor.A.backward();
				Motor.B.setSpeed(i);
				Motor.B.backward();
				Motor.C.setSpeed(i);
				Motor.C.backward();
			}
		}

	}

	public void startLoop1() {
		move(i);

		while (true) {

			int distance = sonic.getDistance();
			if (distance < 25) {
				Motor.A.setSpeed(720);
				Motor.A.forward();
			} else {
				Motor.A.setSpeed(720);
				Motor.A.backward();
			}

			// this will loop until

		}

	}

	{

		sonic.getDistance();

		Button.ENTER.addButtonListener(new ButtonListener() {

			@Override
			public void buttonPressed(Button b) {

				if (counter > 0) {
					counter = counter - 1;
				}

			}

			@Override
			public void buttonReleased(Button b) {
				System.out.println(i);

			}

		});
		
	}

	public static void main(String[] args) {

		Jackofalltrades doom = new Jackofalltrades();
		doom.startLoop();

	}

}
