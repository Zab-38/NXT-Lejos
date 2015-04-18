package com.bitcold.charts.widget;

import org.eclipse.birt.chart.api.ChartEngine;
import org.eclipse.birt.chart.device.IDeviceRenderer;
import org.eclipse.birt.chart.device.IUpdateNotifier;
import org.eclipse.birt.chart.exception.ChartException;
import org.eclipse.birt.chart.factory.GeneratedChartState;
import org.eclipse.birt.chart.factory.Generator;
import org.eclipse.birt.chart.model.Chart;
import org.eclipse.birt.chart.model.attribute.Bounds;
import org.eclipse.birt.chart.model.attribute.impl.BoundsImpl;
import org.eclipse.birt.core.exception.BirtException;
import org.eclipse.birt.core.framework.PlatformConfig;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

public class ChartControl extends Composite implements PaintListener,IUpdateNotifier {

	private IDeviceRenderer idr = null;
	private boolean bNeedsGeneration = true;
	private GeneratedChartState gcs = null;
	private Chart cm;


	public void setCm(Chart cm) {
		this.cm = cm;
	    bNeedsGeneration = true;
		this.redraw( );
	}

	public ChartControl(Composite parent, int style) {
		super(parent, style);
		try {
			PlatformConfig config = new PlatformConfig();
			 config.setProperty("STANDALONE", "true"); //$NON-NLS-1$ //$NON-NLS-2$
			idr = ChartEngine.instance(config).getRenderer("dv.SWT");//$NON-NLS-1$
		} catch (ChartException ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getCause());
			System.out.println(ex.getStackTrace());
			
			StackTraceElement[] trace = ex.getStackTrace(); 
			for (int i = 0; i < trace.length; i++) {
				StackTraceElement element = trace[i];
				System.out.println(element.toString());
			}		
		}
		addControlListener(new ControlListener() {

			public void controlMoved(ControlEvent e) {
				bNeedsGeneration = true;
			}

			public void controlResized(ControlEvent e) {
				bNeedsGeneration = true;
			}
		});

		addPaintListener( this);
 	}

	@Override
	public void paintControl(PaintEvent e) {
		Rectangle d = this.getClientArea();
		Image imgChart = new Image(this.getDisplay(), d);
		GC gcImage = new GC(imgChart);
		
		if(idr==null)return;
		
		
		idr.setProperty(IDeviceRenderer.GRAPHICS_CONTEXT, gcImage);
		idr.setProperty(IDeviceRenderer.UPDATE_NOTIFIER, this);

		Bounds bo = BoundsImpl.create(0, 0, d.width, d.height);
		bo.scale(72d / idr.getDisplayServer().getDpiResolution());

		Generator gr = Generator.instance();
		if (bNeedsGeneration) {
			bNeedsGeneration = false;
			try {
				gcs = gr.build(idr.getDisplayServer(), cm, bo, null, null, null);
			} catch (ChartException ce) {
				ce.printStackTrace();
			}
		}

		try {
			gr.render(idr, gcs);
			GC gc = e.gc;
			gc.drawImage(imgChart, d.x, d.y);
		} catch (ChartException gex) {
			showException(e.gc, gex);
		}

	}

	private final void showException(GC g2d, Exception ex) {
		String sWrappedException = ex.getClass().getName();
		Throwable th = ex;
		while (ex.getCause() != null) {
			ex = (Exception) ex.getCause();
		}
		String sException = ex.getClass().getName();
		if (sWrappedException.equals(sException)) {
			sWrappedException = null;
		}

		String sMessage = null;
		if (th instanceof BirtException) {
			sMessage = ((BirtException) th).getLocalizedMessage();
		} else {
			sMessage = ex.getMessage();
		}

		if (sMessage == null) {
			sMessage = "<null>";//$NON-NLS-1$
		}
		StackTraceElement[] stea = ex.getStackTrace();
		Point d = this.getSize();

		Device dv = Display.getCurrent();
		Font fo = new Font(dv, "Courier", SWT.BOLD, 16);//$NON-NLS-1$
		g2d.setFont(fo);
		FontMetrics fm = g2d.getFontMetrics();
		g2d.setBackground(dv.getSystemColor(SWT.COLOR_WHITE));
		g2d.fillRectangle(20, 20, d.x - 40, d.y - 40);
		g2d.setForeground(dv.getSystemColor(SWT.COLOR_BLACK));
		g2d.drawRectangle(20, 20, d.x - 40, d.y - 40);
		g2d.setClipping(20, 20, d.x - 40, d.y - 40);
		int x = 25, y = 20 + fm.getHeight();
		g2d.drawString("Exception:", x, y);//$NON-NLS-1$
		x += g2d.textExtent("Exception:").x + 5;//$NON-NLS-1$
		g2d.setForeground(dv.getSystemColor(SWT.COLOR_RED));
		g2d.drawString(sException, x, y);
		x = 25;
		y += fm.getHeight();
		if (sWrappedException != null) {
			g2d.setForeground(dv.getSystemColor(SWT.COLOR_BLACK));
			g2d.drawString("Wrapped In:", x, y);//$NON-NLS-1$
			x += g2d.textExtent("Wrapped In:").x + 5;//$NON-NLS-1$
			g2d.setForeground(dv.getSystemColor(SWT.COLOR_RED));
			g2d.drawString(sWrappedException, x, y);
			x = 25;
			y += fm.getHeight();
		}
		g2d.setForeground(dv.getSystemColor(SWT.COLOR_BLACK));
		y += 10;
		g2d.drawString("Message:", x, y);//$NON-NLS-1$
		x += g2d.textExtent("Message:").x + 5;//$NON-NLS-1$
		g2d.setForeground(dv.getSystemColor(SWT.COLOR_BLUE));
		g2d.drawString(sMessage, x, y);
		x = 25;
		y += fm.getHeight();
		g2d.setForeground(dv.getSystemColor(SWT.COLOR_BLACK));
		y += 10;
		g2d.drawString("Trace:", x, y);//$NON-NLS-1$
		x = 40;
		y += fm.getHeight();
		g2d.setForeground(dv.getSystemColor(SWT.COLOR_DARK_GREEN));
		for (int i = 0; i < stea.length; i++) {
			g2d.drawString(stea[i].getClassName() + ":"//$NON-NLS-1$
					+ stea[i].getMethodName() + "(...):"//$NON-NLS-1$
					+ stea[i].getLineNumber(), x, y);
			x = 40;
			y += fm.getHeight();
		}
		fo.dispose();
	}

	@Override
	public void regenerateChart() {
		redraw( );
	}

	@Override
	public void repaintChart() {

		redraw( );
		
		
	}

	@Override
	public Object peerInstance() {
		return this;
	}

	@Override
	public Chart getDesignTimeModel() {
		return cm;
	}

	@Override
	public Chart getRunTimeModel() {
		return gcs.getChartModel( );	
	}

}
