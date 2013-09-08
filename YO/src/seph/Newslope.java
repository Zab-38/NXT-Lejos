package seph;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Newslope extends JFrame {
	int xmove = getHeight();
	int xmove2 = 0;
	int ymove = getWidth();
	int ymove2 = 0;
	int count = 0;
	public void rectangle (Graphics g) {
		g.setColor(Color.BLACK);
	    g.drawLine(getWidth() / 2, getHeight() , getWidth() / 2,0);
	    g.drawLine(getWidth(), getHeight() / 2, 0, getHeight() / 2);

	  }
	public void newlines(Graphics g) {
		count = count + 1;
		xmove = xmove + 100;
		xmove2 = xmove + 100;
		ymove = ymove + 100;
		ymove2 = ymove2 + 100;
		g.setColor(Color.BLACK);
	    g.drawLine(getWidth() / 2, xmove , getWidth() / 2, xmove2);
	    g.drawLine(ymove, getHeight() / 2, ymove2, getHeight() / 2);
	}
	@Override
	public void paint(Graphics g) {

	  rectangle(g);
	}
	public static void main(String[] args) {
		Newslope frame = new Newslope();
		while (frame.count < 10) {
			frame.newlines(g);
		}
		frame.setSize(500, 500);
		frame.setBackground(Color.WHITE);
		frame.setVisible(true);
	}
}
