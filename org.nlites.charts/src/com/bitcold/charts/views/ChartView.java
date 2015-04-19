package com.bitcold.charts.views;

import org.collab.swt.utils.NLitesStandardSWTFactory;
import org.eclipse.birt.chart.model.Chart;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.nebula.visualization.widgets.figures.GaugeFigure;
import org.eclipse.nebula.visualization.widgets.figures.KnobFigure;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import com.bitcold.charts.ChartClient;
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
	private GaugeFigure guage;
	private KnobFigure knob;
	
	Image on;
	Image off;
	
	public void initImageResources(Composite parent)
	{
		on = new Image(parent.getDisplay(),  ChartClient.class.getResourceAsStream("idea.png"));
	    off = new Image(parent.getDisplay(),  ChartClient.class.getResourceAsStream("off.png"));
	}
    


	public KnobFigure getKnob() {
		return knob;
	}


	public GaugeFigure getGuage() {
		return guage;
	}


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
       initImageResources(parent);	
		buttonCmd1 = createButton(buttonCmd1, parent, "");
		buttonCmd1.setImage(off);
		buttonCmd1.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(getButtonCmd1().getSelection())
				{
					buttonCmd1.setImage(on);
					
				}
				else
				{
					buttonCmd1.setImage(off);
					
				}	
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				
			}
		});
		return buttonCmd1;
	}

	public Button getButtonCmd2(Composite parent) {
		
		buttonCmd2 = createButton(buttonCmd2, parent, "Laser Off");
		return buttonCmd2;
	}
	public Button getButtonCmd3(Composite parent) {
		buttonCmd3 = createButton(buttonCmd3, parent, "Command 3");
		return buttonCmd3;
	}
	
	public Button getButtonCmd4(Composite parent) {
		buttonCmd4 = createButton(buttonCmd4, parent, "&Terminate");
		return buttonCmd4;
	}
	
//	public ScaledSliderFigure getSlider1(Composite parent) {
//
//		Canvas canvas = new Canvas(parent, SWT.BORDER);
//		canvas.setBackground(NLitesStandardSWTFactory.listBlue);
//		GridData data =  new GridData();
//		data.heightHint = 75;
//		data.widthHint =  400;
//		canvas.setLayoutData(data);
//		
//		
//		LightweightSystem lws = new LightweightSystem(canvas);
//		
//		slider1 = new ScaledSliderFigure();
//		slider1.setRange((double) 0, (double)360);
//		slider1.setHorizontal(true);
//		slider1.setEffect3D(true);
//		slider1.setShowMarkers(false);
//		slider1.setMajorTickMarkStepHint(30);
//		slider1.setThumbColor(ColorConstants.gray);
//		lws.setContents(slider1);
//		return slider1;
//	}
	
	public GaugeFigure getGauge(Composite parent)
	{
		Canvas canvas = new Canvas(parent, SWT.BORDER);
		GridData data =  new GridData();
		data.heightHint = 150;
		data.widthHint =  150;
		canvas.setLayoutData(data);

		LightweightSystem lws = new LightweightSystem(canvas);
		guage = new GaugeFigure();
		lws.setContents(guage);
		return guage;
		
	}
	
	public KnobFigure getKnob(Composite parent)
	{
		Canvas canvas = new Canvas(parent, SWT.BORDER);
		GridData data =  new GridData();
		data.heightHint = 150;
		data.widthHint =  150;
		canvas.setLayoutData(data);
		LightweightSystem lws = new LightweightSystem(canvas);
		knob = new KnobFigure();
		knob.setRange(0, 360);
		lws.setContents(knob);
		return knob;
		
	}
	
	public void addKnobMouseListener(MouseListener l)
	{
		knob.addMouseListener(l);
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
		
		parent.setLayout(NLitesStandardSWTFactory.createGridLayout(2));
		Canvas leftCanvas = createLeftCanvas(parent);

		getKnob(leftCanvas);
		getGauge(leftCanvas);
		getButtonCmd1(leftCanvas);
		getButtonCmd2(leftCanvas);
		getButtonCmd3(leftCanvas);
		getButtonCmd4(leftCanvas);
		
		
		
		GridData gdata  = NLitesStandardSWTFactory.createFilledGridData();
		
		chartControl = new ChartControl(parent, SWT.None);
		chartControl.setVisible(true);
		chartControl.setLayoutData(gdata);
		chartControl.setCm(chart);
		
	}
	
	public Canvas createLeftCanvas(Composite parent)
	{
		
		Canvas leftCanvas = new Canvas(parent,SWT.None);
		leftCanvas.setBackground(NLitesStandardSWTFactory.honeyDew);
		GridData data = new  GridData(SWT.BEGINNING, SWT.BEGINNING, false, true);
		data.widthHint = 150;
		data.grabExcessVerticalSpace= true;
		leftCanvas.setLayoutData(data);
		leftCanvas.setLayout(NLitesStandardSWTFactory.createGridLayout(1));
		return leftCanvas;
		
	}


	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}
	
	
	private Button createButton(Button button, Composite parent, String text)
	{
		if(button ==null) 
			{
			button = new Button(parent, SWT.TOGGLE);
			button.setText(text);
			GridData gd = new GridData(150,150);
			button.setLayoutData(gd);
			
			}
		return button;
		
	}
 


}