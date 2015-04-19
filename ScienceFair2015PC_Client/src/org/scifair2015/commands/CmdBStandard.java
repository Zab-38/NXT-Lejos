package org.scifair2015.commands;

import java.io.DataOutputStream;
import java.io.IOException;

public class CmdBStandard extends Command {
	public CmdBStandard() {
		cmd = 'b';
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