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
import org.scifair2015.commands.CmdButtonA180;
import org.scifair2015.commands.CmdLaserOn;
import org.scifair2015.commands.Cmd4;
import org.scifair2015.commands.Cmd3;
import org.scifair2015.commands.Cmd5;
import org.scifair2015.commands.Cmd6;
import org.scifair2015.commands.Cmd7;
import org.scifair2015.commands.Cmd8;
import org.scifair2015.commands.Cmd9;
import org.scifair2015.commands.Cmd10;
import org.scifair2015.commands.Rotate;

import com.bitcold.charts.views.ChartModule;
import com.bitcold.charts.views.ChartView;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class SciFair2015Client {
	public static DataInputStream dis;
	public static DataOutputStream dos;
	public static NXTComm nxtComm;

	// public static int endianSwap (int value)
	// {
	// int b1 = (value >> 0) & 0xff;
	// int b2 = (value >> 8) & 0xff;
	// int b3 = (value >> 16) & 0xff;
	// int b4 = (value >> 24) & 0xff;
	//
	// return b1 << 24 | b2 << 16 | b3 << 8 | b4 << 0;
	// }
	public static int readInt() {
		byte[] b = new byte[4];
		try {
			dis.read(b, 0, b.length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return decodeIntLE(b, 0);
	}

	public static void writeInt(int i) {
		byte[] _b = new byte[4];
		SciFair2015Client.encodeIntLE(i, _b, 0);
		try {
			SciFair2015Client.dos.write(_b);
			SciFair2015Client.dos.flush();
			System.out.println("echoed: " + i);

		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	public static int decodeIntLE(byte[] b, int off) {
		return (b[off] & 0xFF) | ((b[off + 1] & 0xFF) << 8)
				| ((b[off + 2] & 0xFF) << 16) | (b[off + 3] << 24);
	}

	public static void encodeIntLE(int v, byte[] b, int off) {
		b[off] = (byte) v;
		b[off + 1] = (byte) (v >>> 8);
		b[off + 2] = (byte) (v >>> 16);
		b[off + 3] = (byte) (v >>> 24);
	}

	public void customizeButtons(ChartView chartView) {

		chartView.getButtonCmd1().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				CmdLaserOn cmd = new CmdLaserOn();
				cmd.sendCommand();

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		chartView.getButtonCmd2().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				CmdButtonA180 cmd = new CmdButtonA180();
				cmd.sendCommand();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {

			}
		});
		chartView.getButtonCmd3().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Cmd3 cmd = new Cmd3();
				cmd.sendCommand();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {

			}
		});

		chartView.getButtonCmd4().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Cmd4 cmd = new Cmd4();
				cmd.sendCommand();
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

		chartView.getButtonCmd5().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Cmd5 cmd = new Cmd5();
				cmd.sendCommand();
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

		chartView.getButtonCmd6().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Cmd6 cmd = new Cmd6();
				cmd.sendCommand();
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
		
		chartView.getButtonCmd7().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Cmd7 cmd = new Cmd7();
				cmd.sendCommand();
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

		chartView.getButtonCmd8().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Cmd8 cmd = new Cmd8();
				cmd.sendCommand();
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

		chartView.getButtonCmd9().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Cmd9 cmd = new Cmd9();
				cmd.sendCommand();
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
		
		chartView.getButtonCmd10().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Cmd10 cmd = new Cmd10();
				cmd.sendCommand();
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

	static public void initiateBluetooth() throws NXTCommException, IOException {

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
