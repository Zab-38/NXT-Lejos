package org.scifair2015.commands;

import java.io.DataOutputStream;
import java.io.IOException;

public class Cmd3 extends Command {
	public Cmd3() {
		cmd = 3;
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
