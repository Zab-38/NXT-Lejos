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
	
	private void drawHorizontalGridLines(Graphics g)
	{
		int xLeft = 0;
		int xRight = getWidth();
		
		//will make grid lines 1/10 of height
		g.setColor(Color.yellow);
		
		int lineCount  = 20;
		for(int count = 0; count < lineCount; count++)
		{
			int y = getHeight()/lineCount * count;
			
			
			if( Math.abs(y-getHeight()/2 )> 2)
			{
				
				g.drawLine(xLeft, y, xRight, y);
			}

		}	
			
		
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
	  drawHorizontalGridLines(g);
	}
	public static void main(String[] args) {
		Newslope frame = new Newslope();
		frame.setSize(500, 500);
		frame.setBackground(Color.WHITE);
		frame.setVisible(true);
	}
}
