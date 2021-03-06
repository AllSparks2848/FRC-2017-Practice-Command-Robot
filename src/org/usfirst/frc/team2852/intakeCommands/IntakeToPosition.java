package org.usfirst.frc.team2852.intakeCommands;

import org.usfirst.frc.team2852.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class IntakeToPosition extends CommandGroup {

    public IntakeToPosition(int targetPosition) {
    	if(Robot.intake.getCurrentPosition() == 3 && targetPosition == 2) {
    		addSequential(new IntakePID(Robot.intake.spitPos));
    	} else if(Robot.intake.getCurrentPosition() == 2 && targetPosition == 3) {
    		addSequential(new IntakePID(Robot.intake.tuckPos));
    	} else if (Robot.intake.getCurrentPosition() == 3 || Robot.intake.getCurrentPosition() == 2) {
    		addSequential(new IntakePID(4.7)); //move intake to edge of zero line
    		addSequential(new Nudge(1)); //move across the zero line towards the floor
    		if (targetPosition == 0) {
    			addSequential(new IntakePID(Robot.intake.bottomPos));	
    		} 
    		else {
    			addSequential(new IntakePID(Robot.intake.bottomPos));
    		}
    	} else if (targetPosition == 3) {
    		addSequential(new IntakePID(0.1)); //move to border of zero

    		addSequential(new IntakePID(Robot.intake.tuckPos));
    	} else if(targetPosition == 2) {
    		addSequential(new IntakePID(0.1)); //move to border
    		addSequential(new Nudge(-1)); //move across the border upwards
    		addSequential(new IntakePID(Robot.intake.spitPos));
    	} else if(targetPosition == 1) {
    		addSequential(new IntakePID(Robot.intake.intakePos));
    	}
    	else {
    		addSequential(new IntakePID(Robot.intake.bottomPos));
    	}
    	Robot.intake.setCurrentPosition(targetPosition);
    }
}
