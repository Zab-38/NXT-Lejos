package org.lejos.pcsample.usbsend;

import lejos.nxt.LCD;
import lejos.pc.comm.NXTComm;
import lejos.pc.comm.NXTCommException;
import lejos.pc.comm.NXTCommFactory;
import lejos.pc.comm.NXTInfo;

public class Sendata{
	NXTComm nxtComm;
	NXTInfo[] device;
	public void waiting() {

		try {
			nxtComm = NXTCommFactory.createNXTComm(NXTCommFactory.BLUETOOTH);
			device = nxtComm.search(null);
			nxtComm.open(device[0]);
			
		} catch (NXTCommException e) {
			e.printStackTrace();
		}
		LCD.drawString("Device found.", 0, 0);
	}

	public void stream() {
		Object ois = openDataInputStream();
		Object oos = openDataOutputStream();
		for (int i = 0; i < 100; i++)
			try {
				
			} finally {
				System.exit(1);
			}
	}

	private Object openDataOutputStream() {
		System.out.println("I am getting the stream");
		return nxtComm.getOutputStream();
		
	}

	private Object openDataInputStream() {
		return nxtComm.getInputStream();
	}

	public static void main(String[] args) {
		Sendata data = new Sendata();
		data.waiting();
		data.stream();
	}
}
