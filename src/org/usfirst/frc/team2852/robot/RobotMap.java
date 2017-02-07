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
	public static int p_leftDrive1 = 3;
	public static int p_leftDrive2 = 4;
	public static int p_leftDrive3 = 5;
	public static int p_rightDrive1 = 0;
	public static int p_rightDrive2 = 1;
	public static int p_rightDrive3 = 2;
	public static int p_intakeRoller = 6;
	public static int p_intakePivot = 7;
//	public static int p_climber1 = 9;
//	public static int p_climber2 = 10;
	public static int p_shooterInner =8;
	public static int p_shooterOuter = 9;
	public static int p_shooterIntake =10;
	
	public static int p_driveshifter1 = 4;
	public static int p_driveshifter2 = 5;
	public static int p_frontButterfly1 = 0;
	public static int p_frontButterfly2 = 1;
	public static int p_backButterfly1 = 2;
	public static int p_backButterfly2 = 3;
	
	//Sensor ports
//	public static int p_leftEncoderA = 0;
//	public static int p_leftEncoderB = 1;
//	public static int p_rightEncoderA = 3;
//	public static int p_rightEncoderB = 2;
	public static int p_absPosEncoder = 1;
	public static int p_shooterInnerEncA =2;
	public static int p_shooterInnerEncB =3;
	public static int p_shooterOuterEncA =4;
	public static int p_shooterOuterEncB =5;
}
