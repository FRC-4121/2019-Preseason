package org.usfirst.frc.team4121.robot.subsystems;

import org.usfirst.frc.team4121.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

/**
 * Specific code for omnidirectional mecanum-style drive train (45-degree sliders)
 */

public class MecanumDriveTrain extends GenericDriveTrain {
	
	//Initialize 
	
    //Initialize robot drive - mecanum style
    MecanumDrive mecanumDrive = new MecanumDrive(frontLeftMotor, frontRightMotor, backLeftMotor, backRightMotor);
    
    //Init encoders
    public boolean encoderConfig = initEncoders();
    
    public boolean initEncoders() {
    	
    	/*
    	 * Wiring of mecanum encoders: AndyMark am-3132
    	 * 
    	 * There are four wires attached to the encoder: red, black, blue, yellow.
    	 * 
    	 * These will be inserted into TWO DIO pins/numbers on the roboRIO
    	 * 
    	 * Constructor:  Encoder(A, B, true)
    	 * 
    	 * Red: power (5V). Insert into 5V pin of DIO A
    	 * Black: ground.  Insert into GND pin of DIO A
    	 * Blue: channel A.  Insert into S pin of DIO A
    	 * Yellow: channel B.  Insert into S pin of DIO B
    	 */
    	
    	Encoder frontLeftEncoder = new Encoder(2, 3, true);
    	frontLeftEncoder.setDistancePerPulse(RobotMap.MECANUM_ENCODER_DPP);
    	
    	Encoder frontRightEncoder = new Encoder(0, 1, true);
    	frontRightEncoder.setDistancePerPulse(RobotMap.MECANUM_ENCODER_DPP);
    	
    	Encoder backLeftEncoder = new Encoder(6, 7, true);
    	backLeftEncoder.setDistancePerPulse(RobotMap.MECANUM_ENCODER_DPP);
    	
    	Encoder backRightEncoder = new Encoder(4, 5, true);
    	backRightEncoder.setDistancePerPulse(RobotMap.MECANUM_ENCODER_DPP);
    	
    	return true;
    }
    
    
    @Override
    public void drive(double leftJoyX, double leftJoyY, double rightJoyX, double rightJoyY) {
    	
    	mecanumDrive.driveCartesian(leftJoyY,  leftJoyX,  rightJoyX);
    
    }
    
    @Override
    public void autoDrive(double speed, double angle) {
    	
    	mecanumDrive.drivePolar(speed, angle, 0); //rotation set to zero due to lack of understanding of how it works (!)
    	
    }
    
}