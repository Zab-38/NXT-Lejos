package org.scifair2015.commands;


public class CmdRotateFilter extends Command {
	private int position;
	private int motorNumber;
	public CmdRotateFilter(int motorNumber, int position) {
		cmd = 200;
		this.motorNumber = motorNumber;
		this.position = position;
	}
}
