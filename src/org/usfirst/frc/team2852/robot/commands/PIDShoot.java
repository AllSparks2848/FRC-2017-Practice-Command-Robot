package org.usfirst.frc.team2852.robot.commands;

import org.usfirst.frc.team2852.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PIDShoot extends Command {
public static int setpoint;
    public PIDShoot(int setpoint) {
    	this.setpoint = setpoint;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.shooter);
    	Robot.shooter.setOutputRange(-1, 1);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.shooter.setSetpoint(setpoint);
    	Robot.shooter.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
   
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	System.out.println("Shooter Inner Encoder Rate: "+Robot.shooter.shooterInnerEnc.getRate());
    	System.out.println("Inner Motor Speed: "+Robot.shooter.shooterInner.getSpeed());
    	System.out.println("Shooter Outer Encoder Rate: "+Robot.shooter.shooterOuterEnc.getRate());
    	System.out.println("Outer Motor Speed: "+Robot.shooter.shooterOuter.getSpeed());
    	System.out.println();
    	
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
