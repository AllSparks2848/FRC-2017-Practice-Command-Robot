package org.usfirst.frc.team2852.robot;



import org.usfirst.frc.team2852.robot.commands.AllDown;
import org.usfirst.frc.team2852.robot.commands.shiftDown;
import org.usfirst.frc.team2852.robot.commands.shiftUp;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	Joystick xbox1 = new Joystick(RobotMap.p_xbox1);
	Button a = new JoystickButton(xbox1, 1);
	Button b = new JoystickButton(xbox1, 2);
	Button x = new JoystickButton(xbox1, 3);
	Button y = new JoystickButton(xbox1, 4);
//	Button clickLeft = new JoystickButton(xbox1, );
//	Button clickRight = new JoystickButton(xbox1, );
	
	Button lBump = new JoystickButton(xbox1, 5);
	Button rBump = new JoystickButton(xbox1, 6);
	
	public OI() {
	rBump.whenPressed(new shiftUp());	
	lBump.whenPressed(new shiftDown());
	}
	
	public double getLeftJoystick() {
		return xbox1.getRawAxis(1);
	}
	
	public double getRightJoystick() {
		return xbox1.getRawAxis(4);
	}
	
	//D-pad: if(xbox1.getPOV==Angle) --> new Command();
	//Trigger: Create Trigger, then use ".whileActive(new Command());"
	
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
