package josh.cartesian;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 * Things to do daily
 * 1) run the program
 * 2) read the code
 * 3) consider improving naming of both variables and functions
 * 4) make modifications
 * 5) consider adding new functions
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
	int numberOfGridLines = 20;
	int relativevalues = 50;
	int converttonegative = relativevalues - relativevalues;
    int negativevalues = converttonegative - relativevalues;
    int multiplyvalues = relativevalues * 2;
    
	private void drawHorizontalGridLines(Graphics g)
	{
		
		g.setColor(Color.red);
		for(int y= negativevalues; y <= relativevalues; y++)
		{
			
			drawLine(g, negativevalues, y, relativevalues, y);
        }
	}
	
		
      private void drawVerticalGridLines(Graphics g)
      {
  		g.setColor(Color.red);
  		for(int x= negativevalues; x <= relativevalues; x++)
  		{
  			drawLine(g, x, negativevalues, x, relativevalues);
          }
      }
    
	private void drawOval(Graphics g, double x, double y) {
        
		int width = getWidth() / multiplyvalues;
		int height = getHeight() / multiplyvalues;
		int convertx = width / 2;
		int converty = height /2;
		g.setColor(Color.DARK_GRAY);
		Point pixelPoint = convertXYtoPixels(x, y);
		g.drawOval((int) pixelPoint.x - convertx, (int) pixelPoint.y - converty, width, height);
		g.fillOval((int) pixelPoint.x - convertx, (int) pixelPoint.y - converty, width, height);
	}


	private Point convertXYtoPixels(double x, double y)
      {
    	  Point result = new Point(0, 0); 
    			  
    	  int screenHeight = getHeight();
    	  int screenWidth = getWidth();
    	  
    	  int correctionx = screenWidth/2;
    	  int correctiony = screenHeight/2;
    	  
    	  double unitConversionFactorX = screenWidth/multiplyvalues; 
    	  double unitConversionFactorY = screenHeight/multiplyvalues;
    	  

    	  double newX = x*unitConversionFactorX + correctionx;
    	  double newY = - y*unitConversionFactorY + correctiony;
    	  
    	  result.x = newX;
    	  result.y = newY;
    	  return result;
      }
      
      private int getSpacingHeight()
      {
    	  int screenHeight = getHeight();
    	  int spacingHeight = screenHeight / 20;
    	  return spacingHeight;
      }
      
      private int getSpacingWidth()
      {
    	  
		  int screenWidth = getWidth();
    	  int spacingWidth = screenWidth / 20;
    	  return spacingWidth;
    	 
    	  
      }
      
    
      private void drawFunction (Graphics g, IFunction f)
      {
    	  for(int x = negativevalues ; x<=relativevalues;x++)
    	  {
    		  drawOval(g, x,  0.1*f.function(x));
    	  }
      }
      
      private void drawMainLines (Graphics g) {
    	  int height = getHeight();
    	  int width = getWidth();
    	  int halfheight = height / 2;
    	  int halfwidth = width / 2;
    	  g.setColor(Color.green);
    	  g.drawLine(halfwidth, 0,  halfwidth, getHeight());
    	  g.drawLine(0, halfheight, getWidth(), halfheight);
    	  
    	  
      } 
      
      
    //  private Point convertPixelsToXY(int pixelX, int pixedlY)
     // {
    	//  Point result = new Point(0,0);
    	//  int frameWidth = getWidth();
    	//  int frameHeight = getHeight();
    	  
    	  
    //  }

      
     private void drawLine(Graphics g, int x1, int y1, int x2, int y2)
     {
    	 Point point1 = convertXYtoPixels(x1,y1);
    	 Point point2 = convertXYtoPixels(x2, y2);
    	 g.drawLine((int)point1.x, (int)point1.y, (int)point2.x, (int)point2.y);
    	 
    	 
     }
			
		
      
	@Override
	public void paint(Graphics g) {

	 
	  drawHorizontalGridLines(g);
	  drawVerticalGridLines(g);
      //drawOval(g, 3,3);	
      drawMainLines(g);
      drawFunction(g, new CubicFunction());
	 
	  
	}
	public static void main(String[] args) {
		
		XYgrid frame = new XYgrid();
		frame.setSize(500, 500);
		frame.setBackground(Color.WHITE);
		frame.setVisible(true);
		
	
	}
}
