package org.josh.gui.polygons;

import java.awt.Graphics;

import javax.swing.JPanel;

public class MyDrawingPanel extends JPanel {


	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		SimpleGameInterface.pic.drawPicture(g);
		
	}
}
