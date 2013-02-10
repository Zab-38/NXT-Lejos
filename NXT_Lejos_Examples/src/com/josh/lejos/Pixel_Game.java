package com.josh.lejos;

import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;

import com.josh.lejos.util.BaseLejos;
import com.josh.lejos.util.Sprite;

public class Pixel_Game extends BaseLejos {

	Sprite player = new Sprite();
	Sprite opponent = new Sprite();

	int stopbuttonloop1 = 0;
	int stopbuttonloop2 = 0;
	
	TouchSensor up = new TouchSensor(SensorPort.S1);
	TouchSensor down = new TouchSensor(SensorPort.S4);

	public Pixel_Game() {
		Button.RIGHT.addButtonListener(new ButtonListener() {

			@Override
			public void buttonReleased(Button b) {

			}

			@Override
			public void buttonPressed(Button b) {
				player.moveX(1);
			}

		});

		Button.LEFT.addButtonListener(new ButtonListener() {

			@Override
			public void buttonReleased(Button b) {

			}

			@Override
			public void buttonPressed(Button b) {

				player.moveX(-1);
			}

		});
	}

	public void run() {
		while (true) {

			boolean isPressed = up.isPressed();

			if (isPressed && stopbuttonloop1 == 0) {
				player.moveY(-1);

				stopbuttonloop1 = stopbuttonloop1 + 1;

			}

			else if (isPressed == false) {
				stopbuttonloop1 = 0;

			}

			// down
			isPressed = down.isPressed();

			if (isPressed && stopbuttonloop2 == 0) {
				player.moveY(1);

				stopbuttonloop2 = stopbuttonloop2 + 1;

			}

			else if (isPressed == false) {
				stopbuttonloop2 = 0;

			}

		}
	}

	public static void main(String[] args) {

		Pixel_Game pixel = new Pixel_Game();

		pixel.run();

	}

}
