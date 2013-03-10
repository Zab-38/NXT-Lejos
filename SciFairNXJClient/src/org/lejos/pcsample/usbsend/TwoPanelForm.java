package org.lejos.pcsample.usbsend;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import org.scifair.controller.Controller;

@SuppressWarnings("serial")
public class TwoPanelForm extends JPanel{
	
	
	private GridBagConstraints constraints = new GridBagConstraints();
	private DrawPanel drawPanel;
	
	
	public DrawPanel getDrawPanel() {
		return drawPanel;
	}
	private JPanel rightPanel;
	private Controls controls;

	public Controls getControls() {
		return controls;
	}


	public TwoPanelForm(Container parent)
	{
		setBackground(Color.cyan);
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridheight = 0;
		constraints.gridheight = 0;
		constraints.insets = new Insets(3, 3, 3, 3);
		constraints.weightx = 1;
		constraints.weighty = 1;
		parent.add(this,constraints);
		
		
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		
		createDrawPanel();
		createRightPanelControls();
	}
	
	
	private void createDrawPanel()
	{
		drawPanel = new DrawPanel();
		Controller.singleton().setDrawPanel(drawPanel);
		
		drawPanel.setBackground(Color.WHITE);
		
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 0.8;
		constraints.gridx = 0;
		this.add(drawPanel,constraints);
		
	}
	private void createRightPanelControls()
	{
		rightPanel = new JPanel();
		rightPanel.setBackground(Color.gray);
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridx = 1;
		constraints.weightx = 0.2;
		this.add(rightPanel,constraints);
		
		controls = new Controls(rightPanel);
	}
	

}
