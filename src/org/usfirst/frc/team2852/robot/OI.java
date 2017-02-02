package org.usfirst.frc.team2852.robot;

import org.usfirst.frc.team2852.robot.commands.AllDown;
import org.usfirst.frc.team2852.robot.commands.AllOmnis;
import org.usfirst.frc.team2852.robot.commands.IntakeDown;
import org.usfirst.frc.team2852.robot.commands.IntakeGear;
import org.usfirst.frc.team2852.robot.commands.IntakePID;
import org.usfirst.frc.team2852.robot.commands.IntakeUp;
import org.usfirst.frc.team2852.robot.commands.SpitGear;
import org.usfirst.frc.team2852.robot.commands.ShiftLow;
import org.usfirst.frc.team2852.robot.commands.ShiftHigh;
import org.usfirst.team2852.robot.util.XboxTrigger;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	Joystick xbox1 = new Joystick(RobotMap.p_xbox1);
	Joystick xbox2 = new Joystick(RobotMap.p_xbox2);
	
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
	
	Button lBump2 = new JoystickButton(xbox2, 5);
	Button rBump2 = new JoystickButton(xbox2, 6);
	XboxTrigger lTrig2 = new XboxTrigger(xbox2, 2);
	XboxTrigger rTrig2 = new XboxTrigger(xbox2, 3);
	
	
	public OI() {	
	lBump1.whenPressed(new ShiftHigh());
	lTrig1.whenPressed(new ShiftLow());
	rBump1.whenPressed(new AllDown());
	rTrig1.whenPressed(new AllOmnis());
	
	rBump2.whileHeld(new SpitGear());
	lBump2.whileHeld(new IntakeUp());
	lTrig2.whileHeld(new IntakeDown());
	rTrig2.whileHeld(new IntakeGear());
	
	a2.whenPressed(new IntakePID(1000.0));
	}
	
	public double getLeftJoystick() {
		return xbox1.getRawAxis(1);
	}
	
	public double getRightJoystick() {
		return xbox1.getRawAxis(4);
	}
}
