package com.josh.lejos.scifair2015;

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
		conn = Bluetooth.waitForConnection(0, NXTConnection.RAW);

		dOut = conn.openDataOutputStream();
		dIn = conn.openDataInputStream();
		LCD.drawString("connected", 2, 2);
		while (true) {
			char b;
			double value = 0;
			try {
				if (dIn.available() == 0)
					continue;

				b = dIn.readChar();

				LCD.clearDisplay();
				System.out.println(b);
				// value = dIn.readDouble();
				if (b == '0') {
					rtc.MotorActivate();
				} else if (b == '1') {
					rtc.MotorDectivate();
				} else if (b == '2') {
					rtc.PowerOn();
				} else if (b == '3') {
					rtc.PowerOff();
				} else if (b == '4') {
					rtc.Print();
				} else if (b == '5') {
					rtc.Exit();
				} else if (b == 'x')
					break;
				else {
					continue;
				}
			} catch (IOException e) {
				break;
			}
		}

		close();
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
