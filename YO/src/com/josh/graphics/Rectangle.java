package com.josh.graphics;

import java.awt.Color;
import java.awt.Graphics;


public class Rectangle extends RectangleAreaFrame {
	public void rectangle (Graphics f) {
	    f.drawRect (0, 0, width, length);   
	    f.fillRect (0, 0, width, length);
	    f.setColor(Color.CYAN);
	  }
}
