package org.collab.swt.utils;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.part.ViewPart;

/**
 * Standardized layouts and colour for GUI
 * 
 * @author Northern Lights
 * 
 */
public class NLitesStandardSWTFactory {
	/**
	 * Simple realm implementation that will set itself as default when
	 * constructed. Invoke {@link #dispose()} to remove the realm from being the
	 * default. Does not support asyncExec(...).
	 * 
	 * 
	 * Use this class for testing things like Databinding in a headless manner.
	 * When writing unit tests for observables or bindings it is difficult to
	 * set the default Realm without wrapping the test code in a Runnable and
	 * invoking Realm.runWithDefault(Realm realm, Runnable runnable). The
	 * following implementation can be used as a stub Realm for unit testing
	 * purposes and fits into the setUp() and tearDown() testing paradigm.
	 */
	

	public static class DefaultRealm extends Realm {
		private Realm previousRealm;

		public DefaultRealm( ) {
			previousRealm = super.setDefault( this );
		}

		/**
		 * @throws UnsupportedOperationException
		 */
		public void asyncExec( Runnable runnable ) {
			throw new UnsupportedOperationException( "asyncExec is unsupported" );
		}

		/**
		 * Removes the realm from being the current and sets the previous realm
		 * to the default.
		 */
		public void dispose( ) {
			if( getDefault( ) == this ) {
				setDefault( previousRealm );
			}
		}

		/**
		 * @return always returns true
		 */
		public boolean isCurrent( ) {
			return true;
		}

		protected void syncExec( Runnable runnable ) {
			runnable.run( );
		}
	}

	public static class TableColumnUtil {

		public static TableColumn buildColumn( TableViewer table, String text,
				int index, int width ) {
			TableColumn column = new TableColumn( table.getTable( ), SWT.NONE );
			column.setText( text );
			column.setMoveable( true );
			column.setWidth( width );
			return column;
		}
	}

	/**
	 * remember, creation of colors and fonts must be disposed! Since these are
	 * global, colors and fonts, it is acceptable that these do not get disposed
	 * until end of application life
	 */

	final public static Color blue = new Color( Display.getCurrent( ), new RGB(
			0, 0, 255 ) );
	public final static Color red = new Color( Display.getCurrent( ), new RGB(
			255, 0, 0 ) );
	public static Color listBlue = new Color( Display.getCurrent( ), new RGB(
			200, 200, 245 ) );

	final public static Color white = new Color( Display.getCurrent( ),
			new RGB( 255, 255, 255 ) );
	final private RGB whiteSmoke = new RGB( 245, 245, 245 );

	public static Color antiqueWhite = new Color( Display.getCurrent( ),
			new RGB( 250, 235, 215 ) );

	public static Color slateGray = new Color( Display.getCurrent( ), new RGB(
			198, 226, 255 ) );
	final public static Color green = new Color( Display.getCurrent( ),
			new RGB( 0, 255, 0 ) );
	public static Color mediumSpringGreen = new Color( Display.getCurrent( ),
			new RGB( 0, 250, 154 ) );

	public static Color limeGreen = new Color( Display.getCurrent( ), new RGB(
			0, 250, 154 ) );

	public static Color honeyDew = new Color( Display.getCurrent( ), new RGB(
			240, 255, 240 ) );

	public static Color kahki = new Color( Display.getCurrent( ), new RGB( 255,
			246, 143 ) );

	public static Color black = new Color( Display.getCurrent( ), new RGB( 0,
			0, 0 ) );

	public static Font standardFont = new Font( Display.getCurrent( ), "Arial",
			9, SWT.NORMAL );

	public static Font italicsFont = new Font( Display.getCurrent( ), "Arial",
			9, SWT.ITALIC );

	public static Composite createColoredBorderedCanvas( Composite composite,
			Color color ) {
		GridLayout gridLayout = new GridLayout( );
		composite.setLayout( gridLayout );
		composite.setBackground( color );
		return composite;
	}

	public static GridData createFilledGridData( ) {
		GridData gridData = new GridData( GridData.FILL_HORIZONTAL
				| GridData.GRAB_HORIZONTAL | GridData.FILL_VERTICAL
				| GridData.GRAB_VERTICAL );
		return gridData;
	}

	public static GridLayout createGridLayout( int numColumns ) {
		GridLayout gridLayout = new GridLayout( numColumns, false );
		gridLayout.horizontalSpacing = 0;
		gridLayout.marginHeight = 0;
		gridLayout.marginWidth = 0;
		gridLayout.marginLeft = 0;

		return gridLayout;
	}

	public static GridLayout createGridLayoutMargins( GridLayout layout,
			int width ) {
		layout.marginLeft = width;
		layout.marginHeight = width;
		layout.marginRight = width;
		layout.marginTop = width;
		return layout;
	}

	public static GridData createHorizontallyFilledGridData( ) {
		GridData gData = new GridData( GridData.FILL_HORIZONTAL
				| GridData.GRAB_HORIZONTAL );
		return gData;
	}
	
	public static GridData createHorizontalVerticalFilledGridData()
	{
		GridData gData = new GridData( GridData.FILL_HORIZONTAL | GridData.FILL_VERTICAL
				| GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL);
		return gData;

		
	}

