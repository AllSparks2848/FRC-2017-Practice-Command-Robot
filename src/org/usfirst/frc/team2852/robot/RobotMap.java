package org.usfirst.frc.team2852.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	//Joy stick ports
	public static int p_xbox1 = 0;
	public static int p_xbox2 = 1;
	public static int p_buttonBox = 2;
	
	//Actuator ports
	public static int p_rightDrive1 = 0;
	public static int p_rightDrive2 = 1;
	public static int p_rightDrive3 = 2;
	public static int p_leftDrive1 = 3;
	public static int p_leftDrive2 = 4;
	public static int p_leftDrive3 = 5;
	
	public static int p_intakeRoller = 6;
	public static int p_intakePivot = 7;
	
	public static int p_shooterFront = 8;
	public static int p_shooterBack = 9;
	public static int p_elevator = 10;
	
	public static int p_climb1 = 11;
	public static int p_climb2 = 12;
	//pneumatics
	public static int p_frontButterfly1 = 0;
	public static int p_frontButterfly2 = 1;
	public static int p_backButterfly1 = 2;
	public static int p_backButterfly2 = 3;
	public static int p_driveshifter1 = 4;
	public static int p_driveshifter2 = 5;
	
	//Sensor ports
	public static int p_leftEncoderA = 0;
	public static int p_leftEncoderB = 1;
	public static int p_rightEncoderA = 3;
	public static int p_rightEncoderB = 2;
	public static int p_absPosEncoder = 4;
	public static int p_shooterFrontEncA = 5;
	public static int p_shooterFrontEncB = 6;
	public static int p_shooterBackEncA = 7;
	public static int p_shooterBackEncB = 8;
	
	//Digital Input
	public static int p_breakbeam = 0;
	
}
