package org.usfirst.frc.team2852.robot.subsystems;

import org.usfirst.frc.team2852.robot.RobotMap;
import edu.wpi.first.wpilibj.AnalogInput;

import edu.wpi.first.wpilibj.DigitalInput;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.PIDSubsystem;


/**
 *
 */
public class Intake extends PIDSubsystem {
	public static double p = .6;
	public static double i = 0;
	public static double d = 0;
	public double downPosition = 0;
	public static final double INTAKE_OFFSET = .5;
	public static final double SPIT_OFFSET = 3.8;
	public static final double TUCK_OFFSET = 4.3;
	public PowerDistributionPanel pdp = new PowerDistributionPanel();
    Spark intakeRoller = new Spark(RobotMap.p_intakeRoller);
    Spark intakePivot = new Spark(RobotMap.p_intakePivot);
    DigitalInput breakbeam = new DigitalInput(0);
    public static AnalogInput absPosEncoder = new AnalogInput(RobotMap.p_absPosEncoder);
	
    public Intake() {
        super("Intake", p, i, d);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return absPosEncoder.getVoltage();
    }

    protected void usePIDOutput(double output) {
        intakePivot.set(output);
    }
    
    public void intake(double speed) {
    	intakeRoller.set(speed);
    }
    
    public void stopIntake() {
    	intakeRoller.set(0);
    }
    
    public void stopActuate() {
    	intakePivot.set(0);
    }
    
    public void actuate(double speed) {
    	intakePivot.set(speed);
    }
    
    public boolean isBeamBroken() {
    	return breakbeam.get();
    }
    
    public double getPot() {
    	return absPosEncoder.getVoltage();
    }
    
    public double getPivot() {
    	return intakePivot.get();
    }
    
    public void setDownPosition() {
    	downPosition = Intake.absPosEncoder.getVoltage();
    }
    
    public double getDownPosition() {
    	return downPosition;
    }
}
