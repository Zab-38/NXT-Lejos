package org.collab.utils.databinding;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

/**
 * Forms the base class of all databinding modules for common requirements such
 * as text formatting and and the provision of a a single DataBindingContext
 */

public abstract class DataBindingModule extends AbstractModule {
	private NumberFormat currencyFormat = new DecimalFormat( "$#,##0.00" );

	public DataBindingModule( ) {
		super( );
	}

//	@Provides
//	private DataBindingContext provideDataBindingContext( ) {
//		return DataBindingSingleton.singleton( ).getDataBindingContext( );
//	}

	@Provides
	private DecimalFormat providesCurrencyFormat( ) {
		return (DecimalFormat)currencyFormat;
	}

}
