package org.scifair2015.client;

import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.nebula.visualization.widgets.figures.GaugeFigure;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.scifair2015.commands.Cmd10;
import org.scifair2015.commands.Cmd3;
import org.scifair2015.commands.Cmd4;
import org.scifair2015.commands.Cmd5;
import org.scifair2015.commands.Cmd6;
import org.scifair2015.commands.Cmd7;
import org.scifair2015.commands.Cmd8;
import org.scifair2015.commands.Cmd9;
import org.scifair2015.commands.CmdButtonA180;
import org.scifair2015.commands.CmdLaserOff;
import org.scifair2015.commands.CmdLaserOn;
import org.scifair2015.commands.CmdMeasureVoltage;

import com.bitcold.charts.views.ChartView;

public class SciFair2015ChartView extends ChartView {

	@Override
	public Button getButtonLaserOnOff(Composite parent) {
		initImageResources(parent);
		
		Button b = super.getButtonLaserOnOff(parent);
		
		b.addSelectionListener(new SelectionListener() {

			
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(!getButtonCmd1().getSelection())
				{
					CmdLaserOff cmd = new CmdLaserOff();
					cmd.sendCommand();
				}
				else
				{
					CmdLaserOn cmd = new CmdLaserOn();
					cmd.sendCommand();
					
				}	
				


			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		return b;
	}
	
	@Override
	public GaugeFigure getGauge(Composite parent) {
		GaugeFigure gauge = super.getGauge(parent);
		gauge.addMouseListener(new MouseListener(){

			@Override
			public void mouseDoubleClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
	                CmdMeasureVoltage cmd = new CmdMeasureVoltage();
	                cmd.sendCommand();
	                int voltage = SciFair2015Client.readInt();
	                getGuage().setValue(-voltage);
			}});
		return gauge;
	}

	@Override
	public Button getButtonA180(Composite parent) {
		Button b = super.getButtonA180(parent);
		b.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				CmdButtonA180 cmd = new CmdButtonA180();
				cmd.sendCommand();

				int i = SciFair2015Client.readInt();
				System.out.println(i);

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		return b;
	}
	
	@Override
	public Button getButtonCmd3(Composite parent) {
		
		Button b = super.getButtonCmd3(parent);
		b.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Cmd3 cmd = new Cmd3();
				cmd.sendCommand();

				int i = SciFair2015Client.readInt();
				System.out.println(i);

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		return b;
		
	};

	@Override
	public Button getButtonCmd4(Composite parent) {
		Button b = super.getButtonCmd4(parent);
		b.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Cmd4 cmd = new Cmd4();
				cmd.sendCommand();
				int i = SciFair2015Client.readInt();
				System.out.println(i);


//				Cmd4 cmd = new Cmd4();
//				cmd.sendCommand(SciFair2015Client.dos);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		return b;

	}
	@Override
	public Button getButtonCmd5(Composite parent) {
		Button b = super.getButtonCmd5(parent);
		b.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Cmd5 cmd = new Cmd5();
				cmd.sendCommand();
				int i = SciFair2015Client.readInt();
				System.out.println(i);


//				Cmd4 cmd = new Cmd4();
//				cmd.sendCommand(SciFair2015Client.dos);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		return b;

	}
	@Override
	public Button getButtonCmd6(Composite parent) {
		Button b = super.getButtonCmd6(parent);
		b.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Cmd6 cmd = new Cmd6();
				cmd.sendCommand();
				int i = SciFair2015Client.readInt();
				System.out.println(i);


//				Cmd4 cmd = new Cmd4();
//				cmd.sendCommand(SciFair2015Client.dos);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		return b;

	}
	@Override
	public Button getButtonCmd7(Composite parent) {
		Button b = super.getButtonCmd7(parent);
		b.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Cmd7 cmd = new Cmd7();
				cmd.sendCommand();
				int i = SciFair2015Client.readInt();
				System.out.println(i);


//				Cmd4 cmd = new Cmd4();
//				cmd.sendCommand(SciFair2015Client.dos);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		return b;

	}
	@Override
	public Button getButtonCmd8(Composite parent) {
		Button b = super.getButtonCmd8(parent);
		b.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Cmd8 cmd = new Cmd8();
				cmd.sendCommand();
				int i = SciFair2015Client.readInt();
				System.out.println(i);


//				Cmd4 cmd = new Cmd4();
//				cmd.sendCommand(SciFair2015Client.dos);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		return b;

	}

	@Override
	public Button getButtonCmd9(Composite parent) {
		Button b = super.getButtonCmd9(parent);
		b.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Cmd9 cmd = new Cmd9();
				cmd.sendCommand();
				int i = SciFair2015Client.readInt();
				System.out.println(i);


//				Cmd4 cmd = new Cmd4();
//				cmd.sendCommand(SciFair2015Client.dos);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		return b;

	}

	@Override
	public Button getButtonCmd10(Composite parent) {
		Button b = super.getButtonCmd10(parent);
		b.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Cmd10 cmd = new Cmd10();
				cmd.sendCommand();
				int i = SciFair2015Client.readInt();
				System.out.println(i);


//				Cmd4 cmd = new Cmd4();
//				cmd.sendCommand(SciFair2015Client.dos);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		return b;

	}


//	@Override
//	public KnobFigure getKnob(Composite parent) {
//		KnobFigure k = super.getKnob(parent);
//		
//		super.addKnobMouseListener(new  MouseListener() {
//
//			@Override
//			public void mouseDoubleClicked(org.eclipse.draw2d.MouseEvent arg0) {
//			}
//
//			@Override
//			public void mousePressed(org.eclipse.draw2d.MouseEvent arg0) {
//				
//			}
//
//			@Override
//			public void mouseReleased(org.eclipse.draw2d.MouseEvent arg0) {
//				System.out.println(k.getValue());
//			}
//			
//		});
//		return k;
//		 
//	};
}
