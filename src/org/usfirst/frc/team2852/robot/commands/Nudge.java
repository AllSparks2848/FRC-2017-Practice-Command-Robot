package org.usfirst.frc.team2852.robot.commands;

import org.usfirst.frc.team2852.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Nudge extends Command {
	private int direction;

    public Nudge(int direction) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.intake);
    	this.direction=direction;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.intake.actuate(direction); //NEGATIVE DIRECTION IS UP
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(direction == 1) {
    		return Robot.intake.getPot() < .3;
    	}
    	else {
    		return Robot.intake.getPot() > 4.5;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
