package org.scifair2015.commands;

import java.io.DataOutputStream;
import java.io.IOException;

import org.scifair2015.client.SciFair2015Client;

public class CmdEcho extends Command{
	public CmdEcho() {
	  cmd = '0';
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
