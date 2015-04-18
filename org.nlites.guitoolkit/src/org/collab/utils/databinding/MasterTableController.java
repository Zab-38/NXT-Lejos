package org.collab.utils.databinding;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;

import org.collab.tableutils.IColumnAttributes;
import org.collab.tableutils.TableColumnFactory;
import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.IViewerObservableValue;
import org.eclipse.jface.databinding.viewers.ViewerSupport;
import org.eclipse.jface.databinding.viewers.ViewersObservables;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import com.google.inject.Inject;
import org.apache.commons.beanutils.*;

/**
 * 
 * @author docere
 * 
 * @param <U>
 *            PropertyChangeSupport
 * @param <T>
 *            EnumType
 */
public class MasterTableController<U extends IPropertyChangeSupport, T extends Enum<T>> implements IObservableMasterValue<U, T> {

	private TableViewer tableView;

	// map of TableViewerColumns
	private EnumMap<T, TableViewerColumn> enumColumnMap;

	// contentList of master table
	protected WritableList contentList;

	// list of created bindings, this is useful in order to remove the bindings
	// on dispose
	List<Binding> createdBindings = new ArrayList<Binding>( );

	// map of observable fields from an observable row as represented by
	// tableSelectionDataInstance/
	protected HashMap<T, IObservableValue> masterObservableMap =  new HashMap<T, IObservableValue>( );

	// original selected data object
	// used to extract type information for a given property name

	// original selected dataobject wrapped to be observable
	protected IViewerObservableValue masterObservableTableSelection = null;

	public MasterTableController()
	{
		
	}
	

	
	/************************
	 * injected fields
	 */
	
	protected U model;

	protected T[] enumsForFields;

	@Inject
	private DataBindingContext dbcCtx;
	

	/**
	 * instance of data
	 * 
	 * Important Note: Constructor Injections will be called FIRST, so if  behaviour is predicated on the state of injected objects
	 * (particularly that they cannot be null,  put those injected objects in the constructor
	 * 
	 * @param model
	 */
	@Inject
	public MasterTableController(U model, ArrayList<U> _tempList, T fieldEnum) {
		this.model = model;
		this.enumsForFields = fieldEnum.getDeclaringClass().getEnumConstants().clone();
		setContentList(_tempList);
	}

	protected void addItem( U newItem ) {
		U selection = getSelection( );

		WritableList list = getObservableList( );
		int index = 0;

		if( selection != null ) {
			index = list.indexOf( selection );
		} else
			index = list.size( );

		list.add( index, newItem );

		getMasterObservableTableSelection( ).setValue( newItem );
	}

	public void bindControl( Control c, T f ) {
		IObservableValue beanObservable = getDetailObservable( f );
		ISWTObservableValue observableTextControl = null;

		if( c instanceof Text ) {
			observableTextControl = SWTObservables.observeText( c, SWT.Modify );
		} else if( c instanceof Button ) {
			observableTextControl = SWTObservables.observeText( c );
		} else if( c instanceof Label ) {
			observableTextControl = SWTObservables.observeText( c );
		}

		if( observableTextControl != null ) {
			Binding binding = dbcCtx.bindValue( observableTextControl,
					beanObservable );
			createdBindings.add( binding );
		}
		// otherwise no binding will take place
	}

	public void bindFieldToPojoProperty( T f, Object bean,
			String property ) {
		IObservableValue beanObservable = getDetailObservable( f );
		IObservableValue observable = PojoObservables.observeValue( bean,
				property );
		Binding binding = dbcCtx.bindValue( beanObservable, observable );
		createdBindings.add( binding );
	}

	public void dispose( ) {
		for( Binding b: createdBindings ) {
			dbcCtx.removeBinding( b );
		}
		masterObservableMap.clear( );
	}

	/**
	 * accesses the associated TableViewerColumn for a given field as keyed by
	 * it's enum value
	 * 
	 * use this to customize Fonts, Labels etc
	 * 
	 * @param enumKey
	 * @return
	 */

	public TableViewerColumn getColumnTableViewer( T enumKey ) {
		return enumColumnMap.get( enumKey );
	}

	/**
	 * although one can use the oiginal databinding context to record all
	 * bindings, this list is focused on bindings created within this particular
	 * controller
	 * 
	 * @return
	 */
	public List<Binding> getCreatedBindings( ) {
		return createdBindings;
	}

