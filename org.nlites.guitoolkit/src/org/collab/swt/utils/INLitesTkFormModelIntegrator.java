package org.collab.swt.utils;

/**
 * T is the type of the model
 * 
 * @author Northern Lights
 * 
 * @param <T>
 */
public interface INLitesTkFormModelIntegrator<T> {

	public void setModel( T model );

	public void updateForm( );

}
