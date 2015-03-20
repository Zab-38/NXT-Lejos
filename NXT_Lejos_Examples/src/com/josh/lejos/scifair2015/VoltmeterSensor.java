package com.josh.lejos.scifair2015;

import java.io.PrintStream;

import lejos.nxt.I2CPort;
import lejos.nxt.I2CSensor;
import lejos.nxt.SensorPort;

public class VoltmeterSensor extends I2CSensor {

	final byte CALIBRATED_VOLTAGE_REGISTER = 0x43;
	final static byte VoltMeterAddr = 0x26;
    final byte COMMAND_REGISTER = 0x41;
	
	byte[] buf = new byte[2];
	public VoltmeterSensor(I2CPort port) {
		super(port, (int)VoltMeterAddr, I2CPort.STANDARD_MODE, TYPE_LOWSPEED);
		initReference();
	}



	public int initReference()
	{
		return sendData(COMMAND_REGISTER, (byte)'d');
	}
	
	
	public int readVoltage()
	{
	
		int ret = getData(0x43,buf,2);

		System.out.println("return: " + ret);
		return buf[0] + buf[1]*256;

	}
	
	

}
