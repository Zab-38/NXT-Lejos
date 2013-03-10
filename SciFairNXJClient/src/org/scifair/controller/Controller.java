package org.scifair.controller;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import org.lejos.pcsample.usbsend.DrawPanel;
import org.scifair.controller.NXTCommunications.Msg;

public class Controller implements ActionListener{
	public static Timer timer = null;
	private int x;

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
		
		Graphics g = drawPanel.getGraphics();
		NXTCommunications comm = NXTCommunications.singleton();
		comm.sendMsg('d', 0);
		Msg msg = comm.rcvMsg();
		
		if(msg!=null)
		{
			g.draw3DRect(x++,(int)msg.value, 20, 20, true);
		}

		
	}
	
}
