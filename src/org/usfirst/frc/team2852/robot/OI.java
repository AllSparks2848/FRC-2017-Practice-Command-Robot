package org.usfirst.frc.team2852.robot;

import org.usfirst.frc.team2852.driveCommands.AllDown;
import org.usfirst.frc.team2852.driveCommands.AllOmnis;
import org.usfirst.frc.team2852.driveCommands.ShiftHigh;
import org.usfirst.frc.team2852.driveCommands.ShiftLow;
import org.usfirst.frc.team2852.intakeCommands.IntakeDown;
import org.usfirst.frc.team2852.intakeCommands.IntakeGear;
import org.usfirst.frc.team2852.intakeCommands.IntakeUp;
import org.usfirst.frc.team2852.intakeCommands.Nudge;
import org.usfirst.frc.team2852.intakeCommands.PrintEnc;
import org.usfirst.frc.team2852.intakeCommands.SpitGear;
import org.usfirst.frc.team2852.shooterCommands.Elevate;
import org.usfirst.frc.team2852.shooterCommands.ElevateAndShoot;
import org.usfirst.frc.team2852.shooterCommands.ManualShoot;
import org.usfirst.team2852.robot.util.XboxTrigger;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	Joystick xbox1 = new Joystick(RobotMap.p_xbox1);
	Joystick xbox2 = new Joystick(RobotMap.p_xbox2);
	Joystick buttonBox = new Joystick(RobotMap.p_buttonBox);
	
//	Controller 1
	Button a1 = new JoystickButton(xbox1, 1);
	Button b1 = new JoystickButton(xbox1, 2);
	Button x1 = new JoystickButton(xbox1, 3);
	Button y1 = new JoystickButton(xbox1, 4);
	
	XboxTrigger lTrig1 = new XboxTrigger(xbox1, 2);
	XboxTrigger rTrig1 = new XboxTrigger(xbox1, 3);
	Button lBump1 = new JoystickButton(xbox1, 5);
	Button rBump1 = new JoystickButton(xbox1, 6);
	
//	Button clickLeft = new JoystickButton(xbox1, 9);
//	Button clickRight = new JoystickButton(xbox1, 10);
	
//	Controller 2
	Button a2 = new JoystickButton(xbox2, 1);
	Button b2 = new JoystickButton(xbox2, 2);
	Button x2 = new JoystickButton(xbox2, 3);
	Button y2 = new JoystickButton(xbox2, 4);
	
	Button start = new JoystickButton(xbox2, 8);
	
	Button lBump2 = new JoystickButton(xbox2, 5);
	Button rBump2 = new JoystickButton(xbox2, 6);
	XboxTrigger lTrig2 = new XboxTrigger(xbox2, 2);
	XboxTrigger rTrig2 = new XboxTrigger(xbox2, 3);
	
	Button clickRight2 = new JoystickButton(xbox2, 10);
	
//	Button bOx
	Button bb1 = new JoystickButton(buttonBox, 6);
	Button bb2 = new JoystickButton(buttonBox, 4);
	Button bb3 = new JoystickButton(buttonBox, 2);
	Button bb4 = new JoystickButton(buttonBox, 5);
	Button bb5 = new JoystickButton(buttonBox, 3);
	Button bb6 = new JoystickButton(buttonBox, 1);
	Button bb7 = new JoystickButton(buttonBox, 7);
	Button bb8 = new JoystickButton(buttonBox, 9);
	Button bb9 = new JoystickButton(buttonBox, 8);
	
	public OI() {	
	lBump1.whenPressed(new ShiftHigh());
	lTrig1.whenPressed(new ShiftLow());
	rBump1.whenPressed(new AllDown());
	rTrig1.whenPressed(new AllOmnis());
	
//	lTrig2.whenPressed(new IntakeUp());
//	lBump2.whenPressed(new IntakeDown());
	
	bb9.whileHeld(new SpitGear());
	bb6.whileHeld(new IntakeDown());
	bb3.whileHeld(new IntakeUp());
	bb8.whenPressed(new IntakeGear());
	
	//b2.whileHeld(new PIDShoot (400));
	
//	bb1.whenPressed(new IntakePID(Robot.intake.getBottomPos())); 
//	bb2.whenPressed(new IntakePID(Robot.intake.getIntakePos()));
//	bb4.whenPressed(new IntakePID(Robot.intake.getSpitPos()));
//	bb5.whenPressed(new IntakePID(Robot.intake.getTuckPos()));
	
	bb1.whileHeld(new Elevate());
	bb2.whileHeld(new ManualShoot(-1,1));
	bb7.whileHeld(new ElevateAndShoot());
	
	//start.whenPressed(new SetBottomPos());
	
	a2.whenPressed(new Nudge(1));
	clickRight2.whileHeld(new PrintEnc());
	}
	public double getThrottle(){
		return xbox1.getRawAxis(1);
	}
	public double getTurn(){
		return xbox1.getRawAxis(4);
	}
	
	public double getLeftJoystick() {
		return xbox1.getRawAxis(1);
	}
//	public boolean getQuickTurn() {
//		return xbox1.getRawButton(button);
//	}
	
	public double getRightJoystick() {
		return xbox1.getRawAxis(4);
	}
}
