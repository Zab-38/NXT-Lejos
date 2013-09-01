package org.lejos.sample.segwaypilotdemo;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.scifair.util.BaseLejos;

import lejos.nxt.LCD;
import lejos.nxt.MotorPort;
import lejos.nxt.NXTMotor;
import lejos.nxt.SensorPort;
import lejos.nxt.addon.GyroSensor;
import lejos.nxt.comm.Bluetooth;
import lejos.nxt.comm.NXTConnection;
import lejos.robotics.navigation.Move;
import lejos.robotics.navigation.MoveListener;
import lejos.robotics.navigation.MoveProvider;
import lejos.robotics.navigation.SegowayPilot;

/**
 * <p>This class demonstrates the movement capabilities of the SegowayPilot by tracing three squares on the floor.
 * It also implements a MoveListener to demonstrate the move reporting abilities of all XxxPilot classes. 
 * As of version 0.9 the SegowayPilot.rotate() method is very poor, but we will improve this for version 1.0.</p>
 * 
 * <p>The Segoway and SegowayPilot classes require a HiTechnic gyro sensor. Mount the sensor on the left side of the 
 * robot. See <a href="http://laurensvalk.com/nxt-2_0-only/anyway">this model</a> for the proper orientation.</p>
 * 
 * @author BB
 *
 */
public class SegwaySciFair extends BaseLejos implements MoveListener{
	DataOutputStream dOut;
	DataInputStream dIn;
	NXTConnection conn;

	NXTMotor left = new NXTMotor(MotorPort.B);
	NXTMotor right = new NXTMotor(MotorPort.C);
	GyroSensor g = new GyroSensor(SensorPort.S1);
		
	SegowayPilot pilot;
	
	@Override
	public void run() {
		
		LCD.drawString("waiting", 0, 0);
		conn = Bluetooth.waitForConnection(0,NXTConnection.RAW);
		
		dOut = conn.openDataOutputStream();
		dIn = conn.openDataInputStream();
		LCD.drawString("connected!!", 0, 1);
		
		// The track width is for the AnyWay. Make sure to use the appropriate wheel size.
		pilot = new SegowayPilot(left, right, g, SegowayPilot.WHEEL_SIZE_NXT2, 10.45);
		// If the robot is tippy, try slowing down the speed:
		pilot.setTravelSpeed(80);
		
//		MoveListener listy = new SegwayPilotDemo();
		MoveListener listy = this;
		pilot.addMoveListener(listy);
				
		while (true) 
		{
            byte b;
            double value;
            try
            {
            	if(dIn.available()== 0)continue;
            	
                b = dIn.readByte();
                
				switch(b)
                {
                case 'L':
                	// Left turn
                	left(90);
                	break;
                case 'F':
                	//Forward
                	forward(50);
                	break;
                case 'R': 
                	// Turn Right
                	right(90);
                	break;
                case 'O':
                	// Moves Backwards
                	backward(50);
                	break;
                case 'D':
                	// Does Nothing
                	stop();
                	break;
                }
            }
            catch (IOException e) 
            {
                break;
            }         
		}
	
	}
	

	private void stop() {
		//does nothing
		
	}
	private void backward(int i) {
		//moves backward
		System.out.println("Backward!!");
		pilot.travel(-25);
	}
	
	private void right(int i) {
		//turns right on the spot
		pilot.rotate(45);
		System.out.println("Right!!");
	}

	private void forward(int i) {
		//moves directly forward
		System.out.println("Forward!!");
		pilot.travel(25);
	}

	private void left(double angle) {	
		//turns left
		System.out.println("Left!!");
		pilot.rotate(-45);	
	} 
	boolean forward; 
	
	
	


	public void moveStarted(Move move, MoveProvider mp) {
		System.out.println("MOVE STARTED");
																																						}

	public void moveStopped(Move move, MoveProvider mp) {
		System.out.println("DISTANCE " + move.getDistanceTraveled());
		System.out.println("ANGLE " + move.getAngleTurned());
	}
	
	public static void main(String [] args) throws InterruptedException {
		SegwaySciFair demo = new SegwaySciFair();
		demo.run();
		//hey!
		
	}
	
}
