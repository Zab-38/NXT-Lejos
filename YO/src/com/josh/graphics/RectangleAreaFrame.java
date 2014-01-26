package com.josh.graphics;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;



public class RectangleAreaFrame extends JFrame{
public int length = 200;
public int width = 300;

public void area() {
	System.out.println(length * width);
}

@Override
public void paint(Graphics g) {

  rectangle(g);
}

public void rectangle (Graphics f) {
	f.setColor(Color.BLACK);
    f.drawRect (0, 0, width, length);   
//    f.fillRect (0, 0, width, length);
  }


public static void main(String[] args) {
	
	RectangleAreaFrame rect = new RectangleAreaFrame();
	
	rect.area();
	rect.setSize(500, 500);
	rect.setBackground(Color.WHITE);
	rect.setVisible(true);
}


}
