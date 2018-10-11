package org.usfirst.frc.team4121.robot.subsystems;

import org.usfirst.frc.team4121.robot.Robot;
import org.usfirst.frc.team4121.robot.RobotMap;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * Specific code for WCD (six-wheel tank-style drive)
 */
public class WestCoastDriveTrain extends GenericDriveTrain {

	//Initialize robot drive train - 6-wheel WCD style
	DifferentialDrive westCoastDrive = new DifferentialDrive(frontLeftMotor, frontRightMotor);

	@Override
	public void drive(double leftJoyX, double leftJoyY, double rightJoyX, double rightJoyY) {

		if(RobotMap.DIRECTION_MULTIPLIER == 1)
			
			westCoastDrive.tankDrive(leftJoyY * RobotMap.DIRECTION_MULTIPLIER, rightJoyY * RobotMap.DIRECTION_MULTIPLIER);
		
		else
			
			westCoastDrive.tankDrive(rightJoyY * RobotMap.DIRECTION_MULTIPLIER, leftJoyY * RobotMap.DIRECTION_MULTIPLIER);

	}
	
	@Override
	public void autoDrive(double speed, double angle) {
		
		double angleError = Robot.oi.mainGyro.getAngle() - angle;
    	double angleCorrection = RobotMap.kP_Straight * angleError;
    	
    	westCoastDrive.tankDrive((RobotMap.AUTO_DRIVE_SPEED + angleCorrection), (RobotMap.AUTO_DRIVE_SPEED - angleCorrection));    	    	
		
	}
	
}