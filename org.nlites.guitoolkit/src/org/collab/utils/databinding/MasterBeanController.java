package org.collab.utils.databinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.collab.utils.databinding.BindingTargetIterator.BindingObjectAssociation;
import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.internal.databinding.beans.BeanObservableValueDecorator;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class MasterBeanController<U extends IPropertyChangeSupport, T extends Enum<T>>
		implements IObservableMasterValue<U, T> {
	@Inject
	private DataBindingContext dbcCtx;

	public void setDbcCtx(DataBindingContext dbcCtx) {
		this.dbcCtx = dbcCtx;
	}

	public DataBindingContext getDbcCtx() {
		return dbcCtx;
	}

	private U observableBean;

	// list of created bindings, this is useful in order to remove the bindings
	// on dispose
	// List<Binding> bindings = new ArrayList<Binding>();

	public IObservableList  getBindings() {
		return dbcCtx.getBindings();
	}

	Map<T, IObservableValue> fieldToObservableMap = new HashMap<T, IObservableValue>();

	public MasterBeanController(U observableBean) {
		this.observableBean = observableBean;
	}

	public U getObservableBean() {
		return observableBean;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bitcold.utils.databinding.IObservableMasterValue#getObservableMasterValue
	 * (T)
	 */
	@Override
	public IObservableValue getObservableMasterValue(T field) {
		IObservableValue result = fieldToObservableMap.get(field);
		if (result == null) {
			IObservableValue beanObservableMaster = BeansObservables
					.observeValue(observableBean, field.name());
			fieldToObservableMap.put(field, beanObservableMaster);
			result = beanObservableMaster;
		}

		return result;
	}

	@Override
	public void bindControl(Control c, T f) {
		IObservableValue beanObservable = getObservableMasterValue(f);
		ISWTObservableValue observableTextControl = null;

		if (c instanceof Text) {
			observableTextControl = SWTObservables.observeText(c, SWT.Modify);
		} else if (c instanceof Button) {
			observableTextControl = SWTObservables.observeText(c);
		} else if (c instanceof Label) {
			observableTextControl = SWTObservables.observeText(c);
		}

		if (observableTextControl != null) {
			dbcCtx.bindValue(observableTextControl,
					beanObservable);
		}
		// otherwise no binding will take place

	}

	@Override
	public void bindFieldToPojoProperty(T f, Object pojo, String property) {
		IObservableValue beanObservableMaster = getObservableMasterValue(f);
		IObservableValue pojoObservable = PojoObservables.observeValue(pojo, property);

		dbcCtx.bindValue(pojoObservable	, beanObservableMaster);

	}

	@Override
	public void unbindFieldToPojoProperty(T f, Object bean, String property) {

		BindingTargetIterator i = new BindingTargetIterator(
				getBindings());
		while (i.hasNext()) {

			BindingObjectAssociation ba = i.next();
			IObservableValue o = ba.target;
			if (o instanceof BeanObservableValueDecorator) {
				BeanObservableValueDecorator beanDecorator = (BeanObservableValueDecorator) o;
				if (beanDecorator.getObserved().equals(bean)) {
					ba.binding.dispose();
				}

			}

		}
	}

	/**
	 * searches through the binding list and removes associated binding with the
	 * control
	 * 
	 * @param c
	 */
	@Override
	public void unbindControl(Control c) {
		List<Binding> removalList = new ArrayList<Binding>();
		List<Binding> bindings = getBindings();

		for (Binding binding : bindings) {
			IObservableList targets = binding.getTargets();

			for (Object target : targets) {
				if (target instanceof ISWTObservableValue) {
					ISWTObservableValue observableSWT = (ISWTObservableValue) target;
					Control control = (Control) observableSWT.getWidget();
					if (control.equals(c)) {
						removalList.add(binding);
					}

				}
			}

		}

		// remove the bindings
		for (Binding b : removalList) {
			dbcCtx.removeBinding(b);
		}

	}

}
