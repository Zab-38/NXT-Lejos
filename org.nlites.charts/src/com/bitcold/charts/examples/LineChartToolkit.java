package com.bitcold.charts.examples;

import org.eclipse.birt.chart.model.Chart;
import org.eclipse.birt.chart.model.ChartWithAxes;
import org.eclipse.birt.chart.model.attribute.AxisType;
import org.eclipse.birt.chart.model.attribute.IntersectionType;
import org.eclipse.birt.chart.model.attribute.Marker;
import org.eclipse.birt.chart.model.attribute.MarkerType;
import org.eclipse.birt.chart.model.attribute.TickStyle;
import org.eclipse.birt.chart.model.attribute.impl.ColorDefinitionImpl;
import org.eclipse.birt.chart.model.component.Axis;
import org.eclipse.birt.chart.model.component.Series;
import org.eclipse.birt.chart.model.component.impl.SeriesImpl;
import org.eclipse.birt.chart.model.data.NumberDataSet;
import org.eclipse.birt.chart.model.data.SeriesDefinition;
import org.eclipse.birt.chart.model.data.TextDataSet;
import org.eclipse.birt.chart.model.data.impl.NumberDataElementImpl;
import org.eclipse.birt.chart.model.data.impl.NumberDataSetImpl;
import org.eclipse.birt.chart.model.data.impl.SeriesDefinitionImpl;
import org.eclipse.birt.chart.model.data.impl.TextDataSetImpl;
import org.eclipse.birt.chart.model.impl.ChartWithAxesImpl;
import org.eclipse.birt.chart.model.layout.Plot;
import org.eclipse.birt.chart.model.type.BarSeries;
import org.eclipse.birt.chart.model.type.LineSeries;
import org.eclipse.birt.chart.model.type.impl.BarSeriesImpl;
import org.eclipse.birt.chart.model.type.impl.LineSeriesImpl;

import com.bitcold.charts.tookit.CategoryValue;
import com.bitcold.charts.tookit.DataCoordinates;

public class LineChartToolkit {
	ChartWithAxes cwaLine = ChartWithAxesImpl.create( );

	public ChartWithAxes getLineChart() {
		return cwaLine;
	}

	Axis xAxisPrimary;
	Axis yAxisPrimary;
	
