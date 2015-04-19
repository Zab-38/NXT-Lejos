package com.josh.lejos.scifair2015;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.comm.Bluetooth;
import lejos.nxt.comm.NXTConnection;
import lejos.util.EndianTools;

import org.scifair.util.BaseLejos;

import routineFunctions.RTConglamoration;

public class SensorPower extends BaseLejos {
	DataOutputStream dOut;
	DataInputStream dIn;
	NXTConnection conn;
	VoltmeterSensor s = new VoltmeterSensor(SensorPort.S2);

	@Override
	public void run() {

		RTConglamoration rtc = new RTConglamoration();
		LCD.drawString("waiting", 0, 0);
		conn = Bluetooth.waitForConnection(0, NXTConnection.PACKET);

		dOut = conn.openDataOutputStream();
		dIn = conn.openDataInputStream();
		LCD.drawString("connected", 2, 2);
		while (true) {
			int c;
			try {
				if (dIn.available() == 0)
					continue;

				
				
				c = readInt();

				System.out.println(c);
				// value = dIn.readDouble();
				if (c == 1) {
					sendInt(c);
					System.out.println("writing short: "+ c);
//					rtc.MotorActivate();
				} else 
				if (c == 2) {

					sendInt(c);
					System.out.println("writing short: "+ c);
//					rtc.MotorDectivate();
				} else if (c == 3) {
					sendInt(c);
					System.out.println("writing short: "+ c);
				} else if (c == 4) {
//					rtc.PowerOff();
				} else if (c == 5) {
//					rtc.Print();
				} else if (c >= 30) {
					sendInt(c);
					System.out.println("writing >=30 " + c );
				} else if (c == 1000)
				{
					break;
				}
				else {
					continue;
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}

		close();
	}
	
	
	public int readInt()
	{
		byte[] b = new byte[4];
		try {
			dIn.read(b,0,4);
		} catch (IOException e) {
			e.getMessage();
			return -666;
		}
		return EndianTools.decodeIntLE(b, 0);
	}
	public void sendInt(int i)
	{
		byte[] b = new byte[4];
		EndianTools.encodeIntLE(i, b, 0);
		try {
			dOut.write(b);
			dOut.flush();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void close() {

		try {
			dOut.close();
			dIn.close();
			conn.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		SensorPower sp = new SensorPower();
		sp.run();

	}
}
