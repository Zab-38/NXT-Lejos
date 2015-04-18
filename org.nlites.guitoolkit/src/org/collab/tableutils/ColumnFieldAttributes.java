package org.collab.tableutils;

public class ColumnFieldAttributes implements IColumnAttributes {
	private int width = 0;
	private String label = "";

	@Override
	public String getLabel( ) {
		return label;
	}

	public int getWidth( ) {
		return width;
	}

	@Override
	public void setLabel( String label ) {
		this.label = label;
	}

	public void setWidth( int width ) {
		this.width = width;
	}

}
