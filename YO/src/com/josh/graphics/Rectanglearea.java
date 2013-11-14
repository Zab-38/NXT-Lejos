package com.josh.graphics;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;



public class Rectanglearea extends JFrame{
public int length = 20;
public int width = 30;

public void area() {
	System.out.println(length * width);
}

@Override
public void paint(Graphics g) {

  rectangle(g);
}

public void rectangle (Graphics f) {
	f.setColor(Color.CYAN);
    f.drawRect (0, 0, width, length);   
//    f.fillRect (0, 0, width, length);
  }


public static void main(String[] args) {
	
	Rectanglearea rect = new Rectanglearea();
	
	rect.area();
	rect.setSize(50, 50);
	rect.setBackground(Color.WHITE);
	rect.setVisible(true);
}


}
