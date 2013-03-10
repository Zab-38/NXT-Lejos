package communications;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;

import org.scifair.util.BaseLejos;

import lejos.nxt.LCD;
import lejos.nxt.Sound;
import lejos.nxt.comm.USB;
import lejos.nxt.comm.USBConnection;

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
	USBConnection conn;
	@Override
	public void run() {
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
                b = dIn.readChar();
                value = dIn.readDouble();
                if(b=='x')break;
                Sound.beep();
            }
            catch (IOException e) 
            {
                break;
            }         
			try {
				dOut.writeChar('a');
				dOut.writeDouble(-value);
				dOut.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
	        LCD.drawInt(b,8,0,1);
		}

		close();
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

