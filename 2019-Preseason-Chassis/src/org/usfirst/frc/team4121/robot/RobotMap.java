/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4121.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	//Motor Controller Constants
	public static final int MOTOR_1 = 1;
	public static final int MOTOR_2 = 2;
	public static final int MOTOR_3 = 3;
	public static final int MOTOR_4 = 4;
	public static final int MOTOR_5 = 5;

	//Invert direction (for WCD only)
	public static int DIRECTION_MULTIPLIER = 1;
	
	//Strafe wheel multiplier (for slide drive only)
	public static double STRAFE_MULTIPLIER = 1;

	//Standard motor drive speeds for auto
	public static final double AUTO_DRIVE_SPEED = 0.5;

	//Encoder distances
	public static final double MECANUM_ENCODER_DPP = 0.075;
	
	//PID values
	public static double kP_Straight = 0.03;
	public static double kP_Turn = 0.06;
	public static double kI_Straight = 0.0;
	public static double kI_Turn = 0.0;
	public static double kD_Straight = 0.0;
	public static double kD_Turn = 0.0;

}
