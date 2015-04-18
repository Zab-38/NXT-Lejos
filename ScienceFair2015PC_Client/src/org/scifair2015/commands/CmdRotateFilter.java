package org.scifair2015.commands;

import java.io.DataOutputStream;
import java.io.IOException;

public class CmdRotateFilter extends Command {
	private int position;
	private int motorNumber;
	public CmdRotateFilter(int motorNumber, int position) {
		cmd = 'c';
		this.motorNumber = motorNumber;
		this.position = position;
	}
	@Override
	public void sendCommand(DataOutputStream dos) {

		try {
			dos.write(cmd);
			dos.write(motorNumber);
			dos.write(position);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
