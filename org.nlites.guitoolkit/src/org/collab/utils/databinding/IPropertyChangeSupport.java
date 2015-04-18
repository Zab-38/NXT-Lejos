package org.collab.utils.databinding;

import java.beans.PropertyChangeListener;

public interface IPropertyChangeSupport {
	public void addPropertyChangeListener( String field,
			PropertyChangeListener listener );

	public void removePropertyChangeListener( PropertyChangeListener listener );
}
