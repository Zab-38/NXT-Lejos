package com.josh.lejos;
import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.Button;
import lejos.nxt.ButtonListener;

public class Wordprocessor {
	int letter = 0;
	int cursor = 2;
	int vertical = 0;
	int button = 0;
	int buttonOn = 0;
	final String alphabet = " _abcdefghijklmnopqrstuvwxyz";
	
	int LAST_LETTER = alphabet.length()-1;
	int FIRST_LETTER = 1;
	int BLANK = 0;
	
    TouchSensor touch = new TouchSensor(SensorPort.S1);
	
	public Wordprocessor()
	{
		
		Button.RIGHT.addButtonListener(new ButtonListener() {

			@Override
			public void buttonReleased(Button b) {

			}

			@Override
			public void buttonPressed(Button b) {
				{
					if (letter == LAST_LETTER) {
						letter = FIRST_LETTER;
					}else
					{
						letter = letter + 1;
					}	
					showLetter();
					
				}
			}

		});
		Button.LEFT.addButtonListener(new ButtonListener() {

			@Override
			public void buttonReleased(Button b) {

			}

			@Override
			public void buttonPressed(Button b) {
				{
					
					if(letter==FIRST_LETTER)
						letter = LAST_LETTER;
					else
					{
						letter = letter - 1;
					}
					showLetter();
					
					
				
				}
			}
		});
		Button.ENTER.addButtonListener(new ButtonListener() {

			@Override
			public void buttonReleased(Button b) {

			}

			@Override
			public void buttonPressed(Button b) {
				cursor = cursor + 1;
				if(cursor == 16) 
				{
				vertical = vertical + 1;
				cursor = 0;
				}
				showLetter();
				
			}
		});
		
		Button.ESCAPE.addButtonListener(new ButtonListener() {

			@Override
			public void buttonReleased(Button b) {

			}

			@Override
			public void buttonPressed(Button b) {
			
				System.exit(1);

			}
		});
		
		
		
		showLetter();

	}

	private void showLetter() {
		
		String charac = ""+alphabet.charAt(letter);
		LCD.drawString(charac, cursor, vertical);
		
		LCD.drawString( Integer.toString(buttonOn), 0, 3);
		
	}
	
	
	public void loop()
	{
		while(true)
		{
			
			boolean isPressed = touch.isPressed();
			
			if( isPressed && buttonOn==0)
			{
				
				

				
				letter = BLANK;
				buttonOn = buttonOn + 1;
				
				showLetter();

				cursor = cursor - 1;
				
			}
			
			else
			if(isPressed==false) 	
			{
			 buttonOn = 0;
			 showLetter();
			 
			}
			
			
		}
	}
	
	


	public static void main(String[] args) {
		Wordprocessor blah= new Wordprocessor();
		blah.loop();
	
		
    }
}
