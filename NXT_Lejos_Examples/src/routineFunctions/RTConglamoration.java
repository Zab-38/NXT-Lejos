package routineFunctions;

import org.scifair.util.BaseLejos;

import com.josh.lejos.scifair2015.VoltmeterSensor;

import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
public class RTConglamoration extends BaseLejos{
	VoltmeterSensor s = new VoltmeterSensor(SensorPort.S2);
	public void MotorActivate() {
		Motor.A.setSpeed(9);
    	Motor.A.backward();
	}
	
	public void MotorDectivate() {
		Motor.A.setSpeed(0);
    	Motor.A.backward();
	}
	
	public void PowerOn() {
		SensorPort.S1.setPowerType(1);
	}
	
	public void PowerOff() {
		SensorPort.S1.setPowerType(0);
	}
	
	public void Print() {
		System.out.println(s.readVoltage());
	}
	
	public void Exit()
	{
			
    	System.exit(1);

	}
public static void main(String[] args) {
	RTConglamoration RTC = new RTConglamoration();
	
}	
}
