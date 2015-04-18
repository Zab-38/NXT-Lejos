package org.scifair2015.commands;

import java.io.DataOutputStream;

public abstract class Command {

	protected byte cmd;
	
	public int getCmd()
	{
		return cmd;
	}
	
	abstract public void sendCommand(DataOutputStream dos);
	
}
