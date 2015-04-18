package org.collab.utils.databinding;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.swt.widgets.Control;

public interface IObservableMasterValue<U extends IPropertyChangeSupport, T extends Enum<T>> {

	public IObservableValue getObservableMasterValue(T field);

	public void bindControl(Control c, T f);

	public void bindFieldToPojoProperty(T f, Object bean,
			String property);

	void unbindControl(Control c);

	void unbindFieldToPojoProperty(T f, Object bean, String property);
}