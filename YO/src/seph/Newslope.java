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
			}}}
		
      private void drawVerticalGridLines(Graphics g)
      {
    	  int yTop = 0;
    	  int yRight = getHeight();
    	  
    	  g.setColor(Color.blue);
    	  int lineCount = 20;
    	  for(int count = 0; count < lineCount; count ++)
    	  {
    		  int x = getWidth()/lineCount * count;
    		  
    		  if( Math.abs(x-getWidth()/2)> 2)
    		  {
    			  g.drawLine(x, 0,  x, getHeight());
    		  }

    		  //old code
//    		  if( Math.abs(x-getWidth()/2)> 2)
//    		  {
//    			  g.drawLine(yLeft, x, yRight, x);
//    		  }
    	  }
      }
			
			
		
	
	@Override
	public void paint(Graphics g) {

	  rectangle(g);
	  drawHorizontalGridLines(g);
	  drawVerticalGridLines(g);
	}
	public static void main(String[] args) {
		Newslope frame = new Newslope();
		frame.setSize(500, 500);
		frame.setBackground(Color.WHITE);
		frame.setVisible(true);
	}
}
