package org.scifair2015.client;

import java.io.IOException;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.scifair2015.commands.CmdLaserOff;
import org.scifair2015.commands.CmdLaserOn;
import org.scifair2015.commands.CmdTerminate;

import com.bitcold.charts.views.ChartView;


public class SciFair2015ChartView extends ChartView {
	

	@Override
	public Button getButtonCmd1(Composite parent) {
		Button b = super.getButtonCmd1(parent);
		b.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
                CmdLaserOn cmd = new CmdLaserOn();
                cmd.sendCommand(SciFair2015Client.dos);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		
		return b;
	}
	
	
	
	
	
	
	@Override
	public Button getButtonCmd2(Composite parent) {
		Button b = super.getButtonCmd2(parent);
		b.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
	               CmdLaserOff cmd = new CmdLaserOff();
	                 cmd.sendCommand(SciFair2015Client.dos);
					}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		
		
		return b;
	}
	
	
	@Override
	public Button getButtonCmd4(Composite parent)
	{
		Button b = super.getButtonCmd4(parent);
		b.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				CmdTerminate cmd = new CmdTerminate();
				cmd.sendCommand(SciFair2015Client.dos);
				try {
					SciFair2015Client.nxtComm.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
					}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		
		
		return b;
		
	}
	
	
	
	
	
	
	
	
	
	
}
