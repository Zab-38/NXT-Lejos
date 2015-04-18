package org.collab.swt.text.util;

import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.widgets.Text;

public class TextFocusHandlerToPreserveCaretLocation implements FocusListener {
	private int lastposition = 0;

	public TextFocusHandlerToPreserveCaretLocation( ) {}

	@Override
	public void focusGained( FocusEvent e ) {
		Text text = (Text)e.getSource( );
		text.setSelection( lastposition, lastposition );

	}

	@Override
	public void focusLost( FocusEvent e ) {
		Text text = (Text)e.getSource( );
		lastposition = text.getCaretPosition( );

	}

}
