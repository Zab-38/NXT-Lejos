package joshgui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;

import javax.swing.JTextField;

public class Guru {
	String Answer = "Yes:Maybe:No:Banana:That question is stoopid ya dumbo:000Base-SX / LX PCI Express Fiber Adapter with SC connector is designed with 1x9 Optical transceiver and to operate at 1000Mbps at full duplex. OnAcces";
	String[] identifyAsArray = Answer.split(":");
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * @return
	 */
	public String randomSelection() {
		int Answerdex = new Random().nextInt(identifyAsArray.length);
		String randomIdentification = identifyAsArray[Answerdex];
		String Result = randomIdentification;
	return Result;

	}
	
	public void print() {
	}

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Guru window = new Guru();
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
	public Guru() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("What is your question?");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// put code here
			}
		});
		btnNewButton.setBounds(109, 13, 209, 25);
		frame.getContentPane().add(btnNewButton);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(69, 51, 298, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// put code here
				textField_1.setText(randomSelection());
			}
		});
		btnOk.setBounds(170, 86, 97, 25);
		frame.getContentPane().add(btnOk);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setBounds(69, 144, 298, 86);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
	}
}
