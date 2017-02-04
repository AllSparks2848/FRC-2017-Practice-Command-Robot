package org.usfirst.frc.team2852.robot;

import org.usfirst.frc.team2852.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2852.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	public static OI oi;
	public static RobotMap robot = new RobotMap();

	Command autonomousCommand;

	public static DriveTrain drivetrain = new DriveTrain();
	public static Intake intake = new Intake();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		//autonomousCommand = new AutonGearLeft();
		oi = new OI();
		SmartDashboard.putData(Scheduler.getInstance());
		SmartDashboard.putData(drivetrain);
		
		//temporary:
		boolean teamRed = true, shoot = true, hopper = false;
		int pos = 1;
		
		int state = (teamRed ? 1 : 0) + (shoot ? 2 : 0) + (hopper ? 4 : 0);
		
		switch(state){
		case 0:
			//Blue team, not shooting, no hopper
			break;
		case 1:
			//Red team, not shooting, no hopper
			break;
		case 2:
			//Blue team, shooting, no hopper
			break;
		case 3:
			//Red team, shooting, no hopper
			break;
		case 4:
			//Blue team, not shooting, using hopper
			break;
		case 5:
			//Red team, not shooting, using hopper
			break;
		case 6:
			//Blue team, shooting, using hopper
			break;
		case 7:
			//Red team, shooting, using hopper
			break;
		default:
			//value of state does not match with any cases
			try {
				throw new Exception(String.join("\n",
						"Unexpected Error: variable 'state' did not match any cases:",
						"\tteamRed: " + teamRed + (teamRed ? " (Red)" : " (Blue)"),
						"\tshoot: " + shoot,
						"\thopper: " + hopper
						));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		// schedule the autonomous command (example)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
			autonomousCommand.cancel();
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}
	
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
