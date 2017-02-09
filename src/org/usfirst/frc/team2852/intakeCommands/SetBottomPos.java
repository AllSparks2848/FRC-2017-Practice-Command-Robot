package org.usfirst.frc.team2852.intakeCommands;

import org.usfirst.frc.team2852.robot.Robot;
import org.usfirst.frc.team2852.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetBottomPos extends Command {

    public SetBottomPos() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Robot.intake.setBottomPos(100*(Robot.intake.getPot()-4.8));
    	System.out.println("Bottom Position Set");
    	System.out.println("Spit Position: " + (Robot.intake.getBottomPos()));
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
