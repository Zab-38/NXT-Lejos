package com.josh.lejos.scifair2015;

import org.scifair.util.BaseLejos;

import lejos.nxt.SensorPort;

public class SensorPower extends BaseLejos{
	
	public void run()
	{
		for(;;)
		{
			try {
				SensorPort.S1.setPowerType(2);
				Thread.sleep(50);
				
				SensorPort.S1.setPowerType(0);
				Thread.sleep(50);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
public static void main(String[] args) {
	

    SensorPower sp = new SensorPower();
    sp.run();
    
}
}
