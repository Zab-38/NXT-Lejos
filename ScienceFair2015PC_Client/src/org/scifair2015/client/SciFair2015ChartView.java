package org.scifair2015.client;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.scifair2015.commands.Cmd1;
import org.scifair2015.commands.Cmd2;
import org.scifair2015.commands.Cmd3;

import com.bitcold.charts.views.ChartView;

public class SciFair2015ChartView extends ChartView {

	@Override
	public Button getButtonCmd1(Composite parent) {
		Button b = super.getButtonCmd1(parent);
		b.setText("Testing");
		b.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if(!getButtonCmd1().getSelection())
				{
					Image image = parent.getDisplay().getSystemImage(SWT.ICON_WORKING);
					b.setImage(image);
					Cmd1 cmd = new Cmd1();
					cmd.sendCommand();
					
				}
				else
				{
					Image image = parent.getDisplay().getSystemImage(SWT.ICON_QUESTION);
					b.setImage(image);
					Cmd2 cmd = new Cmd2();
					cmd.sendCommand();
					
				}	
				

				int i = SciFair2015Client.readInt();
				System.out.println(i +" echoed back");

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
				Cmd2 cmd = new Cmd2();
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

				SciFair2015Client.writeInt(22356);
				int i = SciFair2015Client.readInt();

//				Cmd4 cmd = new Cmd4();
//				cmd.sendCommand(SciFair2015Client.dos);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		return b;

	}

}
