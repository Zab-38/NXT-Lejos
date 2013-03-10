package org.scifair.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import lejos.pc.comm.NXTCommLogListener;
import lejos.pc.comm.NXTConnector;

public class NXTCommunications {

	public class Msg {
		public char msg;
		public double value;
	}

	NXTConnector conn = new NXTConnector();
	private DataInputStream inDat;
	private DataOutputStream outDat;
	private static NXTCommunications nxtComm;

	private NXTCommunications() {
		conn.addLogListener(new NXTCommLogListener(){

			public void logEvent(String message) {
				System.out.println("USBSend Log.listener: "+message);
				
			}

			public void logEvent(Throwable throwable) {
				System.out.println("USBSend Log.listener - stack trace: ");
				 throwable.printStackTrace();
				
			}
			
		} 
		);
		
		if (!conn.connectTo("usb://")){
			System.err.println("No NXT found using USB");
			
			if(!conn.connectTo("btspp://"))
					{
				System.err.println("No NXT found using BT");
				System.exit(1);
					}
		}
	}

	public static NXTCommunications singleton() {
		if (nxtComm == null) {
			nxtComm = new NXTCommunications();
		}
		return nxtComm;
	}

	public void open() {
		inDat = new DataInputStream(conn.getInputStream());
		outDat = new DataOutputStream(conn.getOutputStream());
	}

	public void close() {
		try {
			inDat.close();
			outDat.close();
			conn.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendMsg(char ch, double value) {
		try {
			outDat.writeChar(ch);
			outDat.writeDouble(value);
			outDat.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Msg rcvMsg() {

		try {
			char ch = inDat.readChar();
			double dbl = inDat.readDouble();

			Msg msg = new Msg();
			msg.msg = ch;
			msg.value = dbl;
			return msg;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

}
