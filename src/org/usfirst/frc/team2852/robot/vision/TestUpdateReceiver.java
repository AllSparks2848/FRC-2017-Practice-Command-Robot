package org.usfirst.frc.team2852.robot.vision;

import java.util.List;

import org.usfirst.frc.team2852.robot.Robot;

public class TestUpdateReceiver implements VisionUpdateReceiver {

	@Override
	public void gotUpdate(VisionUpdate update) {
		List<TargetInfo> targets = update.getTargets();
		
		System.out.println("Vision update received (Time: " + update.getCapturedAgoMs() + ")");
		for(int i = 0; i < targets.size(); i++) {
			System.out.println("\tTarget recieved (x: " + targets.get(i).getX() + ", y: " + targets.get(i).getY() + 
					", distance: " + targets.get(i).getDistance() + ")");
			if(targets.get(i).getX()<.01){
				Robot.drivetrain.leftDrive1.set(.4);
				Robot.drivetrain.leftDrive2.set(.4);
				Robot.drivetrain.leftDrive3.set(.4);
				Robot.drivetrain.rightDrive1.set(-(.4+(.01-targets.get(i).getX())));
				Robot.drivetrain.rightDrive2.set(-(.4+(.01-targets.get(i).getX())));
				Robot.drivetrain.rightDrive3.set(-(.4+(.01-targets.get(i).getX())));
			}
			if(targets.get(i).getX()>.01){
				Robot.drivetrain.leftDrive1.set((.4+(targets.get(i).getX()-.01)));
				Robot.drivetrain.leftDrive2.set((.4+(targets.get(i).getX()-.01)));
				Robot.drivetrain.leftDrive3.set((.4+(targets.get(i).getX()-.01)));
				Robot.drivetrain.rightDrive1.set(-.4);
				Robot.drivetrain.rightDrive2.set(-.4);
				Robot.drivetrain.rightDrive3.set(-.4);
			}
		}
	}
}
