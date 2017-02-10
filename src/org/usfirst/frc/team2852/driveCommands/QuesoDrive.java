package org.usfirst.frc.team2852.driveCommands;

import org.usfirst.frc.team2852.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class QuesoDrive extends Command {

    public QuesoDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	Robot.drivetrain.arcadeDrive(Robot.mQuesoDriveHelper.quesoDrive(Robot.oi.getThrottle(), Robot.oi.getTurn(), Robot.oi.getQuickTurn()).leftMotor,Robot.mQuesoDriveHelper.quesoDrive(Robot.oi.getThrottle(), Robot.oi.getTurn(), Robot.oi.getQuickTurn()).rightMotor);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.setPowerZero();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}

