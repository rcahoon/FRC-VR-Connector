package com.team766.virtual.test;

import java.io.IOException;

import com.team766.virtual.VRConnector;

public class TestMain {
	public static void main(String[] args) {
		try {
			VRConnector vrc = new VRConnector();
			vrc.putCommandBool(VRConnector.RESET_SIM, true);
			while (true) {
				vrc.putCommand(VRConnector.LEFT_MOTOR, 256);
				vrc.putCommand(VRConnector.RIGHT_MOTOR, 512);
				vrc.putCommand(VRConnector.INTAKE, -1);
				if (vrc.process()) {
					System.out.println("Left enc: " + vrc.getFeedback(VRConnector.LEFT_ENCODER));
					System.out.println("Right enc: " + vrc.getFeedback(VRConnector.RIGHT_ENCODER));
					System.out.println("Heading: " + vrc.getFeedback(VRConnector.HEADING));
					System.out.println("Intake State: " + vrc.getFeedback(VRConnector.INTAKE_STATE));
					System.out.println("Ball Presence: " + vrc.getFeedback(VRConnector.BALL_PRESENCE));
				}
				
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
