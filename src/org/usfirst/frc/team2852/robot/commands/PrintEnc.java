package org.usfirst.frc.team2852.robot.commands;

import org.usfirst.frc.team2852.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PrintEnc extends Command {

    public PrintEnc() {
    	requires(Robot.intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("Potentiometer Reading: " + Robot.intake.getPot());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("Potentiometer Reading: " + Robot.intake.getPot());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	System.out.println("Potentiometer Reading: " + Robot.intake.getPot());
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}