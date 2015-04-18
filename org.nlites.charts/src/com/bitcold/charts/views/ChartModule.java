package com.bitcold.charts.views;

import org.eclipse.birt.chart.model.Chart;
import com.bitcold.charts.examples.LineChartToolkit;
import com.bitcold.charts.tookit.CategoryValue;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class ChartModule extends AbstractModule {

	@Override
	protected void configure() {
		// TODO Auto-generated method stub

	}

	
	private double f(double x)
	{
		return x*x;
	}
	
	
	@Provides
	Chart provideChart() {
		Chart chart = null; 
		CategoryValue cv = new CategoryValue();
		for (double x = -10; x < 10; x += 0.5) {
			cv.add(Double.toString(x), f(x));
		}

		LineChartToolkit lineChartKit = new LineChartToolkit(cv);
		

		chart = lineChartKit.getLineChart();
//		chart = lineChartKit.createJChart_DataPoints();
		return chart;
	}
}
