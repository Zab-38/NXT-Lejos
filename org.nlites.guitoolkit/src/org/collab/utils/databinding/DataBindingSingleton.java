package org.collab.utils.databinding;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.Realm;

public class DataBindingSingleton {

	private static DataBindingSingleton singleton;

	public static DataBindingSingleton singleton( ) {
		if( singleton == null ) {
			singleton = new DataBindingSingleton( );
		}
		return singleton;

	}

	private DataBindingContext dbc;

	private Realm realm;

	private DataBindingSingleton( ) {
		realm = Realm.getDefault( );
		dbc = new DataBindingContext( realm );
	}

	public DataBindingContext getDataBindingContext( ) {
		return dbc;
	}

}
