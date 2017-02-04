package org.usfirst.frc.team2852.robot.commands;

import org.usfirst.frc.team2852.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakePID extends Command {
	private double setpoint;
	
    public IntakePID(double setpoint) {
    	this.setpoint = setpoint;
        requires(Robot.intake);
        Robot.intake.setSetpoint(setpoint);
    }

    protected void initialize() {
    	Robot.intake.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	System.out.println("Potentiometer Reading: " + Robot.intake.getPot());
    	System.out.println("Motor Power: " + Robot.intake.getPivot());
        return (Math.abs((setpoint - Robot.intake.getPot())) < .1);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.intake.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
