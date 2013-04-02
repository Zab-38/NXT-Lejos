package org.scifair.controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.Timer;

import lejos.nxt.LCD;

import org.lejos.pcsample.usbsend.DrawPanel;
import org.scifair.controller.NXTCommunications.Msg;

/**
 * Feel free to modify this.  The working Controller (do not touch) is Controller
 * @author FPNMB
 *
 */
public class ControllerExperiment implements ActionListener {
	public static Timer timer = null;
	private int xOld;
	private int yOld = xOld;
	int line = xOld;
	int afterline = 0;
    int level = 0;
	DrawPanel drawPanel = null;

	public DrawPanel getDrawPanel() {
		return drawPanel;
	}

	public void setDrawPanel(DrawPanel drawPanel) {
		this.drawPanel = drawPanel;
	}

	private static ControllerExperiment controller = null;

	private ControllerExperiment() {
		timer = new Timer(50, this);
	}

	public static ControllerExperiment singleton() {
		if (controller == null) {
			controller = new ControllerExperiment();
		}

		return controller; 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (drawPanel == null)
			return;

		InputStream is = getClass().getResourceAsStream("poisonous_potato.png");
		BufferedImage img = null;
		try {
			img = ImageIO.read(is);
		} catch (IOException ex) {
		}

		// img has the image data, now draw it on the scrween
		Graphics g = drawPanel.getGraphics();
		NXTCommunications comm = NXTCommunications.singleton();
		comm.sendMsg('d', 0);
		
		Msg msg = comm.rcvMsg();

		if (msg != null) {
			double distance = msg.distance;
			double angle = (((double)msg.angle) / 360.0) * 2.0*Math.PI;
			
			System.out.println("angle in Radians: " + angle);
			
		    int x =  (int) (Math.cos(angle) * distance);
		    int y = (int) (Math.sin(angle)* distance);
		    
		    int centerX = drawPanel.getWidth()/2;
		    int centerY = drawPanel.getHeight()/2;
		    
		    g.drawLine(centerX, centerY, centerX+x, centerY+y);

		}

	}

}
