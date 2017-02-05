package org.usfirst.frc.team2852.robot.commands;

import org.usfirst.frc.team2852.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class IntakeToPosition extends CommandGroup {

    public IntakeToPosition(int targetPosition) {
    	if(Robot.intake.getCurrentPosition() == 3 && targetPosition == 2) {
    		addSequential(new IntakePID(3.45));
    	} else if(Robot.intake.getCurrentPosition() == 2 && targetPosition == 3) {
    		addSequential(new IntakePID(.4));
    	} else if (Robot.intake.getCurrentPosition() == 3) {
    		addSequential(new IntakePID(4.7));
    		addSequential(new Nudge(1));
    		if (targetPosition == 0) {
    			addSequential(new IntakePID(4.7));	
    		} 
    		else if (targetPosition == 1) {
    			addSequential(new IntakePID(4.67));
    		}
    		else if (targetPosition == 2) {
    			addSequential(new IntakePID(1.32));
    		}
    		
    	}
    	else if (targetPosition == 3) {
    		addSequential(new IntakePID(4.75));
    		addSequential(new Nudge(-1));
    		addSequential(new IntakePID(3.62));
    	}
    	else if(targetPosition == 2){
    		addSequential(new IntakePID(1.32));
    	}
    	else if(targetPosition == 1) {
    		addSequential(new IntakePID(4.67));
    	}
    	else {
    		addSequential(new IntakePID(4.7));
    	}
    }
}
