package org.josh.gui.polygons;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JButton;

import sound.PlaySound;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Firstapp {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Firstapp window = new Firstapp();
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
	public Firstapp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel lblYoloRight = new JLabel("Yolo right");
		frame.getContentPane().add(lblYoloRight, BorderLayout.WEST);
		
		JButton btnFartNoise = new JButton("Fart noise");
		btnFartNoise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlaySound  ps = new PlaySound();
				ps.playsound();
			}
		});
		frame.getContentPane().add(btnFartNoise, BorderLayout.CENTER);
	}

}
