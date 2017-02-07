package org.usfirst.frc.team2852.robot.subsystems;

import org.usfirst.frc.team2852.robot.Robot;
import org.usfirst.frc.team2852.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class Shooter extends PIDSubsystem {
	public static double p = .4;
	public static double i = 0.1;
	public static double d = 0;
    public static Spark shooterOuter = new Spark(RobotMap.p_intakeRoller);
    public static Spark shooterInner = new Spark(RobotMap.p_intakePivot);
    public static Spark shooterIntake = new Spark(RobotMap.p_shooterIntake);
    
    public static Encoder shooterInnerEnc = new Encoder(RobotMap.p_shooterInnerEncA, RobotMap.p_shooterOuterEncB);
    public static Encoder shooterOuterEnc = new Encoder(RobotMap.p_shooterOuterEncA, RobotMap.p_shooterOuterEncB);
    
    private double gain = 1;
    
  

    // Initialize your subsystem here
    

	public Shooter() {
    	super("Shooter", p, i, d);
    
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return shooterInnerEnc.getRate();
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	shooterInner.set(output);
    	shooterOuter.set(output*gain);
    }
    public void setGain(double gain) {
		this.gain = gain;
	}
    
    public void shoot(double powerInner, double powerOuter) {
    	shooterInner.set(powerInner);
    	shooterOuter.set(powerOuter);
    }
    
    public void stopShoot() {
    	shooterInner.set(0);
    	shooterOuter.set(0);
    }

}
