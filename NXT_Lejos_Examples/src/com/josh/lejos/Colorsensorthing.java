package com.josh.lejos;

import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import lejos.nxt.ColorSensor;
import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.robotics.Color;

import com.josh.lejos.util.BaseLejos;

public class Colorsensorthing extends BaseLejos {
	
	int colorSelection = 0 ;
	int[] colorArray = {Color.BLUE,Color.RED,Color.GREEN}; 
	private int MAX = colorArray.length -1;
	ColorSensor cs = new ColorSensor(SensorPort.S2);

	public Colorsensorthing() {
		
		Button.ENTER.addButtonListener(new ButtonListener() {
			

			@Override
			public void buttonReleased(Button b) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void buttonPressed(Button b) {
			
				if(colorSelection == MAX)
				{
					colorSelection = 0;
				}
				else colorSelection = colorSelection + 1;
				
				showLight(colorArray[colorSelection]);
				
			}
		});
	}
	
	public void run()
	{
		while(true)
		{
	       lejos.nxt.ColorSensor.Color c = cs.getColor();
	       LCD.drawString("RGB:" + c.getRed() + ", " + c.getGreen()+ ", "+ c.getBlue() + "      " , 0, 6);
		}
	}
	
	public void showLight(int color)
	{
		cs.setFloodlight(color);
		cs.setHigh(255);
		
		LCD.drawString(Integer.toString(color), 0, 5);
	}

	public static void main(String[] args) {

		Colorsensorthing floodlight = new Colorsensorthing();
		floodlight.showLight(Color.CYAN);
		floodlight.run();
	}
}
