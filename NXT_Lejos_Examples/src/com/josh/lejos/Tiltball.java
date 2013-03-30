package com.josh.lejos;

import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.addon.AccelHTSensor;
import lejos.nxt.addon.AngleSensor;

import org.scifair.util.BaseLejos;
public class Tiltball extends BaseLejos{
	
	AccelHTSensor sensor = new AccelHTSensor(SensorPort.S1);
//	AngleSensor sensor = new AngleSensor(SensorPort.S1);
	
int x = 0;
int otherx = 5;



public void pixelplace() {
	LCD.clearDisplay();
	LCD.setPixel(otherx, 5, 1);
	LCD.drawString("x ="+ x, 0,4 );
}

public void tilt() {
	
//	int x = sensor   .get();


}

//public void display() {
	//System.out.println("(" +x +","+ y + "," +z +")");
	
//X is actually Y, and Y is actually Z


public void thingy(){
	try {
		Thread.sleep(500);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	pixelplace();
	tilt();
	if (x > 200) {
	otherx =otherx + 1 ;
	}
	//display();
}


@Override
public void run() {while(true){thingy();}};

public static void main(String[] args) {
Tiltball tilt = new Tiltball();
tilt.run();

}
}
