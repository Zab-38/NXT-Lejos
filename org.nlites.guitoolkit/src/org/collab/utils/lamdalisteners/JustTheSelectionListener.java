package org.collab.utils.lamdalisteners;

import java.util.function.Consumer;
import java.util.function.Function;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.ui.IWorkbenchPart;

public class JustTheSelectionListener implements SelectionListener{

	Consumer<SelectionEvent> c;
	public JustTheSelectionListener setWidgetSelectedListener(Consumer<SelectionEvent> f)
	{
		c = f;
		return this;
		
	}
	@Override
	public void widgetSelected(SelectionEvent e) {
		c.accept(e);
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
	}


}
