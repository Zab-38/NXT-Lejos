import com.josh.lejos.util.BaseLejos;

import lejos.nxt.SensorPort;
import lejos.nxt.addon.OpticalDistanceSensor;

public class TestIRSensor extends BaseLejos {

	 OpticalDistanceSensor sensor = new OpticalDistanceSensor(SensorPort.S1);
	public int getdistance() {
	
		return sensor.getDistance();

	}

	public void display() {

		int distance = getdistance();
		System.out.println(distance);
	}

	@Override
	public void run() {
		while (true) {
			display();
		}
	}

	public static void main(String[] args)

	{
		TestIRSensor sensor = new TestIRSensor();
		sensor.run();

	}
}