	public DataBindingContext getDbcCtx( ) {
		return dbcCtx;
	}

	@Override
	public IObservableValue getObservableMasterValue(T field) {
		return masterObservableTableSelection;
	}
	protected IViewerObservableValue getMasterObservableTableSelection( ) {
		return masterObservableTableSelection;
	}

	/**
	 * 
	 * @param f
	 * @return
	 */

	
	private IObservableValue getDetailObservable( T f ) {
		IObservableValue value = masterObservableMap.get( f );
		Class<?> clzz = null;

		if( value == null ) {

			try {
				clzz = PropertyUtils.getPropertyType(
						model, f.name( ) );
			} catch( IllegalAccessException e ) {
				e.printStackTrace( );
			} catch( InvocationTargetException e ) {
				e.printStackTrace( );
			} catch( NoSuchMethodException e ) {
				e.printStackTrace( );
			}
			value = BeansObservables.observeDetailValue(
					masterObservableTableSelection, f.name( ), clzz );

			masterObservableMap.put( f, value );
		}

		return value;
	}

	protected HashMap<T, IObservableValue> getDetailObservableMap( ) {
		return masterObservableMap;
	}


	public TableViewer getMasterTableViewer( ) {
		return tableView;
	}

	public WritableList getObservableList( ) {
		return contentList;
	}

	@SuppressWarnings( "unchecked" )
	public U getSelection( ) {
		if(masterObservableTableSelection==null)return null;
		return (U)masterObservableTableSelection.getValue( );
	}

	protected void removeSelection( ) {
		U selection = getSelection( );

		if( selection != null ) {
			WritableList list = getObservableList( );
			int index = list.indexOf( selection );
			list.remove( selection );
			if( list.size( ) > 0 && index < list.size( ) ) {
				getMasterObservableTableSelection( )
						.setValue( list.get( index ) );
			}
		}
	}

	private void setContentList(List<U>  list) {
		Class<U> clzz= (Class<U>)model.getClass( );
		this.contentList = new WritableList( list, clzz );
	}

	/**
	 * set the master table viewer
	 * 
	 * @param v
	 */
	public void setMasterTableViewer( TableViewer v ) {
		tableView = v;
		masterObservableTableSelection = ViewersObservables
				.observeSingleSelection( v );

		// temp map that gets decorated with an EnumMap for maximum optimization
		HashMap<T, TableViewerColumn> map = new HashMap<T, TableViewerColumn>( );

		ArrayList<String> list = new ArrayList<String>( );
		TableColumnFactory columnFactory = new TableColumnFactory( tableView );

		for( T f: enumsForFields ) {
			if( f instanceof IColumnAttributes ) {
				IColumnAttributes columnAttribute = (IColumnAttributes)f;
				TableViewerColumn col = columnFactory
						.createTableColumn( columnAttribute.getLabel( ),
								columnAttribute.getWidth( ) );
				map.put( f, col );
			}
			list.add( f.name( ) );
		}

		// decorating the temporary hashmap
		enumColumnMap = new EnumMap<T, TableViewerColumn>( map );

		ViewerSupport.bind( tableView, contentList, BeanProperties.values( list
				.toArray( new String[list.size( )] ) ) );
	}

	public void setSelection( U data ) {
		masterObservableTableSelection.setValue( data );
	}

	/**
	 * searches through the binding list and removes associated binding with
	 * the control
	 * 
	 * @param c
	 */
	public void unbindControl( Control c ) {
		List<Binding> removalList = new ArrayList<Binding>( );

		for( Binding binding: createdBindings ) {
			IObservableList targets = binding.getTargets( );

			for( Object target: targets ) {
				if( target instanceof ISWTObservableValue ) {
					ISWTObservableValue observableSWT = (ISWTObservableValue)target;
					Control control = (Control)observableSWT.getWidget( );
					if( control.equals( c ) ) {
						removalList.add( binding );
					}

				}
			}

		}

		// remove the bindings
		for( Binding b: removalList ) {
			dbcCtx.removeBinding( b );
			this.createdBindings.remove( b );

		}

	}

	@Override
	public void unbindFieldToPojoProperty(T f, Object bean, String property) {
		// TODO unbindFieldToPojoProperty has not been completed for a while. Is this necessary?
		
	}


}
