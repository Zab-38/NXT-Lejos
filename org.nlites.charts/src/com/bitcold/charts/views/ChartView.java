package com.bitcold.charts.views;

import org.collab.swt.utils.NLitesStandardSWTFactory;
import org.eclipse.birt.chart.model.Chart;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.MouseEvent;
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

public class ChartView extends ViewPart {
	public static final String ID = "com.bitcold.charts";

	private int widthHeight = 120;
	private ChartControl chartControl;
	private Button buttonCmd1;
	private KnobFigure knob1;
	private KnobFigure knob2;
	private KnobFigure knob3;

	Image on;
	Image off;

	private GaugeFigure gauge;

	public void initImageResources(Composite parent) {
		on = new Image(parent.getDisplay(),
				ChartClient.class.getResourceAsStream("idea.png"));
		off = new Image(parent.getDisplay(),
				ChartClient.class.getResourceAsStream("off.png"));
	}

	public KnobFigure getKnob1() {
		return knob1;
	}

	public GaugeFigure getGuage() {
		return gauge;
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

	public Button getButtonCmd5() {
		return buttonCmd5;
	}

	public Button getButtonCmd6() {
		return buttonCmd6;
	}

	public Button getButtonCmd7() {
		return buttonCmd7;
	}

	public Button getButtonCmd8() {
		return buttonCmd8;
	}

	public Button getButtonCmd9() {
		return buttonCmd9;
	}

	public Button getButtonCmd10() {
		return buttonCmd10;
	}

	private Button buttonCmd2;

	private Button buttonCmd3;

	private Button buttonCmd4;

	private Button buttonCmd5;

	private Button buttonCmd6;

	private Button buttonCmd7;

	private Button buttonCmd8;

	private Button buttonCmd9;

	private Button buttonCmd10;


	public Button getButtonLaserOnOff(Composite parent) {
		initImageResources(parent);
		buttonCmd1 = createButton(buttonCmd1, parent, "");
		buttonCmd1.setImage(off);
		GridData gd = new GridData(widthHeight, widthHeight);
		buttonCmd1.setLayoutData(gd);

		buttonCmd1.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (getButtonCmd1().getSelection()) {
					buttonCmd1.setImage(on);

				} else {
					buttonCmd1.setImage(off);

				}

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {

			}
		});
		return buttonCmd1;
	}

	public Button getButtonA180(Composite parent) {

		buttonCmd2 = createButton(buttonCmd2, parent, "M180A");
		return buttonCmd2;
	}

	public Button getButtonCmd3(Composite parent) {
		buttonCmd3 = createButton(buttonCmd3, parent, "M90A");
		return buttonCmd3;
	}

	public Button getButtonCmd4(Composite parent) {
		buttonCmd4 = createButton(buttonCmd4, parent, "M180B");
		return buttonCmd4;
	}

	public Button getButtonCmd5(Composite parent) {
		buttonCmd5 = createButton(buttonCmd5, parent, "M90B");
		return buttonCmd5;
	}

	public Button getButtonCmd6(Composite parent) {
		buttonCmd6 = createButton(buttonCmd6, parent, "M180C");
		return buttonCmd6;
	}

	public Button getButtonCmd7(Composite parent) {
		buttonCmd7 = createButton(buttonCmd7, parent, "M90C");
		return buttonCmd7;
	}

	public Button getButtonCmd8(Composite parent) {
		buttonCmd8 = createButton(buttonCmd8, parent, "1GraphFunc");
		return buttonCmd8;
	}

	public Button getButtonCmd9(Composite parent) {
		buttonCmd9 = createButton(buttonCmd9, parent, "2GraphFunc");
		return buttonCmd9;
	}

	public Button getButtonCmd10(Composite parent) {
		buttonCmd10 = createButton(buttonCmd10, parent, "3GraphFunc");
		return buttonCmd10;
	}

	// public ScaledSliderFigure getSlider1(Composite parent) {
	//
	// Canvas canvas = new Canvas(parent, SWT.BORDER);
	// canvas.setBackground(NLitesStandardSWTFactory.listBlue);
	// GridData data = new GridData();
	// data.heightHint = 75;
	// data.widthHint = 400;
	// canvas.setLayoutData(data);
	//
	//
	// LightweightSystem lws = new LightweightSystem(canvas);
	//
	// slider1 = new ScaledSliderFigure();
	// slider1.setRange((double) 0, (double)360);
	// slider1.setHorizontal(true);
	// slider1.setEffect3D(true);
	// slider1.setShowMarkers(false);
	// slider1.setMajorTickMarkStepHint(30);
	// slider1.setThumbColor(ColorConstants.gray);
	// lws.setContents(slider1);
	// return slider1;
	// }

	public GaugeFigure createGauge(Composite parent) {
		if (gauge != null)
			return gauge;
		Canvas canvas = new Canvas(parent, SWT.BORDER);
		GridData data = new GridData();
		data.heightHint = widthHeight;
		data.widthHint = widthHeight;
		canvas.setLayoutData(data);

		LightweightSystem lws = new LightweightSystem(canvas);
		gauge = new GaugeFigure();
		gauge.setRange(0, 60);
		gauge.setValue(0);
		gauge.setLoLevel(0);
		gauge.setHihiLevel(400);
		lws.setContents(gauge);
		return gauge;

	}

	public KnobFigure createKnob1(Composite parent) {

		return createKnob(knob1, parent);
	}
	
	public KnobFigure createKnob2(Composite parent) {
		return createKnob(knob2, parent);
	}
	
	
	public KnobFigure createKnob3(Composite parent) {
		return createKnob(knob3,parent);
	}
	
	private KnobFigure createKnob(KnobFigure k, Composite parent)
	{
		if(k !=null)return k;
		Canvas canvas = new Canvas(parent, SWT.BORDER);
		GridData data = new GridData();
		data.heightHint = widthHeight;
		data.widthHint = widthHeight;
		canvas.setLayoutData(data);
		LightweightSystem lws = new LightweightSystem(canvas);
		k = new KnobFigure();
		k.setRange(0, 360);
		k.setValue(0);
		lws.setContents(k);

		final KnobFigure temp = k;
		k.addMouseListener(new MouseListener(){
			@Override
			public void mouseDoubleClicked(MouseEvent arg0) {
			   int value = (int) ((temp.getValue() +15 ) /15)*15 %360;
			    temp.setValue(value);
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
			}});

		return k;
		
	}
	


	public void addKnobMouseListener(MouseListener l) {
		knob1.addMouseListener(l);
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

		createGauge(leftCanvas);
		getButtonLaserOnOff(leftCanvas);
		createKnob1(leftCanvas);
		createKnob2(leftCanvas);
		createKnob3(leftCanvas);
		getButtonA180(leftCanvas);
		getButtonCmd3(leftCanvas);
		getButtonCmd4(leftCanvas);
		getButtonCmd5(leftCanvas);
		getButtonCmd6(leftCanvas);
		getButtonCmd7(leftCanvas);
		getButtonCmd8(leftCanvas);
		getButtonCmd9(leftCanvas);
		getButtonCmd10(leftCanvas);

		GridData gdata = NLitesStandardSWTFactory.createFilledGridData();

		chartControl = new ChartControl(parent, SWT.None);
		chartControl.setVisible(true);
		chartControl.setLayoutData(gdata);
		chartControl.setCm(chart);

	}

	public Canvas createLeftCanvas(Composite parent) {

		Canvas leftCanvas = new Canvas(parent, SWT.None);
		leftCanvas.setBackground(NLitesStandardSWTFactory.honeyDew);
		GridData data = new GridData(SWT.BEGINNING, SWT.BEGINNING, false, true);
		data.widthHint = widthHeight;
		data.grabExcessVerticalSpace = true;
		leftCanvas.setLayoutData(data);
		leftCanvas.setLayout(NLitesStandardSWTFactory.createGridLayout(1));
		return leftCanvas;

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	private Button createButton(Button button, Composite parent, String text) {
		if (button == null) {
			button = new Button(parent, SWT.TOGGLE);
			button.setText(text);
			GridData gd = new GridData(150, 25);
			button.setLayoutData(gd);

		}
		return button;

	}

}