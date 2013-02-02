package com.josh.lejos.remote;

import java.io.*;
import lejos.nxt.*;
import lejos.nxt.comm.*;

/**
 * sample of selecting channel at run time
 */
public class CommTest 
{
  public static void main(String[] args) { 
    LCD.drawString("right BT",0, 0);
    NXTConnection connection = null;

    if(Button.waitForAnyPress() == Button.ID_RIGHT){
      LCD.drawString("waiting for BT", 0,1 );
      connection = Bluetooth.waitForConnection();
    } else {
      LCD.drawString("waiting for USB", 0,1 );
      connection = USB.waitForConnection();
    }

    DataOutputStream dataOut = connection.openDataOutputStream();
    try {
      dataOut.writeInt(1234);
    } catch (IOException e ) {
      System.out.println(" write error "+e); 
    }
  }   
}