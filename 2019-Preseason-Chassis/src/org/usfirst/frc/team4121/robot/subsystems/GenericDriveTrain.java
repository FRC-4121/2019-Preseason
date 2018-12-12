package org.usfirst.frc.team4121.robot.subsystems;

import org.usfirst.frc.team4121.robot.RobotMap;
import org.usfirst.frc.team4121.robot.commands.DriveWithJoysticksCommand;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The general drive train class for all various drive train styles.
 * Methods are inherited and overridden by the individual DT classes.
 * All methods present in any DT class should also exist here.
 */

public class GenericDriveTrain extends Subsystem {

	//Initialize motor controllers needed for all drive trains
    WPI_TalonSRX frontLeftMotor = new WPI_TalonSRX(RobotMap.MOTOR_1);
    WPI_TalonSRX frontRightMotor = new WPI_TalonSRX(RobotMap.MOTOR_2);    
    WPI_TalonSRX backLeftMotor = new WPI_TalonSRX(RobotMap.MOTOR_3);
    WPI_TalonSRX backRightMotor = new WPI_TalonSRX(RobotMap.MOTOR_4);
    WPI_TalonSRX strafeMotor = new WPI_TalonSRX(RobotMap.MOTOR_5);
    
    //For WCD only
    SpeedControllerGroup leftMotorGroup = new SpeedControllerGroup(frontLeftMotor, backLeftMotor);
    SpeedControllerGroup rightMotorGroup = new SpeedControllerGroup(frontRightMotor, backRightMotor);
    
    //Methods of Generic class are common to all drive train types. 
    //Specific method code is unique to each drive train type.
    public void initDefaultCommand() {
        
    	//All drive trains have default command to drive with the joysticks
        setDefaultCommand(new DriveWithJoysticksCommand());
    }
    
    public void drive(double leftJoyX, double leftJoyY, double rightJoyX, double rightJoyY) {}
    
    public void autoDrive(double speed, double angle) {}

}

