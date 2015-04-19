package org.scifair2015.commands;

import java.io.DataOutputStream;
import java.io.IOException;

public class Rotato extends Command {
	public Rotato() {
		cmd = 'd';
	}

	@Override
	public void sendCommand(DataOutputStream dos) {

		try {
			dos.write(cmd);
			dos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}