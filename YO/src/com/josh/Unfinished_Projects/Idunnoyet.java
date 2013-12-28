package com.josh.Unfinished_Projects;

import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.applet.Applet;

import javax.swing.JFrame;


public class Idunnoyet extends JFrame
implements KeyListener{
	//private Image dbImage;
	//private Graphics dbg;
	int x = 50;
	int y = 50;

	
	public Idunnoyet()
	{
		addKeyListener(this);
	}
	public void rectangle (Graphics f) {
		f.setColor(Color.BLACK);
	    f.drawRect (x, y, 150, 150);   

	  }
	//public void paintComponent (Graphics g) {
	//	dbImage = createImage(getWidth(),getHeight());
	//}
	
	
	public Image createImage(int width, int height)
	{
		//fill this out
		return null;
	}
	@Override
	public void paint (Graphics g) {

	  rectangle(g);
	 
	}

	
public static void main(String[] args) {
	Idunnoyet dunno = new Idunnoyet();
	dunno.setSize(500, 500);
	dunno.setBackground(Color.WHITE);
	dunno.setVisible(true);
}
@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyPressed(KeyEvent e) {
	if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
		x = x + 15;
	}
	else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
		x = x - 15;
	}
	else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
		y = y + 15;
	}
	else if (e.getKeyCode() == KeyEvent.VK_UP) {
		y = y - 15;
	}
	
	repaint();
	
}


@Override
public boolean keyDown(Event evt, int key) {
	if (key == KeyEvent.VK_RIGHT) {
		x = x + 15;
	}
	else if (key == KeyEvent.VK_LEFT) {
		x = x - 15;
	}
	else if (key == KeyEvent.VK_DOWN) {
		y = y + 15;
	}
	else if (key == KeyEvent.VK_UP) {
		y = y - 15;
	}
	
	
	return super.keyDown(evt, key);
}


@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
}
