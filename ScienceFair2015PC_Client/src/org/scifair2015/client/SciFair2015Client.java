package org.scifair2015.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

import lejos.pc.comm.NXTComm;
import lejos.pc.comm.NXTCommException;
import lejos.pc.comm.NXTCommFactory;
import lejos.pc.comm.NXTInfo;

import org.collab.swt.utils.NLitesStandardSWTFactory;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.scifair2015.commands.CmdLaserOff;
import org.scifair2015.commands.CmdLaserOn;
import org.scifair2015.commands.CmdTerminate;

import com.bitcold.charts.views.ChartModule;
import com.bitcold.charts.views.ChartView;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class SciFair2015Client {
	public static DataInputStream dis;
	public static DataOutputStream dos;
	public static NXTComm nxtComm;

	
	public void customizeButtons(ChartView chartView)
	{
		
		chartView.getButtonCmd1().addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
                  CmdLaserOn cmd = new CmdLaserOn();
                  cmd.sendCommand(dos);
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		
		
		
		chartView.getButtonCmd2().addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
                 CmdLaserOff cmd = new CmdLaserOff();
                 cmd.sendCommand(dos);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				
			}
		});
		
		chartView.getButtonCmd4().addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				CmdTerminate cmd = new CmdTerminate();
				cmd.sendCommand(dos);
				try {
					nxtComm.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				
			}
		});

	}
	
	
	static public void initiateBluetooth() throws NXTCommException, IOException
	{
		
		nxtComm = NXTCommFactory.createNXTComm(NXTCommFactory.BLUETOOTH);
		NXTInfo[] nxtInfo = nxtComm.search("NXT");
		List<NXTInfo> list = Arrays.asList(nxtInfo);
		
		
		NXTInfo i = list.get(0);
		
		nxtComm.open(i);
		InputStream inputStream = nxtComm.getInputStream();
		OutputStream outputStream = nxtComm.getOutputStream();
		
		dos = new DataOutputStream(outputStream);
		dis = new DataInputStream(inputStream);
	}

	
	
	public static void main(String[] args) {
		
		try {
			SciFair2015Client.initiateBluetooth();
			
			
		} catch (NXTCommException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		Injector i = Guice.createInjector(new ChartModule());
		ChartView chartView = i.getInstance(SciFair2015ChartView.class);
		
		NLitesStandardSWTFactory.viewViewPart(chartView);

	}

}
