package org.collab.tableutils;

import java.util.Iterator;
import java.util.function.Consumer;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableItem;

/**
 * Extracts the data item of each displayed item on a tableviewer
 * 
 * @author NLites
 * 
 * @param <E>
 */

public class TableItemIterator<E> implements Iterator<E> {

	private int index = 0;
	private TableItem[] items;

	public TableItemIterator( TableViewer v ) {
		items = v.getTable( ).getItems( );
	}

	@Override
	public boolean hasNext( ) {
		return(index < items.length);
	}

	@Override
	public E next( ) {
		if( !hasNext( ) )
			return null;

		E data = (E)items[index++ ].getData( );
		return data;
	}

	@Override
	public void remove() {
		
	}

	@Override
	public void forEachRemaining(Consumer<? super E> arg0) {
		
	}

}
