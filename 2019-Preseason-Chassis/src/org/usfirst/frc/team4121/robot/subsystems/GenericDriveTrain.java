package org.usfirst.frc.team4121.robot.subsystems;

import org.usfirst.frc.team4121.robot.RobotMap;
import org.usfirst.frc.team4121.robot.commands.DriveWithJoysticksCommand;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GenericDriveTrain extends Subsystem {

	//Initialize motor controllers needed for mecanum drive
    WPI_TalonSRX frontLeftMotor = new WPI_TalonSRX(RobotMap.MOTOR_1);
    WPI_TalonSRX frontRightMotor = new WPI_TalonSRX(RobotMap.MOTOR_2);
    WPI_TalonSRX backLeftMotor = new WPI_TalonSRX(RobotMap.MOTOR_3);
    WPI_TalonSRX backRightMotor = new WPI_TalonSRX(RobotMap.MOTOR_4);

    public void initDefaultCommand() {
        
        setDefaultCommand(new DriveWithJoysticksCommand());
    }
    
    public void drive(double leftJoyX, double leftJoyY, double rightJoyX, double rightJoyY) {
    	
    	
    }
    
    public void autoDrive() {
    	
    }
}

