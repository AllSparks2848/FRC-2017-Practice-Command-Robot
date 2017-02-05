package org.usfirst.frc.team2852.robot.subsystems;

import org.usfirst.frc.team2852.robot.Robot;
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
	public static double p = .4;
	public static double i = 0.1;
	public static double d = 0;
	public static double bottomPos = 2.11;
	public static double intakePos = 2.0;
	public static double spitPos = 3.45;
	public static double tuckPos = .92;
	public PowerDistributionPanel pdp = new PowerDistributionPanel();
    Spark intakeRoller = new Spark(RobotMap.p_intakeRoller);
    Spark intakePivot = new Spark(RobotMap.p_intakePivot);
    DigitalInput breakbeam = new DigitalInput(0);
    public static AnalogInput absPosEncoder = new AnalogInput(RobotMap.p_absPosEncoder);
    
    public double currentPosition = 0;
	
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
        return Robot.intake.getPot();
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
    
    public void setCurrentPosition(int newPosition) {
    	currentPosition = newPosition;
    }
    
    public double getCurrentPosition() {
    	return currentPosition;
    }
    
    public double getBottomPos() {
    	return bottomPos;
    }
    
//    public void setBottomPos(double newBottom) {
//    	bottomPos = newBottom;
//    	intakePos = .122 + bottomPos;
//    	spitPos = .492 + bottomPos;
//    	tuckPos = .732 + bottomPos;
//    	
//    }
    
    public double getIntakePos() {
    	return intakePos;
    }
    
    public double getSpitPos() {
    	return spitPos;
    }
    
    public double getTuckPos() {
    	return tuckPos;
    }
}
