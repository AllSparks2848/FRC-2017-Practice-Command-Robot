package org.usfirst.frc.team2852.robot.subsystems;

import org.usfirst.frc.team2852.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

/**
 *
 */
public class Intake extends PIDSubsystem {
	public static double p = 0;
	public static double i = 0;
	public static double d = 0;
	public static double MAXUP = 0.0;
	public static double MAXDOWN = 0.0;
	public PowerDistributionPanel pdp = new PowerDistributionPanel();
    Spark intakeRoller = new Spark(RobotMap.p_intakeRoller);
    Spark intakePivot = new Spark(RobotMap.p_intakePivot);
    DigitalInput breakbeam = new DigitalInput(9);
    public static Potentiometer pot = new AnalogPotentiometer(RobotMap.p_potentiometer, 360, -30);
	
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
        return pot.get();
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
    	return pot.get();
    }
}
