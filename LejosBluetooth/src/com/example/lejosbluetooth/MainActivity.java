package com.example.lejosbluetooth;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Context context = this;
	public final static String TAG = "APP MSG";
	private Button buttonStart = null;
	private Button buttonTerminate = null;
	private Button buttonForward = null;
	private Button buttonBackward = null;
	private Button buttonLeft = null;
	private Button buttonRight = null;
	private Button buttonSpeedPlus = null;


	private CustomView drawView = null;

	TextView textView = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		buttonStart = (Button) findViewById(R.id.buttonStart);
		buttonTerminate = (Button) findViewById(R.id.buttonTerminateLejos);
		// drawView = (CustomView) findViewById(R.id.customView);
		textView = (TextView) findViewById(R.id.textView);
		buttonForward = (Button) findViewById(R.id.Forward);
		buttonBackward = (Button) findViewById(R.id.Backward);
		buttonLeft = (Button) findViewById(R.id.Left);
		buttonRight = (Button) findViewById(R.id.Right);
		buttonSpeedPlus = (Button) findViewById(R.id.Speedplus);
	

		// initializes sound infrastructure
		SoundPlayer.singleton().init(getApplicationContext());

		buttonStart.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {

				int action = event.getAction();
				switch (action) {
				case MotionEvent.ACTION_DOWN:
					Controller.singleton().startSweep();
					return true;
				case MotionEvent.ACTION_UP:
					Controller.singleton().stopSweep();
					return true;

				}
				return false;
			}
		});

		buttonForward.setOnClickListener(new OnClickListener() {

			
				@Override
				public void onClick(View v) {
					final Dialog dialog = new  Dialog(context);
					dialog.setContentView(R.layout.speedincrease);
					dialog.setTitle("What is the speed?");
		 
					// set the custom dialog components - text, image and button
				
		 
					Button speedPlusButton = (Button) dialog.findViewById(R.id.Speedplus);
					// if button is clicked, close the custom dialog
					speedPlusButton.setOnClickListener(new OnClickListener() {
						@Override
						public void onClick(View v) {
						
							

							
						}
					});
	 
				dialog.show();
				
				Button directionPlusButton = (Button) dialog.findViewById(R.id.Durationplus);
				// if button is clicked, close the custom dialog
				directionPlusButton.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						dialog.dismiss();
					}
				});
	 
				dialog.show();
				
				Button speedMinusButton = (Button) dialog.findViewById(R.id.Speedminus);
				// if button is clicked, close the custom dialog
				speedMinusButton.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						Controller.singleton().Forward();
					}
				});
	 
				dialog.show();
				
				Button directionMinusButton = (Button) dialog.findViewById(R.id.Durationminus);
				// if button is clicked, close the custom dialog
				directionMinusButton.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						dialog.dismiss();
					}
				});
	 
				dialog.show();
			
			
			}

		});

		buttonBackward.setOnClickListener(new OnClickListener() {


			@Override
			public void onClick(View v) {
				final Dialog dialog = new  Dialog(context);
				dialog.setContentView(R.layout.direction);
				dialog.setTitle("Backward Preferences");
	 
				// set the custom dialog components - text, image and button
				
			
	 
				Button speedButton = (Button) dialog.findViewById(R.id.Speedplus);
				// if button is clicked, close the custom dialog
				speedButton.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						dialog.dismiss();
					}
				});
	 
				dialog.show();
				
				Button durationButton = (Button) dialog.findViewById(R.id.Durationplus);
				// if button is clicked, close the custom dialog
				durationButton.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						dialog.dismiss();
					}
					
					
				});
	 
				dialog.show();
		
				Button speedMinusButton = (Button) dialog.findViewById(R.id.Speedminus);
				// if button is clicked, close the custom dialog
				speedMinusButton.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						Controller.singleton().Forward();
					}
				});
	 
				dialog.show();
				
				Button directionMinusButton = (Button) dialog.findViewById(R.id.Durationminus);
				// if button is clicked, close the custom dialog
				directionMinusButton.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						dialog.dismiss();
					}
				});
	 
				dialog.show();
			
				
			}

		});
		
		buttonLeft.setOnClickListener(new OnClickListener() {


			@Override
			public void onClick(View v) {
				final Dialog dialog = new  Dialog(context);
				dialog.setContentView(R.layout.direction);
				dialog.setTitle("Left Preferences");
	 
				// set the custom dialog components - text, image and button
				
				
	 
				Button speedButton = (Button) dialog.findViewById(R.id.Speedplus);
				// if button is clicked, close the custom dialog
				speedButton.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						dialog.dismiss();
					}
				});
	 
				dialog.show();
			
				Button durationButton = (Button) dialog.findViewById(R.id.Durationplus);
				// if button is clicked, close the custom dialog
				durationButton.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						dialog.dismiss();
					}
				});
	 
				dialog.show();
				
				Button speedMinusButton = (Button) dialog.findViewById(R.id.Speedminus);
				// if button is clicked, close the custom dialog
				speedMinusButton.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						Controller.singleton().Forward();
					}
				});
	 
				dialog.show();
				
				Button directionMinusButton = (Button) dialog.findViewById(R.id.Durationminus);
				// if button is clicked, close the custom dialog
				directionMinusButton.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						dialog.dismiss();
					}
				});
	 
				dialog.show();
			
				
			}

		});
		
		buttonRight.setOnClickListener(new OnClickListener() {


			@Override
			public void onClick(View v) {
				final Dialog dialog = new  Dialog(context);
				dialog.setContentView(R.layout.direction);
				dialog.setTitle("Right Preferences");
	 
				// set the custom dialog components - text, image and button
		
		
	 
				Button speedButton = (Button) dialog.findViewById(R.id.Speedplus);
				// if button is clicked, close the custom dialog
				speedButton.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						dialog.dismiss();
					}
				});
	 
				dialog.show();
			
				Button durationButton = (Button) dialog.findViewById(R.id.Durationplus);
				// if button is clicked, close the custom dialog
				durationButton.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						dialog.dismiss();
					}
				});
	 
				dialog.show();
			
				Button speedMinusButton = (Button) dialog.findViewById(R.id.Speedminus);
				// if button is clicked, close the custom dialog
				speedMinusButton.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						Controller.singleton().Forward();
					}
				});
	 
				dialog.show();
				
				Button directionMinusButton = (Button) dialog.findViewById(R.id.Durationminus);
				// if button is clicked, close the custom dialog
				directionMinusButton.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						dialog.dismiss();
					}
				});
	 
				dialog.show();
			
				
			}

		});
		
//		buttonSpeedPlus.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				final Dialog dialog = new  Dialog(context);
//				dialog.setContentView(R.layout.speedincrease);
//				dialog.setTitle("What is the speed?");
//	 
//				// set the custom dialog components - text, image and button
//			
//	 
//				Button speedPlusButton = (Button) dialog.findViewById(R.id.Speedplus);
//				// if button is clicked, close the custom dialog
//				speedPlusButton.setOnClickListener(new OnClickListener() {
//					@Override
//					public void onClick(View v) {
//					
//						
//
//						
//					}
//				});
			
//			}
//		});
//		
		
		buttonTerminate.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Controller.singleton().terminateServer();

			}
		});

		Controller.singleton().setDrawView(this.drawView);
		Controller.singleton().setTextView(this.textView);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		int id = item.getItemId();

		switch (id) {
		case R.id.action_connect:
			item.setEnabled(false);
			BluetoothAsyncTask.singleton().execute(textView);
			return true;

		}

		return false;
	}

}
