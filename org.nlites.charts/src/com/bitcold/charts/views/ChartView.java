package com.bitcold.charts.views;


import org.collab.swt.utils.NLitesStandardSWTFactory;
import org.eclipse.birt.chart.model.Chart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import com.bitcold.charts.widget.ChartControl;
import com.google.inject.Inject;
/**
 * 
 * @author NLites
 *
 */

public class ChartView extends ViewPart{
	public static final String ID = "com.bitcold.charts";


	private ChartControl chartControl;
	private Button buttonCmd1;
	
	public Button getButtonCmd1() {
		return buttonCmd1;
	}

	public Button getButtonCmd2() {
		return buttonCmd2;
	}

	public Button getButtonCmd3() {
		return buttonCmd3;
	}

	public Button getButtonCmd4() {
		return buttonCmd4;
	}



	private Button buttonCmd2;
	
	private Button buttonCmd3;


	private Button buttonCmd4;





	public Button getButtonCmd1(Composite parent) {
		createButton(buttonCmd1, parent, "Command 1");
		return buttonCmd1;
	}

	public Button getButtonCmd2(Composite parent) {
		
		createButton(buttonCmd2, parent, "Command 2");
		return buttonCmd2;
	}
	public Button getButtonCmd3(Composite parent) {
		createButton(buttonCmd3, parent, "Command 3");
		return buttonCmd3;
	}
	
	public Button getButtonCmd4(Composite parent) {
		createButton(buttonCmd4, parent, "Command 4");
		return buttonCmd4;
	}
	
	

	@Inject
	private Chart chart; 

	public ChartView() {
		super();
	}


	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		parent.setLayout(layout);

		getButtonCmd1(parent);
		getButtonCmd2(parent);
		getButtonCmd3(parent);
		
		
		
		GridData gdata  = NLitesStandardSWTFactory.createFilledGridData();
		
		chartControl = new ChartControl(parent, SWT.None);
		chartControl.setVisible(true);
		chartControl.setLayoutData(gdata);
		chartControl.setCm(chart);
		
	}


	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}
	
	
	private Button createButton(Button button, Composite parent, String text)
	{
		if(button ==null) 
			{
			button = new Button(parent, SWT.None);
			button.setText(text);
			
			}
		return button;
		
	}
 


}