	public LineChartToolkit(CategoryValue cv) {
		createLineChart();
		
		createDataset(cv);
	}
	public static final Chart createBarChartDataPoints( )
	{
		ChartWithAxes cwaBar = ChartWithAxesImpl.create( );
		cwaBar.setScript( "org.eclipse.birt.chart.examples.api.script.java.DataPointsScript" );//$NON-NLS-1$

		// X-Axis
		Axis xAxisPrimary = cwaBar.getPrimaryBaseAxes( )[0];
		xAxisPrimary.setType( AxisType.TEXT_LITERAL );
		xAxisPrimary.getOrigin( ).setType( IntersectionType.VALUE_LITERAL );

		// Y-Axis
		Axis yAxisPrimary = cwaBar.getPrimaryOrthogonalAxis( xAxisPrimary );
		yAxisPrimary.getMajorGrid( ).setTickStyle( TickStyle.LEFT_LITERAL );
		yAxisPrimary.setType( AxisType.LINEAR_LITERAL );

		// Data Set
		TextDataSet categoryValues = TextDataSetImpl.create( new String[]{
				"Item 1", "Item 2", "Item 3"} ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		NumberDataSet orthoValues = NumberDataSetImpl.create( new double[]{
				8, 18, -15
		} );

		// X-Series
		Series seCategory = SeriesImpl.create( );
		seCategory.setDataSet( categoryValues );

		SeriesDefinition sdX = SeriesDefinitionImpl.create( );
		xAxisPrimary.getSeriesDefinitions( ).add( sdX );
		sdX.getSeries( ).add( seCategory );

		// Y-Series
		BarSeries bs = (BarSeries) BarSeriesImpl.create( );
		bs.setDataSet( orthoValues );
		bs.getLabel( ).setVisible( true );

		SeriesDefinition sdY = SeriesDefinitionImpl.create( );
		yAxisPrimary.getSeriesDefinitions( ).add( sdY );
		sdY.getSeries( ).add( bs );

		return cwaBar;
	}

	public final Chart createLineChart( )
	{

		// Plot
		cwaLine.getBlock( ).setBackground( ColorDefinitionImpl.CREAM() );
		Plot p = cwaLine.getPlot( );
		p.getClientArea( ).setBackground( ColorDefinitionImpl.create( 255,
				255,
				225 ) );

		// Title
		cwaLine.getTitle( ).getLabel( ).getCaption( ).setValue( "Science Fair 2015" );//$NON-NLS-1$

		// Legend
		cwaLine.getLegend( ).setVisible( false );

		// X-Axis
		xAxisPrimary= cwaLine.getPrimaryBaseAxes( )[0];
		xAxisPrimary.setType( AxisType.TEXT_LITERAL);
		xAxisPrimary.getOrigin( ).setType( IntersectionType.VALUE_LITERAL );
		xAxisPrimary.getOrigin().setValue(NumberDataElementImpl.create(0));

//		xAxisPrimary.getMajorGrid( ).setTickStyle( TickStyle.BELOW_LITERAL );
		xAxisPrimary.getTitle( ).setVisible( true );
		

		// Y-Axis
		yAxisPrimary = cwaLine.getPrimaryOrthogonalAxis( xAxisPrimary );
		yAxisPrimary.setType(AxisType.LINEAR_LITERAL);
		yAxisPrimary.getOrigin( ).setType( IntersectionType.VALUE_LITERAL );
		yAxisPrimary.getOrigin().setValue(NumberDataElementImpl.create(20));
		
		
		yAxisPrimary.getMajorGrid( ).setTickStyle( TickStyle.LEFT_LITERAL );

		return cwaLine;
	}
	
	
	private void createDataset(CategoryValue coords)
	{
		
		// Data Set
//		TextDataSet categoryValues = TextDataSetImpl.create( new String[]{
//				"Item 1", "Item 2", "Item 3"} );//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//		NumberDataSet orthoValues = NumberDataSetImpl.create( new double[]{
//				25, 35, 15
//		} );

		
		// Data Set
		TextDataSet categoryValues = TextDataSetImpl.create(coords.getCategories());//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		NumberDataSet orthoValues = NumberDataSetImpl.create( coords.getValues());
		
		// Data Set
//		NumberDataSet categoryValues = NumberDataSetImpl.create(coords.getXs());//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//		NumberDataSet orthoValues = NumberDataSetImpl.create( coords.getYs());
		
		

		// X-Series
		Series seCategory = SeriesImpl.create( );
		seCategory.setDataSet( categoryValues );
		SeriesDefinition sdX = SeriesDefinitionImpl.create( );

		xAxisPrimary.getSeriesDefinitions( ).add( sdX );
		sdX.getSeries( ).add( seCategory );

		// Y-Sereis
		LineSeries ls = (LineSeries) LineSeriesImpl.create( );
		ls.setDataSet( orthoValues );
		ls.getLineAttributes( ).setColor( ColorDefinitionImpl.CREAM( ) );
		for ( int i = 0; i < ls.getMarkers( ).size( ); i++ )
		{
			( (Marker) ls.getMarkers( ).get( i ) ).setType( MarkerType.CROSS_LITERAL);
		}
		ls.getLabel( ).setVisible( true );

		SeriesDefinition sdY = SeriesDefinitionImpl.create( );
		sdY.getSeriesPalette( ).shift( -2 );
		yAxisPrimary.getSeriesDefinitions( ).add( sdY );
		sdY.getSeries( ).add( ls );
	}
	
	
	
	
	
	
	public static final Chart createLineChart1(String title )
	{
		ChartWithAxes cwaLine = ChartWithAxesImpl.create( );

		// Plot
		cwaLine.getBlock( ).setBackground( ColorDefinitionImpl.WHITE( ) );
		Plot p = cwaLine.getPlot( );
		p.getClientArea( ).setBackground( ColorDefinitionImpl.create( 255,
				255,
				225 ) );

		// Title
		cwaLine.getTitle( ).getLabel( ).getCaption( ).setValue( title );//$NON-NLS-1$

		// Legend
		cwaLine.getLegend( ).setVisible( false );

		// X-Axis
		Axis xAxisPrimary = cwaLine.getPrimaryBaseAxes( )[0];
		xAxisPrimary.setType( AxisType.TEXT_LITERAL );
		xAxisPrimary.getMajorGrid( ).setTickStyle( TickStyle.BELOW_LITERAL );
		xAxisPrimary.getTitle( ).setVisible( true );

		// Y-Axis
		Axis yAxisPrimary = cwaLine.getPrimaryOrthogonalAxis( xAxisPrimary );
		yAxisPrimary.getMajorGrid( ).setTickStyle( TickStyle.LEFT_LITERAL );

		// Data Set
		TextDataSet categoryValues = TextDataSetImpl.create( new String[]{
				"Item 1", "Item 2", "Item 3"} );//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		NumberDataSet orthoValues = NumberDataSetImpl.create( new double[]{
				25, 35, 15
		} );

