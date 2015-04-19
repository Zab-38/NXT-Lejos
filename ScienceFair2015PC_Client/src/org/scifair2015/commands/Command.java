package org.scifair2015.commands;

import org.scifair2015.client.SciFair2015Client;

public class Command {

	protected int cmd;
	
	public int getCmd()
	{
		return cmd;
	}
	
	public void sendCommand()
	{
		SciFair2015Client.writeInt(cmd);
	}
	
}
