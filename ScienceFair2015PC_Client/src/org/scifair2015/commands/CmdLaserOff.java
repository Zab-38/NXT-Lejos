package org.scifair2015.commands;

import java.io.DataOutputStream;
import java.io.IOException;

public class CmdLaserOff extends Command {
	public CmdLaserOff() {
		cmd = '3';
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
