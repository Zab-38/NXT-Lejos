package org.josh.gui.polygons;

import java.awt.Graphics;

import javax.swing.JFrame;

public class PolygonFrame extends JFrame {

	
	PolygonDraw polygonDraw = new PolygonDraw();
	//PolygonDraw polygonDrawSecond = new PolygonDraw();
	
	public PolygonDraw getPolygonDraw() {
		return polygonDraw;
	}


	@Override
	public void paint(Graphics g) {
		super.paintComponents(g);

		polygonDraw.paint(g, getWidth(), getHeight());
		
		//polygonDrawSecond.setPositionXY(50, 0);
	//	polygonDrawSecond.paint(g, getWidth(), getHeight());
	
	}
}
