package org.lejos.pcsample.usbsend;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.lejos.pcsample.usbsend.NXTCommunications.Msg;

public class Controls {

	
	GridBagConstraints gridbagConstraints = new  GridBagConstraints();
	private Container parent;
	private int rowCount = 0 ;
	
	
	JButton button1;
	private JButton button2;
	
	public Controls(Container parent)
	{
		this.parent = parent;
		parent.setLayout(new GridBagLayout());
		gridbagConstraints.fill = GridBagConstraints.BOTH;
		gridbagConstraints.insets= new Insets(5,5,5,5);
		
		createButton1();
		createButton2();
		createBottomSpace();
	}
	
	private void createButton1()
	{
		setConstraints();
		button1 = new JButton("Start");
		button1.addActionListener(new ActionListener() {
			
			

			@Override
			public void actionPerformed(ActionEvent e) {
			
				MyFrame.timer.start();
				
				
			}
		});
		parent.add(button1,gridbagConstraints);
	}
	private void createButton2()
	{
		setConstraints();
		button2 = new JButton("Stop");
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				MyFrame.timer.stop();
			}
		});
		
		parent.add(button2,gridbagConstraints);
	}
	
	private void createBottomSpace()
	{
		setConstraints();
		gridbagConstraints.weighty = 0.8;
		parent.add(new JPanel(),gridbagConstraints);
	}
	
	private void setConstraints()
	{
		gridbagConstraints.fill = GridBagConstraints.BOTH;
		
		gridbagConstraints.gridx = 0;
		gridbagConstraints.gridy = rowCount++;
		gridbagConstraints.weighty = 0.1;
		gridbagConstraints.weightx = 0.9;
	}
}
