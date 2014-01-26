package org.josh.gui.polygons;

import java.awt.Graphics;
import java.awt.Polygon;

public class PolygonDraw {

	int numOfSides = 4;
	int posX =0;
	int posY =0;
	

	public void paint(Graphics g, int width, int height)
	{
		int i = 0;
		Polygon polygon = new Polygon();
		for (i = 0; i < numOfSides; i++) {
			int x = posX + width / 2;
			int y = posY + height / 2 + 10;
			int radius = (int) (Math.min(width, height) * 0.4);
			double angle = 2 * Math.PI / numOfSides;
			polygon.addPoint((int) (x + radius * Math.cos(i * angle)),
					(int) (y - radius * Math.sin(i * angle)));

		}

		// Draw Polygon after all the points are added
		g.drawPolygon(polygon);
		g.drawString(Integer.toString(numOfSides), width / 2 + posX, height / 2 + posY);
	}
	
	public void incrementNumOfSides()
	{
		numOfSides +=1;
	}
	
	public void decrementNumOfSides()
	{
		numOfSides -=1;
	}
	
	public void setPositionXY(int x, int y)
	{
		posX = x;
		posY = y;
	}
	
	public void setNumOfSides(int n)
	{
		numOfSides = n;
	}
}
