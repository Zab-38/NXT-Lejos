package org.collab.swt.utils;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

public class NLitesTkSWTTableUtil {

	public static Point getTopLeftFromSelected( TableViewer tableViewer,
			int columnIndex ) {

		Point topLeftPoint = new Point( 0, 0 );
		Table table = tableViewer.getTable( );
		// topLeftPoint.x += table.getBounds().x;
		// topLeftPoint.y += table.getBounds().y;

		if( tableViewer.getTable( ).isDisposed( ) )
			return topLeftPoint;
		int selectedIndex = tableViewer.getTable( ).getSelectionIndex( );
		if( selectedIndex >= 0 ) {
			TableItem item = table.getItem( selectedIndex );
			topLeftPoint = item.getParent( ).toDisplay( topLeftPoint );

			Rectangle bounds = item.getBounds( );
			Rectangle columnBounds = item.getBounds( columnIndex );

			topLeftPoint.x += columnBounds.x;
			topLeftPoint.y += bounds.y;
		}
		return topLeftPoint;

	}

}
