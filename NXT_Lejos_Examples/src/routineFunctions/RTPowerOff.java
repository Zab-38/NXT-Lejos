package routineFunctions;

import org.scifair.util.BaseLejos;

import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
public class RTPowerOff extends BaseLejos{

	public void PowerO() {
		SensorPort.S1.setPowerType(0);
	}
	
public static void main(String[] args) {
	RTPowerOff RPOf = new RTPowerOff();
	RPOf.PowerO();
}	
}
