package org.scifair2015.commands;

import java.io.DataOutputStream;
import java.io.IOException;

public class Cmd1 extends Command {
	public Cmd1() {
		cmd = 1;
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
