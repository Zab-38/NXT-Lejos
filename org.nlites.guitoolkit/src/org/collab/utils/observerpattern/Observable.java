package org.collab.utils.observerpattern;

import java.util.Vector;

/**
 * 
 * aggregate this class into an Object that is to be observed by a list of
 * observers T is the type of the Observable O is the type of the Observer
 * 
 * @author Arnold Kim
 * 
 *         9-May-2005
 * 
 * 
 */
public class Observable<T, O extends Observer<T>> {

	private T observable = null;
	private boolean changed = false;
	private Vector<O> obs;

	/** Construct an Observable with zero Observers. */

	public Observable( T observable ) {
		obs = new Vector<O>( );
		this.observable = observable;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.mdnights.utils.observerpattern.IObservablea#addObserver(O)
	 */
	public synchronized void addObserver( O o ) {
		if( o == null )
			throw new NullPointerException( );
		if( !obs.contains( o ) ) {
			obs.addElement( o );
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.mdnights.utils.observerpattern.IObservablea#clearChanged()
	 */
	public synchronized void clearChanged( ) {
		changed = false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.mdnights.utils.observerpattern.IObservablea#countObservers()
	 */
	public synchronized int countObservers( ) {
		return obs.size( );
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.mdnights.utils.observerpattern.IObservablea#deleteObserver(net.mdnights
	 * .utils.observerpattern.Observer)
	 */
	@SuppressWarnings( "unchecked" )
	public synchronized void deleteObserver( Observer o ) {
		obs.removeElement( o );
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.mdnights.utils.observerpattern.IObservablea#deleteObservers()
	 */
	public synchronized void deleteObservers( ) {
		obs.removeAllElements( );
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.mdnights.utils.observerpattern.IObservablea#hasChanged()
	 */
	public synchronized boolean hasChanged( ) {
		return changed;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.mdnights.utils.observerpattern.IObservablea#notifyObservers()
	 */
	public void notifyObservers( ) {
		notifyObservers( null );
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.mdnights.utils.observerpattern.IObservablea#notifyObservers(java.
	 * lang.Object)
	 */
	public void notifyObservers( Object arg ) {
		/*
		 * a temporary array buffer, used as a snapshot of the state of current
		 * Observers.
		 */

		synchronized( this ) {
			/*
			 * We don't want the Observer doing callbacks into arbitrary code
			 * while holding its own Monitor. The code where we extract each
			 * Observable from the Vector and store the state of the Observer
			 * needs synchronization, but notifying observers does not (should
			 * not). The worst result of any potential race-condition here is
			 * that: 1) a newly-added Observer will miss a notification in
			 * progress 2) a recently unregistered Observer will be wrongly
			 * notified when it doesn't care
			 */
			if( !changed )
				return;

			clearChanged( );
		}

		for( O o: obs ) {
			o.notifyMe( observable );
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.mdnights.utils.observerpattern.IObservablea#setChanged()
	 */
	public synchronized void setChanged( ) {
		changed = true;
	}

}
