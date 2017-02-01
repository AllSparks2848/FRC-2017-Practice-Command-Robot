package org.usfirst.frc.team2852.robot.subsystems;

import org.usfirst.frc.team2852.robot.RobotMap;
import org.usfirst.frc.team2852.robot.commands.ArcadeDrive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class DriveTrain extends PIDSubsystem {
	Spark leftDrive1 = new Spark(RobotMap.p_leftDrive1);
	Spark leftDrive2 = new Spark(RobotMap.p_leftDrive2);
	Spark leftDrive3 = new Spark(RobotMap.p_leftDrive3);
	Spark rightDrive1 = new Spark(RobotMap.p_rightDrive1);
	Spark rightDrive2 = new Spark(RobotMap.p_rightDrive2);
	Spark rightDrive3 = new Spark(RobotMap.p_rightDrive3);
	
	RobotDrive drive1 = new RobotDrive(leftDrive1, leftDrive2, rightDrive1, rightDrive2);
	RobotDrive drive2 = new RobotDrive(leftDrive3, rightDrive3);
	
	Solenoid frontButterfly = new Solenoid(RobotMap.p_frontButterfly);
	Solenoid backButterfly = new Solenoid(RobotMap.p_backButterfly);
	
	private static double pDrive = .07;
	private static double iDrive = 0;
	private static double dDrive = .007;
	
	public static Encoder rightEncoder = new Encoder(RobotMap.p_rightEncoderA, RobotMap.p_rightEncoderB, false, Encoder.EncodingType.k4X);
	public static Encoder leftEncoder = new Encoder(RobotMap.p_leftEncoderA, RobotMap.p_leftEncoderB, false, Encoder.EncodingType.k4X);
	
    // Initialize your subsystem here
    public DriveTrain() {
    	super("DriveTrain", pDrive, iDrive, dDrive);
    	leftEncoder.setDistancePerPulse(-0.01057);
    	rightEncoder.setDistancePerPulse(.01125);
    }

    public void initDefaultCommand() {
         setDefaultCommand(new ArcadeDrive());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return (leftEncoder.getDistance()+rightEncoder.getDistance())/2;
    }

    protected void usePIDOutput(double output) {
    	drive1.tankDrive(output, output);
    	drive2.tankDrive(output, output);
    }
    
    public void tankDrive(double left, double right){
    	drive1.tankDrive(left, right);
    	drive2.tankDrive(left, right);
    }
    
    public void arcadeDrive(double left, double right){
    	drive1.arcadeDrive(left, right);
    	drive2.arcadeDrive(left, right);
    }
    
    public void setPowerZero(){
    	drive1.setLeftRightMotorOutputs(0, 0);;
    	drive2.setLeftRightMotorOutputs(0, 0);
    }
    
    public void frontOmnisDown() {
    	frontButterfly.set(true);
    }
    
    public void backOmnisDown() {
    	backButterfly.set(true);
    }
    
    public void frontAllDown() {
    	frontButterfly.set(false);
    }
    
    public void backAllDown() {
    	backButterfly.set(false);
    }
}

