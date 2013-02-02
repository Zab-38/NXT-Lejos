package com.josh.lejos;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;

public class Shooterbot {

    UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S4);
    
    public Shooterbot()
    {
    	sonic.continuous();
    }

	public void func()
	{
		int distance =0;
		
	    while (!Button.ESCAPE.isDown()) {
		      LCD.clear();
		      distance = sonic.getDistance();
//		      LCD.drawString(sonic.getVendorID(), 0, 0);
//		      LCD.drawString(sonic.getProductID(), 0, 1);
//		      LCD.drawString(sonic.getVersion(), 0, 2);

		      if(distance < 5)
		      { Motor.A.setSpeed(200);
	    	  Motor.A.backward();
		    	  Motor.B.setSpeed(200);
		    	  Motor.B.backward();
		    	  Motor.C.setSpeed(200);
		    	  Motor.C.backward();;
		      }
		      else
		      { Motor.A.setSpeed(00);
	    	  Motor.A.backward();
		    	  Motor.B.setSpeed(00);
		    	  Motor.B.backward();
		    	  Motor.C.setSpeed(00);
		    	  Motor.C.backward();;
		      }
				
		      

		    }
	    
	    
		
	}
	
	public static void main(String[] args) throws Exception {
	    
	    Shooterbot mah = new Shooterbot();
	    mah.func();

	    //move backwards
//	    boolean truefalse = true;
//	    
//	    if (truefalse== true);
//	    {
//	    	Motor.B.setSpeed(200);
//			Motor.B.backward();
//			Motor.C.setSpeed(200);
//			Motor.C.backward();
//	    }
	    
	    
	    
	    
	    
	    
	  }
	}
