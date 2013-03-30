package org.lejos.pcsample.usbsend;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.scifair.controller.NXTCommunications;

@SuppressWarnings("serial")
public class MyFrame extends JFrame {

	TwoPanelForm twoPanelForm;
	NXTCommunications comm = NXTCommunications.singleton();
	
	public MyFrame() {
		super();
		try {
			UIManager.setLookAndFeel(
			        UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setLayout(new GridBagLayout());
		twoPanelForm = new TwoPanelForm(this);
		

		//open communications
		comm.open();
		
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				comm.sendMsg('x', 0);
				comm.close();
			}
			
			
			@Override
			public void windowClosed(WindowEvent e) {
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
			}
		});
		
		
		
		
	};
	
	
	
	public static void main(String[] args) {
		
		MyFrame frame = new MyFrame();
		
		Dimension dim = new Dimension(500, 300);
		frame.setSize(dim);
		frame.setVisible(true);
	}
}
