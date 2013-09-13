package josh.cartesian;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Date;

import javax.swing.JFrame;

/**
 * 
 * @author FPNMB
 *
 */

//TODO: eliminate ghosting of gridlines and axis
public class XYgrid extends JFrame {
	int xmove = getHeight();
	int xmove2 = 0;
	int ymove = getWidth();
	int ymove2 = 0;
	int count = 0;
	
	public void drawFunction(Graphics g, IFunction f)
	{
		for(double x = -10; x< 10; x++)
		{
			double y = -f.function(x);
			
			int pixelX = (int) (x*25)+getWidth()/2 - 2;
			int pixelY = (int) (y*25) + getHeight()/2 - 2;
			 g.setColor(Color.black);
			g.drawOval((int)pixelX, (int)pixelY, 5, 5);
			
		}
	}
	public void drawXYAxes (Graphics g) {
		g.setColor(Color.GREEN);
	    g.drawLine(getWidth() / 2, getHeight() , getWidth() / 2,0);
	    g.drawLine(getWidth(), getHeight() / 2, 0, getHeight() / 2);

	  }
	
	private void drawHorizontalGridLines(Graphics g)
	{
		int xLeft = 0;
		int xRight = getWidth();
		
		//will make grid lines 1/10 of height
		g.setColor(Color.red);
		
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

	  drawXYAxes(g);
	  drawHorizontalGridLines(g);
	  drawVerticalGridLines(g);
	  drawFunction(g, new LineFunction());
	  drawFunction(g, new ParabalaFunction());
	  
	}
	public static void main(String[] args) {
		XYgrid frame = new XYgrid();
		frame.setSize(500, 500);
		frame.setBackground(Color.WHITE);
		frame.setVisible(true);
	}
}
