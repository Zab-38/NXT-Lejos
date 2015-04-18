package com.bitcold.charts;

import org.collab.swt.utils.NLitesStandardSWTFactory;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

import com.bitcold.charts.views.ChartModule;
import com.bitcold.charts.views.ChartView;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class ChartClient {

	public static void main(String[] args) {
		Injector i = Guice.createInjector(new ChartModule());
		
		ChartView chartView = i.getInstance(ChartView.class);
		NLitesStandardSWTFactory.viewViewPart(chartView);
		
	}
}
