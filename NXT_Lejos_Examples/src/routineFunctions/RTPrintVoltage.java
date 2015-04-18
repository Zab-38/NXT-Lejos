package routineFunctions;

import org.scifair.util.BaseLejos;

import lejos.nxt.Motor;
public class RTPrintVoltage extends BaseLejos{

	public void Print() {
		Motor.A.setSpeed(9);
    	Motor.A.backward();
	}
	
public static void main(String[] args) {
	RTPrintVoltage RPV = new RTPrintVoltage();
	RPV.Print();
}	
}
