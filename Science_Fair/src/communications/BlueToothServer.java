package communications;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.addon.OpticalDistanceSensor;
import lejos.nxt.comm.Bluetooth;
import lejos.nxt.comm.NXTConnection;
import lejos.nxt.comm.USB;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.RegulatedMotorListener;

import org.scifair.util.BaseLejos;

/**
 * Test of Java streams over USB.
 * Run the PC example, USBSend, to send data.
 * 
 * @author Lawrie Griffiths
 *
 */
public class BlueToothServer extends BaseLejos{
	DataOutputStream dOut;
	DataInputStream dIn;
	NXTConnection conn;
	
	private int speed = 90;
	private int rotA = 359;
	private int rotB = 0;
	
	OpticalDistanceSensor sensor = new OpticalDistanceSensor(SensorPort.S1);

	
	public BlueToothServer() {
		Motor.A.addListener(new RegulatedMotorListener() {
			

			@Override
			public void rotationStopped(RegulatedMotor motor, int tachoCount,
					boolean stalled, long timeStamp) {

				toggleDirection();
			}
			
			@Override
			public void rotationStarted(RegulatedMotor motor, int tachoCount,
					boolean stalled, long timeStamp) {
			}
		});

	}
	
	
	@Override
	public void run() {
		LCD.drawString("waiting", 0, 0);
		conn = Bluetooth.waitForConnection(0,NXTConnection.RAW);
		
		dOut = conn.openDataOutputStream();
		dIn = conn.openDataInputStream();
		LCD.drawString("connected!!", 0, 1);
		
		

		
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
                case 'B':
                	startSensorSweep();
                	break;
                case 'C':
                	stopSensorSweep();
                	break;
                case 'X':  //exit
                	close();
                	System.exit(1);
                	break;
                }
                
            }
            catch (IOException e) 
            {
                break;
            }         
		}

		close();
	}
	
	


	private void startSensorSweep()
	{
		Motor.A.setSpeed(speed);
		Motor.A.rotateTo(rotA, true);
	}
	
	
	private void stopSensorSweep() {

		Motor.A.setSpeed(0);
		
	}
	
	private void toggleDirection()
	{
		speed = (-speed);
		if(speed < 0)
		{
			Motor.A.rotate(rotA, true);
		}
		else
		{
			Motor.A.rotate
			(rotB,true);
		}
		Motor.A.setSpeed(speed);
		
	}

	public void close()
	{
		
		try {
			dOut.close();
			dIn.close();
			conn.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String [] args) throws Exception 
	{

		BlueToothServer usb = new BlueToothServer();
		usb.run();
	}
}

