package routineFunctions;

import org.scifair.util.BaseLejos;

import com.josh.lejos.scifair2015.VoltmeterSensor;

import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
public class RTPrintVoltage extends BaseLejos{
	VoltmeterSensor s = new VoltmeterSensor(SensorPort.S2);
	public void Print() {
		System.out.println(s.readVoltage());
	}
	
public static void main(String[] args) {
	RTPrintVoltage RPV = new RTPrintVoltage();
	RPV.Print();
}	
}
