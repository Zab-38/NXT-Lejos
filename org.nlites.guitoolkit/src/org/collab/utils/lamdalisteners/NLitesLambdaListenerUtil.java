package org.collab.utils.lamdalisteners;

import java.util.function.Consumer;

import org.eclipse.swt.events.SelectionEvent;

public class NLitesLambdaListenerUtil {

	
	public static JustTheSelectionListener createSelectionListener(Consumer<SelectionEvent> c)
	{
		return new JustTheSelectionListener().setWidgetSelectedListener(c);
	}
	
	
	
	
	
}
