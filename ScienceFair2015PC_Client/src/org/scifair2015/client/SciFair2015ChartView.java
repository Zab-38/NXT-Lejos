package org.scifair2015.client;

import java.io.InputStream;
import java.net.URL;








import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.nebula.visualization.widgets.figures.KnobFigure;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.scifair2015.commands.Cmd1;
import org.scifair2015.commands.Cmd2;
import org.scifair2015.commands.Cmd3;
import org.scifair2015.commands.Command;

import com.bitcold.charts.views.ChartView;

public class SciFair2015ChartView extends ChartView {

	@Override
	public Button getButtonCmd1(Composite parent) {
		initImageResources(parent);
		
		Button b = super.getButtonCmd1(parent);
		b.addSelectionListener(new SelectionListener() {

			
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(!getButtonCmd1().getSelection())
				{
					Cmd1 cmd = new Cmd1();
					cmd.sendCommand();
					
				}
				else
				{
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
	

	@Override
	public KnobFigure getKnob(Composite parent) {
		KnobFigure k = super.getKnob(parent);
		super.addKnobMouseListener(new  MouseListener() {

			@Override
			public void mouseDoubleClicked(org.eclipse.draw2d.MouseEvent arg0) {
			}

			@Override
			public void mousePressed(org.eclipse.draw2d.MouseEvent arg0) {
				
			}

			@Override
			public void mouseReleased(org.eclipse.draw2d.MouseEvent arg0) {
				System.out.println(k.getValue());
			}
			
		});
		return k;
	};
}
