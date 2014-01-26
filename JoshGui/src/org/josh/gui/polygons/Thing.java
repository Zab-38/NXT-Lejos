package org.josh.gui.polygons;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class Thing {
	int number_of_sides = 3;

	private PolygonFrame frame;
	private JTextField textField;
	private JLabel lblHowManySides;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Thing window = new Thing();
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
	public Thing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new PolygonFrame();
		frame.setBounds(100, 100, 656, 534);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JButton btnX = new JButton("+");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getPolygonDraw().incrementNumOfSides();
				textField.setText(Integer.toString(frame.getPolygonDraw().numOfSides));
				frame.repaint();
			}
		});
		frame.getContentPane().add(btnX, BorderLayout.EAST);

		JButton button = new JButton("-");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getPolygonDraw().decrementNumOfSides();
				textField.setText(Integer.toString(frame.getPolygonDraw().numOfSides));
				frame.repaint();

			}
		});
		frame.getContentPane().add(button, BorderLayout.WEST);

		textField = new JTextField();
		textField.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				//need to convert the string contained in the textfield to an integer
				int val = Integer.parseInt(textField.getText());
				frame.getPolygonDraw().setNumOfSides(val);
				frame.repaint();

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(textField, BorderLayout.SOUTH);
		textField.setColumns(10);

		lblHowManySides = new JLabel("How many sides does this polygon have?");
		lblHowManySides.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblHowManySides, BorderLayout.NORTH);

	}
}
