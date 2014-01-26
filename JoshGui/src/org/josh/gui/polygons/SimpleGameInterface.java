package org.josh.gui.polygons;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SimpleGameInterface {
	
    public static Picture pic = null;
	private JFrame frame;

	MyDrawingPanel panel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleGameInterface window = new SimpleGameInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SimpleGameInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		pic = new Picture();
		frame = new JFrame();
		frame.setBounds(0, 0, 781, 691);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		panel = new MyDrawingPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//pic.setXY(5, 5);
				pic.move(0,-5);
				panel.repaint();
			
			
			}
		});
		panel.add(btnNewButton);
		
		JButton btnBackwards = new JButton("down");
		btnBackwards.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//pic.setXY(5, 5);
				pic.move(0,5);
				panel.repaint();
			
			
			}
		});

		panel.add(btnBackwards);

		
		JButton btnLeft = new JButton("left");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//pic.setXY(5, 5);
				pic.move(-5,0);
				panel.repaint();
			
			
			}
		});
		panel.add(btnLeft);
		
		JButton btnRight = new JButton("right");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//pic.setXY(5, 5);
				pic.move(5,0);
				panel.repaint();
			
			
			}
		});
		panel.add(btnRight);
	}

}
