package org.collab.swt.utils;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

/**
 * 
 * @author docere
 * 
 */
public class PopupShowUtility {

	private Shell popup;
	protected final INLitesTkFormFactory formFactory;
	private final Rectangle bounds;

	private IPopupResponseListener popupResponseListener = null;

	public PopupShowUtility( final INLitesTkFormFactory _formFactory,
			Rectangle _bounds ) {
		this.formFactory = _formFactory;
		this.bounds = _bounds;
	}

	private void createPopup( ) {
		Display d = Display.getCurrent( );
		if( d == null )
			d = new Display( );

		final Shell s = new Shell( d );

		GridLayout layout = new GridLayout( );
		layout.numColumns = 1;
		s.setLayout( layout );

		popup = new Shell( s, SWT.APPLICATION_MODAL | SWT.POP_UP );
		popup.setBounds( this.bounds );
		formFactory.createForm( popup );
		popup.addListener( SWT.Traverse, new Listener( ) {
			@Override
			public void handleEvent( Event event ) {
				switch( event.detail ) {
				case SWT.TRAVERSE_ESCAPE:
					if( popupResponseListener != null ) {
						popupResponseListener.cancel( );
					}

					popup.close( );
					s.close( );
					event.detail = SWT.TRAVERSE_NONE;
					event.doit = false;
				break;

				case SWT.TRAVERSE_RETURN:
					if( popupResponseListener != null ) {
						popupResponseListener.ok( );
					}

					popup.close( );
					s.close( );
					event.detail = SWT.TRAVERSE_NONE;
					event.doit = true;
				break;
				}
			}
		} );
	}

	public void open( ) {
		createPopup( );
		popup.open( );
	}

	public void setPopupResponseListener( IPopupResponseListener listener ) {
		popupResponseListener = listener;
	}

	public void setTopLeft( int x, int y ) {
		bounds.x = x;
		bounds.y = y;
	}

	public void showStandalone( ) {
		open( );
		Shell s = popup.getShell( );
		Display d = s.getDisplay( );

		while( !s.isDisposed( ) ) {
			if( !d.readAndDispatch( ) )
				d.sleep( );
		}
		d.dispose( );
	}

}
