package com.josh.lejos;

import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.NXT;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;

public class Killbot {

    UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S4);
    
    public Killbot()
    {
    	sonic.continuous();

    	
		
    	Button.ESCAPE.addButtonListener(new ButtonListener() {
			
			@Override
			public void buttonReleased(Button b) {
 
				System.exit(1);
				
			}
			
			@Override
			public void buttonPressed(Button b) {
				
			}
		});
    	
    	
    	Button.RIGHT.addButtonListener(new ButtonListener(){

			@Override
			public void buttonPressed(Button b) {
				
			}

			@Override
			public void buttonReleased(Button b) {
				
			}});
    	
    	
    	
    	
    	
    	
    	
    	
    	Button.RIGHT.addButtonListener(new ButtonListener(){
            int i = 0;    		
    		int distance =0;
			public void buttonReleased(Button b) {
				
			}
			
			@Override
			public void buttonPressed(Button b) {
			
				   //increase the i
				   
				   
				   //check that i <= 200
				   int i = 100;    
				   if(i <=100)
				   {
					  
					  
					       
					      { Motor.A.setSpeed(i);
				    	  Motor.A.backward();
					    	  Motor.B.setSpeed(i);
					    	  Motor.B.backward();
					    	  Motor.C.setSpeed(i);
					    	  Motor.C.backward();
					      }
				   }

			}
		});
    	
    	
    	
    	
    }

	public void func()
	{ int i = 10;    
		int distance =0;
		
		
	    while (true) {
		      LCD.clear();
		      distance = sonic.getDistance();
//		      LCD.drawString(sonic.getVendorID(), 0, 0);
//		      LCD.drawString(sonic.getProductID(), 0, 1);
//		      LCD.drawString(sonic.getVersion(), 0, 2);

		     
		       if(distance < 0)
		      { Motor.A.setSpeed(00);
	    	  Motor.A.backward();
		    	  Motor.B.setSpeed(00);
		    	  Motor.B.backward();
		    	  Motor.C.setSpeed(00);
		    	  Motor.C.backward();;
		      }
		      else if(distance < 25)
		      { Motor.A.setSpeed(100);
	    	  Motor.A.backward();
		    	  Motor.B.setSpeed(100);
		    	  Motor.B.backward();
		    	  Motor.C.setSpeed(100);
		    	  Motor.C.backward();;
		      }
		       
		       
				
		      

		    }
	    
	    
		
	}
	
	public static void main(String[] args) throws Exception {
	    
	    Killbot killbot = new Killbot();
	    killbot.func();

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
