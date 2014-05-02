package com.example.lejosbluetooth;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Set;
import java.util.UUID;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

public class BluetoothAsyncTask extends AsyncTask<TextView, Void, Void> {
	private static BluetoothAsyncTask singletonInstance =null;
	
	private TextView textView;
	private BluetoothAdapter btAdapter;
	private String mMacAddress = null;
	private BluetoothSocket nxtBTsocket;
	private DataInputStream dIn;
	public DataInputStream getdIn() {
		return dIn;
	}


	private DataOutputStream dOut;
	public DataOutputStream getdOut() { 
		return dOut;
	}


	private boolean connected=false;
	private static final UUID SERIAL_PORT_SERVICE_CLASS_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
	                                                                            
    // this is the only OUI registered by LEGO, see http://standards.ieee.org/regauth/oui/index.shtml
    public static final String OUI_LEGO = "00:16:53";

	private BluetoothAsyncTask() {

	}
	
	
	public static BluetoothAsyncTask singleton()
	{
		if(singletonInstance==null)
		{
			singletonInstance = new BluetoothAsyncTask();
		}
		return singletonInstance;
	}

	@Override
	protected void onPostExecute(Void result) {
		super.onPostExecute(result);
		Log.e(MainActivity.TAG , "bluetooth connected using RAW Protocol");

		textView.setText("Connected!!!!");
		SoundPlayer.singleton().playSound(SoundPlayer.Sound.S1);

	}

	@Override
	protected Void doInBackground(TextView... params) {

		Log.v(MainActivity.TAG, "param count = " + params.length);
		
		textView = params[0];

		Log.v(MainActivity.TAG, " about to add LEJOS listener ");
		createNXTConnection();

		return null;
	}
	
	private void createNXTConnection() {
	      try {
	    	  btAdapter = BluetoothAdapter.getDefaultAdapter();
	    	  Set<BluetoothDevice> devices = btAdapter.getBondedDevices();
	    	  for (BluetoothDevice bluetoothDevice : devices) {
	    		mMacAddress = bluetoothDevice.getAddress();
				Log.v(MainActivity.TAG, mMacAddress);
			}
	    	  
	    	  
	         BluetoothSocket nxtBTsocketTemporary;
	         BluetoothDevice nxtDevice  = btAdapter.getRemoteDevice(mMacAddress);

//	         BluetoothDevice nxtDevice  = btAdapter.getRemoteDevice("34:DF:2A:15:72:BD");
//	         BluetoothDevice nxtDevice  = btAdapter.getRemoteDevice("00:16:53:10:C0:3E");
	         
	         
	         nxtBTsocketTemporary = nxtDevice.createRfcommSocketToServiceRecord(SERIAL_PORT_SERVICE_CLASS_UUID);
	         nxtBTsocketTemporary.connect();
	         nxtBTsocket = nxtBTsocketTemporary;
	         
	         dIn = new DataInputStream(nxtBTsocket.getInputStream());
	         dOut = new DataOutputStream(nxtBTsocket.getOutputStream());
	         
	         connected = true;
	      } catch (IOException e) {
	    	  Log.e("exception", e.getMessage());
	         return;
	      }
	      Log.v(MainActivity.TAG, "CONNECTED!!");
	   }
    
	

}
