package org.usfirst.frc.team4121.robot.subsystems;

import edu.wpi.first.wpilibj.drive.MecanumDrive;

/**
 * Specific code for omnidirectional mecanum-style drive train (45-degree sliders)
 */
public class MecanumDriveTrain extends GenericDriveTrain {
	
    //Initialize robot drive - mecanum style
    MecanumDrive mecanumDrive = new MecanumDrive(frontLeftMotor, frontRightMotor, backLeftMotor, backRightMotor);
    
    @Override
    public void drive(double leftJoyX, double leftJoyY, double rightJoyX, double rightJoyY) {
    	
    	mecanumDrive.driveCartesian(leftJoyY,  leftJoyX,  rightJoyX);
    
    }
    
    @Override
    public void autoDrive(double speed, double angle) {
    	
    	mecanumDrive.drivePolar(speed, angle, 0); //rotation set to zero due to lack of understnad of how it works (!)
    	
    }
    
}