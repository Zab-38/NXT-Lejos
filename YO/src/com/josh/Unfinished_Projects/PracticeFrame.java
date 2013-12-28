package com.josh.Unfinished_Projects;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PracticeFrame extends JFrame {
	int length = 200;
	int width = 600;
	int height = 8;

	JPanel panel = null;
	private JLabel label;
	
	public PracticeFrame() {
		
		super();
		init();
	}
	public void calculate() {
		System.out.println(length * width * height);
	}

	@Override
	public void paint(Graphics g) {

		super.paint(g);
		rectangle(g);
	}

	public void rectangle(Graphics f) {
		f.setColor(Color.BLACK);
		f.drawRect(100, 100, width, length);

	}
	
	public void init()
	{
		getJPanel();
		JLabel l = getLabel();
		l.setText("hello");
	}
	
	public JPanel getJPanel()
	{

		//if panel not created, create the panel
		if(panel == null)
		{
		
			panel = new JPanel(new BorderLayout());
			panel.setBackground(Color.BLUE);
			getContentPane().add(panel);
		}
		
		return panel;
	}
	
	public JLabel getLabel()
	{
		if(label == null)
		{
			panel = getJPanel();
			label = new JLabel();
			panel.add(label, BorderLayout.EAST);
			
		}
		return label;
	}

	public static void main(String[] args) {
		PracticeFrame prac = new PracticeFrame();
		prac.setLocationRelativeTo(null);
		prac.setVisible(true);
		prac.setSize(500, 500);
		prac.setBackground(Color.WHITE);
		prac.setVisible(true);

	}
}
