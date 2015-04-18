package org.scifair2015.commands;

import java.io.DataOutputStream;
import java.io.IOException;

public class CmdLaserOn extends Command {
	public CmdLaserOn() {
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
