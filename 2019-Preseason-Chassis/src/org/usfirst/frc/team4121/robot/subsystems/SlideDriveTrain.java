package org.usfirst.frc.team4121.robot.subsystems;

import org.usfirst.frc.team4121.robot.RobotMap;

/**
 * Currently theoretical and completely self-developed.  No idea whether this will work until I test it on a real robot.	
 * 
 * I think that, due to the
 * 
 * General layout of a slide drive chassis:
 * (M: motor, W: wheel)
 * 
 *   M1/W1  ------------- M2/W2
 *     |					|
 *     |					|
 *     |					|
 *     |-- M5/6 Strafe W --	|
 *     |					|
 *     |					|
 *     |					|
 *   M3/W3  ------------- M4/W4
 *   
 * This one is a little more complicated, because WPI doesn't give us handy code, and 
 * might require more math.  Will attempt to explain, if I understand what I'm doing. :)
 */

public class SlideDriveTrain extends GenericDriveTrain {

	@Override
	public void drive(double leftJoyX, double leftJoyY, double rightJoyX, double rightJoyY) {

		//The tank-style portion of this drive train are controlled normally from the y axis of both joysticks
		frontLeftMotor.set(leftJoyY);
		frontRightMotor.set(rightJoyY);
		backLeftMotor.set(leftJoyY);
		backRightMotor.set(rightJoyY);

		//The strafe wheel is controlled from the x-axis of the right joystick
		strafeMotor.set(rightJoyX);
		
	}

	@Override
	public void autoDrive(double angle, double magnitude) {

		//Give all the 'normal' wheels the speed for travel in the 'y' direction (forward and backward for visualization)
		//y = magnitude * cosine of angle due to 'forward' being angle = 0
		frontLeftMotor.set(Math.cos(angle) * magnitude);
		frontRightMotor.set(Math.cos(angle) * magnitude);
		backLeftMotor.set(Math.cos(angle) * magnitude);
		backRightMotor.set(Math.cos(angle) * magnitude);

		//Give the strafe wheel the speed for travel in the 'x' direction (left and right, for visualization's sake)
		//x = magnitude * sine of angle due to 'forward' being angle = 0
		//May be necessary to add a multiplier to this wheel's speed, or to simply have two motors on this wheel.
		strafeMotor.set(Math.sin(angle) * magnitude * RobotMap.STRAFE_MULTIPLIER);
	}


}

