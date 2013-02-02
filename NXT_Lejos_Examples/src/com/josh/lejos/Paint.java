package com.josh.lejos;

import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;

import com.josh.lejos.util.BaseLejos;

public class Paint extends BaseLejos {

	int horizontal = 0;
	int vertical = 0;
	int stopbuttonloop1 = 0;
	int stopbuttonloop2 = 0;
	TouchSensor up = new TouchSensor(SensorPort.S1);
	TouchSensor down = new TouchSensor(SensorPort.S4);

	public Paint() {

		Button.RIGHT.addButtonListener(new ButtonListener() {

			@Override
			public void buttonReleased(Button b) {

			}

			@Override
			public void buttonPressed(Button b) {
				horizontal = horizontal + 1;

				display();

			}

		});

		Button.LEFT.addButtonListener(new ButtonListener() {

			@Override
			public void buttonReleased(Button b) {

			}

			@Override
			public void buttonPressed(Button b) {
				horizontal = horizontal - 1;

				display();
			}
		});

	}

	public void run() {
		while (true) {

			boolean isPressed = up.isPressed();

			if (isPressed && stopbuttonloop1 == 0) {
				stopbuttonloop1 = stopbuttonloop1 + 1;
				vertical = vertical - 1;

			}

			else if (isPressed == false) {
				stopbuttonloop1 = 0;
				display();

			}
			
			isPressed = down.isPressed();
			
			if (isPressed && stopbuttonloop2 == 0) {
				stopbuttonloop2 = stopbuttonloop2 + 1;
				vertical = vertical + 1;

			}

			else if (isPressed == false) {
				stopbuttonloop2 = 0;
				display();

			}
			

		}
	}
	
	

	private void display() {
		LCD.setPixel(horizontal, vertical, 1);
		LCD.drawString("Coord = " + horizontal + ", " + vertical, 0, 5);

	}

	public static void main(String[] args) {

		Paint paint = new Paint();
		paint.run();

	}
}
