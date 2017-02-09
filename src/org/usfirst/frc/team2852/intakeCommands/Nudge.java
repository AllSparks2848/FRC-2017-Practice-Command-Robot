package org.usfirst.frc.team2852.intakeCommands;

import org.usfirst.frc.team2852.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Nudge extends Command {

    public Nudge() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.intake.timer.start();
    	Robot.intake.intakePivot.set(1);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.intake.timer.get() > .05;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.intake.stopActuate();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