		// X-Series
		Series seCategory = SeriesImpl.create( );
		seCategory.setDataSet( categoryValues );
		SeriesDefinition sdX = SeriesDefinitionImpl.create( );

		xAxisPrimary.getSeriesDefinitions( ).add( sdX );
		sdX.getSeries( ).add( seCategory );

		// Y-Sereis
		LineSeries ls = (LineSeries) LineSeriesImpl.create( );
		ls.setDataSet( orthoValues );
		ls.getLineAttributes( ).setColor( ColorDefinitionImpl.CREAM( ) );
		for ( int i = 0; i < ls.getMarkers( ).size( ); i++ )
		{
			( (Marker) ls.getMarkers( ).get( i ) ).setType( MarkerType.CIRCLE_LITERAL);
		}
		ls.getLabel( ).setVisible( true );

		SeriesDefinition sdY = SeriesDefinitionImpl.create( );
		sdY.getSeriesPalette( ).shift( -2 );
		yAxisPrimary.getSeriesDefinitions( ).add( sdY );
		sdY.getSeries( ).add( ls );

		return cwaLine;
		
	}
	
	public static void setChartModelData(ChartWithAxes chart,DataCoordinates<String,Double> coodinates) 
	{
		//set up data sets
		NumberDataSet orthoVals = NumberDataSetImpl.create(coodinates.getListy().toArray());
		TextDataSet xVals =  TextDataSetImpl.create(coodinates.getListx().toArray());
		
		
		// X-Axis
		Axis xAxisPrimary = chart.getPrimaryBaseAxes( )[0];
		xAxisPrimary.setType( AxisType.TEXT_LITERAL );
		xAxisPrimary.getMajorGrid( ).setTickStyle( TickStyle.BELOW_LITERAL );
		xAxisPrimary.getTitle( ).setVisible( true );

		
		// Y-Axis
		Axis yAxisPrimary = chart.getPrimaryOrthogonalAxis( xAxisPrimary );
		yAxisPrimary.getMajorGrid( ).setTickStyle( TickStyle.LEFT_LITERAL );

		
		
		// X-Series
		Series xSeries = SeriesImpl.create( );
		xSeries.setDataSet( xVals );
		SeriesDefinition sdX = SeriesDefinitionImpl.create( );

		xAxisPrimary.getSeriesDefinitions( ).add( sdX );
		sdX.getSeries().clear();
		sdX.getSeries( ).add( xSeries );

		// Y-Sereis
		LineSeries ls = (LineSeries) LineSeriesImpl.create( );
		ls.setDataSet( orthoVals );
		ls.getLineAttributes( ).setColor( ColorDefinitionImpl.CREAM( ) );
		for ( int i = 0; i < ls.getMarkers( ).size( ); i++ )
		{
			( (Marker) ls.getMarkers( ).get( i ) ).setType( MarkerType.CIRCLE_LITERAL);
		}
		ls.getLabel( ).setVisible( true );

		SeriesDefinition sdY = SeriesDefinitionImpl.create( );
		sdY.getSeriesPalette( ).shift( -2 );
		yAxisPrimary.getSeriesDefinitions().clear();
		yAxisPrimary.getSeriesDefinitions( ).add( sdY );
		sdY.getSeries( ).add( ls );
		
		
	}
	

}
