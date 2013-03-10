package org.lejos.pcsample.usbsend;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MyFrame extends JFrame implements ActionListener {

	Timer timer = null;
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
		TwoPanelForm f = new TwoPanelForm(this);
		
		timer = new Timer(800, this);
		timer.start();

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
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("hello");
		
	}
	public static void main(String[] args) {
		
		MyFrame frame = new MyFrame();
		
		Dimension dim = new Dimension(500, 300);
		frame.setSize(dim);
		frame.setVisible(true);
	}
}
