package org.usfirst.frc.team2852.robot.subsystems;

import org.usfirst.frc.team2852.robot.Robot;
import org.usfirst.frc.team2852.robot.RobotMap;
import edu.wpi.first.wpilibj.AnalogInput;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
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
	public double bottomPos = 2.11;
	public double intakePos = 2.0;
	public double spitPos = 3.45;
	public double tuckPos = .92;
	public PowerDistributionPanel pdp = new PowerDistributionPanel();
    public Spark intakeRoller = new Spark(RobotMap.p_intakeRoller);
    public Spark intakePivot = new Spark(RobotMap.p_intakePivot);
    DigitalInput breakbeam = new DigitalInput(RobotMap.p_breakbeam);
    public static AnalogInput absPosEncoder = new AnalogInput(RobotMap.p_absPosEncoder);
    
    public double currentPosition = 0;
    public double zeroPosition = 0;
    public final double INTAKE_OFFSET = .03;
    public final double SPIT_OFFSET = 3.41;
    public final double TUCK_OFFSET = 5.94;
    
    public Timer timer = new Timer();
	
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
    
    public void setBottomPos() {
    	bottomPos = absPosEncoder.getVoltage();
    	if(bottomPos < INTAKE_OFFSET) {
    		zeroPosition = .5; //.5 means between 0 and 1
    		intakePos = 4.75 - (INTAKE_OFFSET - bottomPos);
    		spitPos = 4.75 - (SPIT_OFFSET - bottomPos);
    		tuckPos = 4.75 - (TUCK_OFFSET - bottomPos);
    	} else if(bottomPos < SPIT_OFFSET) {
    		zeroPosition = 1.5;
    		intakePos = 4.75 - INTAKE_OFFSET;
    		spitPos = 4.75 - (SPIT_OFFSET - bottomPos);
    		tuckPos = 4.75 - (TUCK_OFFSET - bottomPos);
    	} else if(bottomPos < TUCK_OFFSET) {
    		zeroPosition = 2.5;
    		intakePos = 4.75 - INTAKE_OFFSET;
    		spitPos = 4.75 - SPIT_OFFSET;
    		tuckPos = 4.75 - (TUCK_OFFSET - bottomPos);
    	} 
//    	else {
//    		intakePos = 4.75 - INTAKE_OFFSET;
//    		spitPos = 4.75 - SPIT_OFFSET;
//    		tuckPos = 4.75 - TUCK_OFFSET;
//    	}
    	
    }
    
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
