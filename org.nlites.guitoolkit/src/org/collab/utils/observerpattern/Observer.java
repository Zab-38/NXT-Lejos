package org.collab.utils.observerpattern;

/**
 * T is the type of the Observable
 * 
 * @author Arnold Kim
 * 
 *         9-May-2005
 * 
 */

public interface Observer<T> {
	public void notifyMe( T o );

}
