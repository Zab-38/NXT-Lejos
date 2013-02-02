package com.josh.lejos;

import lejos.nxt.ColorSensor;
import lejos.nxt.ColorSensor.Color;
import lejos.nxt.LCD;
import lejos.nxt.SensorConstants;
import lejos.nxt.SensorPort;

public class EpilepsyBot {
	

	
	
	public static void main(String[] args) {
		try {
			EpilepsyBot lazbot = new EpilepsyBot();

			ColorSensor cs = new ColorSensor(SensorPort.S1);
			boolean done = false;
		
				for(int i = 0; i < 100 && !done; i++)
				{
			
			
					cs.setFloodlight(Color.RED);
					
					Thread.sleep(50);

					LCD.clearDisplay();
					LCD.drawString("" + lazbot.getRedComponent(), 0,0);
					cs.setFloodlight(Color.GREEN);

					Thread.sleep(50);

					LCD.clearDisplay();
					LCD.drawString("" + lazbot.getGreenComponent(), 0,0);
					cs.setFloodlight(Color.BLUE);

					Thread.sleep(50);
		    
					LCD.clearDisplay();
					LCD.drawString("" + lazbot.getBlueComponent(), 0,0);
				}
			} catch (Exception e) {}
 
	}

	private String getRedComponent() {
		// TODO Auto-generated method stub
		return null;
	}

	private String getBlueComponent() {
		// TODO Auto-generated method stub
		return null;
	}

	private String getGreenComponent() {
		// TODO Auto-generated method stub
		return null;
	}

	private static void sleep(int i) {
		// TODO Auto-generated method stub
		
	}
}