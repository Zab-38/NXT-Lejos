package org.scifair2015.commands;

import java.io.DataOutputStream;
import java.io.IOException;

public class CmdTerminate extends Command {
	public CmdTerminate() {
		cmd = '5';
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
