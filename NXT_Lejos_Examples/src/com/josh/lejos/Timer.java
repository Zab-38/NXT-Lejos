package com.josh.lejos;
import org.scifair.util.BaseLejos;
import lejos.nxt.Button;
import lejos.nxt.ButtonListener;

public class Timer extends BaseLejos{
	int increment = 0;
	int duration = 0;
	int change = 0;

	public void start1() {
		if(change==0)
		begin();
		increment();
	}
	
   	public void start2() {
   		if(change==1)	
	settimer();
	}

	public void begin() {
		System.out.println("How long will your increments be?");
		System.out.println(increment + " = seconds");
	}

	public void increment() {

		Button.RIGHT.addButtonListener(new ButtonListener() {

			@Override
			public void buttonReleased(Button b) {

			}

			@Override
			public void buttonPressed(Button b) {

				increment = increment + 10000;

			}
		});
		Button.LEFT.addButtonListener(new ButtonListener() {

			@Override
			public void buttonReleased(Button b) {

			}

			@Override
			public void buttonPressed(Button b) {

				increment = increment - 10000;

			}
		});
		Button.ENTER.addButtonListener(new ButtonListener() {

			@Override
			public void buttonReleased(Button b) {

			}

			@Override
			public void buttonPressed(Button b) {

			change = change + 1;
			

			}
		});
	}
	public void settimer() {
		Button.RIGHT.addButtonListener(new ButtonListener() {

			@Override
			public void buttonReleased(Button b) {

			}

			@Override
			public void buttonPressed(Button b) {

				duration = duration + increment;

			}
		});
		Button.LEFT.addButtonListener(new ButtonListener() {
		

			@Override
			public void buttonReleased(Button b) {

			}

			@Override
			public void buttonPressed(Button b) {

				duration = duration - increment;

			}
		});
	}

	public void timer() {

		Button.RIGHT.addButtonListener(new ButtonListener() {

			@Override
			public void buttonReleased(Button b) {

			}

			@Override
			public void buttonPressed(Button b) {

				increment = increment + 30000;

			}
		});
		Button.LEFT.addButtonListener(new ButtonListener() {
		

			@Override
			public void buttonReleased(Button b) {

			}

			@Override
			public void buttonPressed(Button b) {

				increment = increment - 30000;

			}
		});
		
	}

	public static void main(String[] args) {
    Timer time = new Timer();
    time.run();
	}
}
