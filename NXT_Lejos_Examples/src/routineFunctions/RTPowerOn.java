package routineFunctions;

import org.scifair.util.BaseLejos;

import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
public class RTPowerOn extends BaseLejos{

	public void Power() {
		SensorPort.S1.setPowerType(1);
	}
	
public static void main(String[] args) {
	RTPowerOn RPO = new RTPowerOn();
	RPO.Power();
}	
}
