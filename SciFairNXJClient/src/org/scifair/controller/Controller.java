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

import org.lejos.pcsample.usbsend.DrawPanel;
import org.scifair.controller.NXTCommunications.Msg;

public class Controller implements ActionListener{
	public static Timer timer = null;
	private int x;
	int line = 0;
	int afterline = 0;

	DrawPanel  drawPanel = null;
	public DrawPanel getDrawPanel() {
		return drawPanel;
	}

	public void setDrawPanel(DrawPanel drawPanel) {
		this.drawPanel = drawPanel;
	}
 
	private static Controller controller = null;

	private Controller()
	{
		timer = new Timer(50, this);
	}
	
	public static Controller singleton()
	{
		if(controller ==null)
		{
			controller = new Controller();
		}		
		
		return controller;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(drawPanel==null)return;
		
		InputStream is = getClass().getResourceAsStream("poisonous_potato.png");
		BufferedImage img = null;
		try {
		    img = ImageIO.read(is);
		} catch (IOException ex) {
		}
		
		//img has the image data, now draw it on the scrween
		Graphics g = drawPanel.getGraphics();
		NXTCommunications comm = NXTCommunications.singleton();
		comm.sendMsg('d', 0);
		Msg msg = comm.rcvMsg();
		
		if(msg!=null)
		{
			//here is the drawing code
			
			g.draw3DRect(x++,(int)msg.value, 1, 1, true);
//			g.drawImage(img, x++, (int)msg.value, 300, 300, Color.white, null);
		}

		
	}
	
}
