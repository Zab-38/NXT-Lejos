package com.josh.lejos;

import org.scifair.util.BaseLejos;

import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;

public class Pixel_Chase extends BaseLejos {
	int horizontal = 0;
	int vertical = 0;
	int stopbuttonloop1 = 0;
	int stopbuttonloop2 = 0;
	int lasthorizontal = 0;
	int lastvertical = 0;
	TouchSensor up = new TouchSensor(SensorPort.S1);
	TouchSensor down = new TouchSensor(SensorPort.S4);

	public Pixel_Chase() {
		Button.RIGHT.addButtonListener(new ButtonListener() {

			@Override
			public void buttonReleased(Button b) {

			}

			@Override
			public void buttonPressed(Button b) {
				saveLastPosition();
				horizontal = horizontal + 1;

				display();
				clear();
			}
			
		

		});

		Button.LEFT.addButtonListener(new ButtonListener() {

			@Override
			public void buttonReleased(Button b) {

			}

			@Override
			public void buttonPressed(Button b) {
				saveLastPosition();
				horizontal = horizontal - 1;

				display();
				clear();
			}

		});
	}  
	
	

	

	void display() {
		LCD.setPixel(horizontal, vertical, 1);}
		

	private void saveLastPosition() {
		lasthorizontal = horizontal;
		lastvertical = vertical;

	}

	private void clear() {
		LCD.setPixel(lasthorizontal, lastvertical, 0);
	}

	public void run() {
		while (true) {

			boolean isPressed = up.isPressed();

			if (isPressed && stopbuttonloop1 == 0) {
				saveLastPosition();
				vertical = vertical - 1;

				display();
				clear();
				stopbuttonloop1 = stopbuttonloop1 + 1;
				
			}

			else if (isPressed == false) {
				stopbuttonloop1 = 0;
				
            
			}

			//down
			isPressed = down.isPressed();

			
			if (isPressed && stopbuttonloop2 == 0) {
				saveLastPosition();
				vertical = vertical + 1;

				display();
				clear();
				stopbuttonloop2 = stopbuttonloop2 + 1;
			
			}

			else if (isPressed == false) {
				stopbuttonloop2 = 0;
				
            
			}

		}
	}

	public static void main(String[] args) {

		Pixel_Chase pixel = new Pixel_Chase();

		pixel.display();

		pixel.run();

	}

}






