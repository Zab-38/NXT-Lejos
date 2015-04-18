package org.scifair2015.commands;

import java.io.DataOutputStream;
import java.io.IOException;

public class CmdLaserOff extends Command {
	public CmdLaserOff() {
		cmd = 'e';
	}

	@Override
	public void sendCommand(DataOutputStream dos) {

		try {
			dos.write(cmd);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