	@SuppressWarnings( "rawtypes" )
	public static ImageRegistry createImageRegistry(
			Class<? extends Enum> clzzEnum ) throws ImageEnumException {
		ImageRegistry registry = new ImageRegistry( );

		Enum[] enums = clzzEnum.getEnumConstants( );

		for( Enum e: enums ) {
			if( e instanceof IEnumAssociatedFileName ) {
				ImageDescriptor d = ImageDescriptor.createFromFile( clzzEnum,
						((IEnumAssociatedFileName)e).getFilename( ) );
				registry.put( e.name( ), d );
			} else
				throw new ImageEnumException( "enum must implement "
						+ IEnumAssociatedFileName.class.getCanonicalName( ) );
		}

		return registry;

	}

	/**
	 * uses ArrayContentProvider as the default content provider. all you have
	 * to do is use {@link TableViewer}.setInput to set content
	 * 
	 * @param parent
	 * @return
	 */
	public static TableViewer createStandardSingleSelectTableViewer(
			Composite parent ) {
		TableViewer viewer = new TableViewer( parent, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.FULL_SELECTION );

		// this default content provider works in a large set of sitations. All
		// you have to provide
		// is the content through {TableViewer} set input
		viewer.setContentProvider( new ArrayContentProvider( ) );

		viewer.getTable( ).setHeaderVisible( true );

//		GridData gridData = createFilledGridData( );
//		viewer.getTable( ).setLayoutData( gridData );

		return viewer;
	}


	/**
	 * allows one to display an SWT form that is created via
	 * {@link INLitesTkFormFactory}
	 * 
	 * @param formFactory
	 */
	public static void viewForm( final INLitesTkFormFactory formFactory ) {

		DefaultRealm r = new DefaultRealm( );

		r.syncExec( new Runnable( ) {
			@Override
			public void run( ) {
				Display display = Display.getDefault( );
				Shell shell = new Shell( display );

				formFactory.createForm( shell );
				shell.open( );

				while( !shell.isDisposed( ) ) {
					if( !display.readAndDispatch( ) )
						display.sleep( );
				}
				// don't call display dispose if this method is called within an
				// RCP app, because the display is coming from the RCP app which
				// is still running (presumably)
				// display.dispose();

			}
		} );
	}

	public static void viewPopup( INLitesTkFormFactory formFactory, int x,
			int y, int width, int height ) {
		Display display = Display.getCurrent( );
		if( display == null )
			display = Display.getDefault( );
		final Shell s = new Shell( display, SWT.APPLICATION_MODAL | SWT.POP_UP );

		viewPopup( s, formFactory, x, y, width, height );

		while( !s.isDisposed( ) ) {
			if( !display.readAndDispatch( ) )
				display.sleep( );
		}

		// don't call display dispose if this method is called within an RCP
		// app, because the display is coming from the RCP app which is still
		// running (presumably)
		// display.dispose();

	}

	private static void viewPopup( final Shell shell,
			INLitesTkFormFactory formFactory, int x, int y, int width, int height ) {
		// if there is a custom listener add it to the shell
		if( formFactory instanceof ITraversalListenerGetter ) {

			ITraversalListenerGetter a = (ITraversalListenerGetter)formFactory;
			OkCancelListener listener = ((ITraversalListenerGetter)formFactory)
					.getOkCancelTraversalListener( );
			listener.setShell( shell );

			shell.addTraverseListener( a.getOkCancelTraversalListener( ) );
		} else {
			// default behaviour
			shell.addListener( SWT.Traverse, new Listener( ) {

				@Override
				public void handleEvent( Event event ) {
					switch( event.detail ) {
					case SWT.TRAVERSE_ESCAPE:
						shell.close( );
						event.detail = SWT.TRAVERSE_NONE;
						event.doit = false;
					break;

					case SWT.TRAVERSE_RETURN:

						shell.close( );
						event.detail = SWT.TRAVERSE_NONE;
						event.doit = true;
					break;
					}
				}
			} );

		}

		shell.setBounds( x, y, width, height );

		formFactory.createForm( shell );
		shell.open( );

	}

	public static void viewStandalonPop( final INLitesTkFormFactory formFactory,
			final int x, final int y, final int width, final int height ) {
		DefaultRealm r = new DefaultRealm( );
		r.syncExec( new Runnable( ) {
			@Override
			public void run( ) {
				Display display = Display.getDefault( );
				Shell shell = new Shell( display, SWT.APPLICATION_MODAL );

				viewPopup( shell, formFactory, x, y, width, height );

				while( !shell.isDisposed( ) ) {
					if( !display.readAndDispatch( ) )
						display.sleep( );
				}
				// don't call display dispose if this method is called within an
				// RCP app, because the display is coming from the RCP app which
				// is still running (presumably)
				// display.dispose();

			}
		} );

	}

	public static void viewViewPart( final ViewPart viewPart ) {

		DefaultRealm r = new DefaultRealm( );

		r.syncExec( new Runnable( ) {

			@Override
			public void run( ) {
				Display display = Display.getDefault( );
				Shell shell = new Shell( display );

				viewPart.createPartControl( shell );
				shell.open( );

				while( !shell.isDisposed( ) ) {
					if( !display.readAndDispatch( ) )
						display.sleep( );
				}

				// display.dispose();

			}
		} );
	}


}
