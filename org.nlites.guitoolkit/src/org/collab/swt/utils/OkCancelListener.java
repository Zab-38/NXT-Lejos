package org.collab.swt.utils;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.widgets.Shell;

/**
 * typical usage is to create an anonymous class and fill in the onEscape and
 * onReturn functionality
 * 
 * @author Northern Lights
 * 
 */
public abstract class OkCancelListener implements TraverseListener {

	private Shell shell;

	/**
	 * @return the shell
	 */
	public Shell getShell( ) {
		return shell;
	}

	@Override
	public void keyTraversed( TraverseEvent e ) {
		switch( e.detail ) {
		case SWT.TRAVERSE_ESCAPE:
			// call the overrided method
			onEscape( );

			e.detail = SWT.TRAVERSE_ESCAPE;
			e.doit = false;
			getShell( ).close( );

		break;

		case SWT.TRAVERSE_RETURN:

			// call the overrided method
			onCarraigeReturn( );
			e.detail = SWT.TRAVERSE_RETURN;
			e.doit = true;
			getShell( ).close( );
		break;
		}

	}

	// behaviour before window closes when RETURN hit
	public abstract void onCarraigeReturn( );

	// behaviour before window closes when ESC hit
	public abstract void onEscape( );

	/**
	 * @param shell
	 *            the shell to set
	 */
	public void setShell( Shell shell ) {
		this.shell = shell;
	}

}
