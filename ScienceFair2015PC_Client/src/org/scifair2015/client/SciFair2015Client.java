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

import com.bitcold.charts.views.ChartModule;
import com.bitcold.charts.views.ChartView;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class SciFair2015Client {

	DataInputStream dis;
	DataOutputStream dos;
	
	public void initiateBluetooth() throws NXTCommException, IOException
	{
		NXTComm nxtComm = NXTCommFactory.createNXTComm(NXTCommFactory.BLUETOOTH);
		NXTInfo[] nxtInfo = nxtComm.search("NXT");
		List<NXTInfo> list = Arrays.asList(nxtInfo);
		
		
		NXTInfo i = list.get(0);
		
		nxtComm.open(i);
		InputStream inputStream = nxtComm.getInputStream();
		OutputStream outputStream = nxtComm.getOutputStream();
		
		dos = new DataOutputStream(outputStream);
		dis = new DataInputStream(inputStream);
		
		
		nxtComm.close();
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		SciFair2015Client c = new  SciFair2015Client();
		try {
			c.initiateBluetooth();
			
			
		} catch (NXTCommException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		Injector i = Guice.createInjector(new ChartModule());
		
		ChartView chartView = i.getInstance(ChartView.class);
		NLitesStandardSWTFactory.viewViewPart(chartView);

	}

}
