package org.collab.utils.databinding;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.observable.value.IObservableValue;

public class BindingTargetIterator implements
		Iterator<BindingTargetIterator.BindingObjectAssociation> {
	
	public class BindingObjectAssociation
	{
		Binding binding;
		public Binding getBinding() {
			return binding;
		}
		IObservableValue target;
		public IObservableValue getTarget() {
			return target;
		}
	}
	
	private Binding currentBinding;
	private Iterator<Binding> i;
	private Iterator<IObservableValue> targetsIterator;

	private IObservableValue next = null;
	private boolean hasNext = false;

	private boolean nextTargetIterator() {
		if (targetsIterator == null) {
			if (i.hasNext()) {
				getNextBinding();
				targetsIterator =  currentBinding.getTargets().iterator();
				return true;
			} else
				return false;
		} else if (targetsIterator.hasNext()) {
			getNextBinding();
			targetsIterator = currentBinding.getTargets().iterator();
			return true;
		} else
			return false;
	}
	
	private void getNextBinding()
	{
		currentBinding = i.next();
	}

	private void loadNext() {
		next = (IObservableValue) targetsIterator.next();
		hasNext = true;

	}

	private void determineNext() {

		if (targetsIterator == null) {
			boolean success = nextTargetIterator();
			if (success) {
				loadNext();
			}
		} else if (targetsIterator.hasNext()) {
			loadNext();
		} else if (nextTargetIterator()) {
			loadNext();
		} else {
			hasNext = false;
			next = null;
		}
	}

	public BindingTargetIterator(List<Binding> bindings) {
		i = bindings.iterator();
		determineNext();
	}

	@Override
	public boolean hasNext() {
		return hasNext;

	}

	@Override
	public BindingTargetIterator.BindingObjectAssociation next() {

		if (hasNext)
		{
			BindingObjectAssociation ba = new BindingObjectAssociation();
			ba.binding = currentBinding;
			ba.target = next;
			
			determineNext();
			return ba;
		}
			
		else {
			throw new NoSuchElementException();
		}

	}

	@Override
	public void remove() {

	}

	@Override
	public void forEachRemaining(
			Consumer<? super BindingObjectAssociation> action) {
        Objects.requireNonNull(action);
        while (hasNext())
            action.accept(next());
		
	}


}
