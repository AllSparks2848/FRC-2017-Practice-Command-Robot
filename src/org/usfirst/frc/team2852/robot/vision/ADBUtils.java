package org.usfirst.frc.team2852.robot.vision;

import org.spectrum3847.RIOdroid.RIOdroid;


//Code from spectrum 3847 (Look up riodroid on github)
public class ADBUtils{
	
	public static String adbReverseForward(int remotePort, int localPort) {
		try {
			return RIOdroid.executeCommand("adb reverse tcp:" + remotePort + " tcp:" + localPort);
		} catch(Exception e) {
			return e.getMessage();	
		}
	}
	
	public static void restartApp() {
		// TODO Restart app
	}
}