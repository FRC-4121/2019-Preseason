/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4121.robot;

import org.usfirst.frc.team4121.robot.subsystems.GenericDriveTrain;
import org.usfirst.frc.team4121.robot.subsystems.MecanumDriveTrain;
import org.usfirst.frc.team4121.robot.subsystems.OmniDriveTrain;
import org.usfirst.frc.team4121.robot.subsystems.SlideDriveTrain;
import org.usfirst.frc.team4121.robot.subsystems.WestCoastDriveTrain;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	
	public static GenericDriveTrain driveTrain = new GenericDriveTrain();
	public static OI oi;

	public static int driveType;
	
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
	
		/* Allows for simple alteration of drive train type.  
		 * 1: West Coast
		 * 2: Mecanum 
		 * 3: Omni
		 * 4: Slide
		 * default: West Coast
		 */
		
		driveType = 1;
		
		switch(driveType) {
		
		case 1: 
			driveTrain = new WestCoastDriveTrain();
			break;
			
		case 2:
			driveTrain = new MecanumDriveTrain();
			break;
			
		case 3:
			driveTrain = new OmniDriveTrain();
			break;
			
		case 4:
			driveTrain = new SlideDriveTrain();
			break;
			
		default:
			driveTrain = new WestCoastDriveTrain();
		
		}
		
		//Init output-input systems
		oi = new OI();
		
		//chooser.addDefault("Default Auto", new ExampleCommand());
		//chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", chooser);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();

		//start the auto command
		if (autonomousCommand != null) {
			autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		
		if (autonomousCommand != null) {
			autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		
		Scheduler.getInstance().run();
	
		SmartDashboard.putData("Front Left Encoder Distance: ", data);
	
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
