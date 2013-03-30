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
public class LejosServer extends BaseLejos{
	DataOutputStream dOut;
	DataInputStream dIn;
	NXTConnection conn;
	private int speed = 90;
	private int rotA = 340;
	private int rotB = 0;
	
	OpticalDistanceSensor sensor = new OpticalDistanceSensor(SensorPort.S1);
	
	
	@Override
	public void run() {
		Motor.A.setSpeed(speed);
		Motor.A.rotateTo(rotA, true);
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
		
		LCD.drawString("waiting", 0, 0);
		conn = USB.waitForConnection();
		
		dOut = conn.openDataOutputStream();
		dIn = conn.openDataInputStream();
		while (true) 
		{
            char b;
            double value;
            try
            {
            	if(dIn.available()== 0)continue;
            	
                b = dIn.readChar();
                value = dIn.readDouble();
                if(b=='d')
                {
                	sendDistance();
                }else
                if(b=='x')break;
                else
                {
                	continue;
                }
            }
            catch (IOException e) 
            {
                break;
            }         
		}

		close();
	}
	
	private void sendDistance() {

		double distance = sensor.getDistance();
		int angle = Motor.A.getPosition();
		try {
			dOut.writeChar('a');
			dOut.writeDouble(distance);
			dOut.writeInt(angle);
			dOut.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private void toggleDirection()
	{
		speed = (-speed);
		if(speed < 0)
		{
			Motor.A.rotateTo(rotA, true);
		}
		else
		{
			Motor.A.rotateTo(rotB,true);
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

		LejosServer usb = new LejosServer();
		usb.run();
	}
}

