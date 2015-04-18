package org.collab.utils.observerpattern;

public interface IObservable<T, O extends Observer<T>> {

	/**
	 * Adds an observer to the set of observers for this object, provided that
	 * it is not the same as some observer already in the set. The order in
	 * which notifications will be delivered to multiple observers is not
	 * specified. See the class comment.
	 * 
	 * @param o
	 *            an observer to be added.
	 * @throws NullPointerException
	 *             if the parameter o is null.
	 */
	public abstract void addObserver( O o );

	/**
	 * Deletes an observer from the set of observers of this object. Passing
	 * <CODE>null</CODE> to this method will have no effect.
	 * 
	 * @param o
	 *            the observer to be deleted.
	 */
	@SuppressWarnings( "unchecked" )
	public abstract void deleteObserver( Observer o );

}
