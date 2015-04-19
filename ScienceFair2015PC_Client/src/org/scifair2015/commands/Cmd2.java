package org.scifair2015.commands;

import java.io.DataOutputStream;
import java.io.IOException;

public class Cmd2 extends Command {
	public Cmd2() {
		cmd = 2;
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
