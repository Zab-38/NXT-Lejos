package com.josh.lejos.util;

import lejos.nxt.LCD;

public class Sprite {
	public int x;
	public int y;
	
	public int oldX;
	public int oldY;
	
	public void moveX(int amount)
	{
		oldX = x;
		oldY = y;
		x=x+amount;

		LCD.setPixel(x, y,1);
		LCD.setPixel(oldX, oldY, 0);
	}
	
	public void moveY(int amount)
	{
		oldX = x;
		oldY = y;
		y=y+amount;
		LCD.setPixel(x, y,1);
		LCD.setPixel(oldX, oldY, 0);
	}
	
}
