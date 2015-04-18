package org.collab.tableutils;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;

public class TableColumnFactory {
	int index = 0;
	private TableViewer viewer;

	public TableColumnFactory( TableViewer _viewer ) {
		viewer = _viewer;
	}

	public TableViewerColumn createTableColumn( String text, int width ) {
		TableViewerColumn viewerColumn = new TableViewerColumn( viewer,
				SWT.NONE, index++ );
		TableColumn column = viewerColumn.getColumn( );
		column.setText( text );
		column.setWidth( width );
		column.setResizable( true );
		return viewerColumn;

	}

	public TableViewerColumn createTableColumn( String text, int width,
			ColumnLabelProvider provider ) {
		TableViewerColumn viewerColumn = createTableColumn( text, width );
		viewerColumn.setLabelProvider( provider );
		return viewerColumn;
	}

}
