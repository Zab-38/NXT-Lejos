package com.josh.lejos;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import lejos.nxt.comm.BTConnection;
import lejos.nxt.comm.Bluetooth;

import org.scifair.util.BaseLejos;

public class Findevice extends BaseLejos {
	double command = 0;
	double reply = 0;
	int stream = 0;
	int sequenceint = 0;
	private DataOutputStream dOut;
	private DataInputStream dIn;

	
	public void establishBTConnection() {
		
		System.out.println("Waiting...");
		BTConnection btc = Bluetooth.waitForConnection();
		System.out.println("connection established");

		dOut = btc.openDataOutputStream();
		dIn = btc.openDataInputStream();

		System.out.println("streams established");
	}
	

	@Override
	public void run()
	{
		establishBTConnection();
		for(;;)
		{
			if(dIn.available()==0)continue;
			
 		    System.out.println("i got data");
 		    
			
		}
	}


	public static void main(String[] args) {
		Findevice find = new Findevice();
		find.run();
	
		
	}

}
