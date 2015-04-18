package routineFunctions;

import org.scifair.util.BaseLejos;

import lejos.nxt.Motor;
public class RTMotorOff extends BaseLejos{

	public void MotorDectivate() {
		Motor.A.setSpeed(9);
    	Motor.A.backward();
	}
	
public static void main(String[] args) {
	RTMotorOff RMOf = new RTMotorOff();
	RMOf.MotorDectivate();
}	
}
