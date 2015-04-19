package org.scifair2015.commands;

import java.io.DataOutputStream;
import java.io.IOException;

public class Cmd4 extends Command {
	public Cmd4() {
		cmd = 500;
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
