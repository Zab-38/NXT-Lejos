package communications;

import lejos.nxt.Button;
import lejos.nxt.ButtonListener;

public class BaseLejos {

	
	public BaseLejos()
	{
		Button.ESCAPE.addButtonListener(new ButtonListener() {

			@Override
			public void buttonReleased(Button b) {

			}

			@Override
			public void buttonPressed(Button b) {
			
				System.exit(1);

			}
		});
		
	}
	
	public void run()
	{
		while(true)
		{
			
		}
	}
	
}
