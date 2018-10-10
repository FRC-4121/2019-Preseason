package org.usfirst.frc.team4121.robot.subsystems;

import org.usfirst.frc.team4121.robot.RobotMap;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class WestCoastDriveTrain extends GenericDriveTrain {

	//Initialize robot drive train - 6-wheel WCD style
	DifferentialDrive westCoastDrive = new DifferentialDrive(frontLeftMotor, frontRightMotor);

	@Override
	public void drive(double leftJoyX, double leftJoyY, double rightJoyX, double rightJoyY) {

		westCoastDrive.tankDrive(leftJoyY * RobotMap.DIRECTION_MULTIPLIER, rightJoyY * RobotMap.DIRECTION_MULTIPLIER);

	}
}

