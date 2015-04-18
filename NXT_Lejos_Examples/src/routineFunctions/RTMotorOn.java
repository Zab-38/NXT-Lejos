package routineFunctions;

import org.scifair.util.BaseLejos;

import lejos.nxt.Motor;
public class RTMotorOn extends BaseLejos{

	public void MotorActivate() {
		Motor.A.setSpeed(0);
    	Motor.A.backward();
	}
	
public static void main(String[] args) {
	RTMotorOn RMO = new RTMotorOn();
	RMO.MotorActivate();
}	
}
