package org.usfirst.frc.team2852.robot.subsystems;

import org.usfirst.frc.team2852.driveCommands.ArcadeDrive;
import org.usfirst.frc.team2852.robot.RobotMap;
import org.usfirst.team2852.robot.util.Rotation2d;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrain extends PIDSubsystem {
	public Spark leftDrive1 = new Spark(RobotMap.p_leftDrive1);
	public Spark leftDrive2 = new Spark(RobotMap.p_leftDrive2);
	public Spark leftDrive3 = new Spark(RobotMap.p_leftDrive3);
	public Spark rightDrive1 = new Spark(RobotMap.p_rightDrive1);
	public Spark rightDrive2 = new Spark(RobotMap.p_rightDrive2);
	public Spark rightDrive3 = new Spark(RobotMap.p_rightDrive3);
	public AHRS gyro=new AHRS(SPI.Port.kMXP);
	
	RobotDrive drive1 = new RobotDrive(leftDrive1, leftDrive2, rightDrive1, rightDrive2);
	RobotDrive drive2 = new RobotDrive(leftDrive3, rightDrive3);
	
	DoubleSolenoid frontButterfly = new DoubleSolenoid(RobotMap.p_frontButterfly1, RobotMap.p_frontButterfly2);
	DoubleSolenoid backButterfly = new DoubleSolenoid(RobotMap.p_backButterfly1, RobotMap.p_backButterfly2);
	DoubleSolenoid driveShifter = new DoubleSolenoid(RobotMap.p_driveshifter1, RobotMap.p_driveshifter2);
	
	private static double pDrive = .07;
	private static double iDrive = 0;
	private static double dDrive = .007;
	 private int leftEncoderZero, rightEncoderZero;
	    private boolean leftReverseEnc = false;
	    private boolean rightReverseEnc = true;
	    private int leftEncSign = 1;
	    private int rightEncSign = -1;
	    
	    private boolean isHighGear = false;
	   
	    
	    public double kPHigh = 0, kIHigh = 0, kDHigh = 0;
	    public double kPLow = 0, kILow = 0, kDLow = 0;
	    public double kP = kPLow, kI = kILow, kD = kDLow;
	    public double kFLowLeft = 1.316, kFLowRight = 1.340;
	    public double kFHighLeft = 0.456, kFHighRight = 0.465;
		public double kFLeft = kFLowLeft, kFRight = kFLowRight;
		double pPos = 0, iPos = 0, fPos = 0;
		int iZone = 0;
		
		private static final double WHEEL_DIAMETER_IN = 3.95; // Measured
		private static final int COUNTS_PER_REV = 360; // Quadrature counts = 1440
		
		double leftSetpoint, rightSetpoint;
		double tolerance = 4.0 / COUNTS_PER_REV;
	
//	public static Encoder rightEncoder = new Encoder(RobotMap.p_rightEncoderA, RobotMap.p_rightEncoderB, false, Encoder.EncodingType.k4X);
//	public static Encoder leftEncoder = new Encoder(RobotMap.p_leftEncoderA, RobotMap.p_leftEncoderB, false, Encoder.EncodingType.k4X);
	
    // Initialize your subsystem here
    public DriveTrain() {
    	super("DriveTrain", pDrive, iDrive, dDrive);
//    	leftEncoder.setDistancePerPulse(-0.01057);
//    	rightEncoder.setDistancePerPulse(.01125);
    }

    public void initDefaultCommand() {
         setDefaultCommand(new ArcadeDrive());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
//        return (leftEncoder.getDistance()+rightEncoder.getDistance())/2;
    	return 0;
    }

    protected void usePIDOutput(double output) {
    	drive1.tankDrive(output, output);
    	drive2.tankDrive(output, output);
    }
    
    public void tankDrive(double left, double right){
    	drive1.tankDrive(left, right);
    	drive2.tankDrive(left, right);
    }
    
    public void arcadeDrive(double left, double right){
    	drive1.arcadeDrive(-left, -right);
    	drive2.arcadeDrive(-left, -right);
    }
    
    public void setPowerZero(){
    	drive1.setLeftRightMotorOutputs(0, 0);;
    	drive2.setLeftRightMotorOutputs(0, 0);
    }
    
    public void frontOmnisDown() {
    	frontButterfly.set(DoubleSolenoid.Value.kForward);
    }
    
    public void backOmnisDown() {
    	backButterfly.set(DoubleSolenoid.Value.kForward);
    }
    
    public void frontAllDown() {
    	frontButterfly.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void backAllDown() {
    	backButterfly.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void shiftHigh() {
    	driveShifter.set(DoubleSolenoid.Value.kForward);
    }
    
    public void shiftLow() {
    	driveShifter.set(DoubleSolenoid.Value.kReverse);
    }

	/*
	public void stop() {
		setMotorsRaw(0,0);
	}
	
	// Converts inches/second to motor percentage using feed-forward term
	public void setMotorsInchesPerSecondOpenLoop(double left, double right) {
		double leftSpeed = kFLeft * inchesPerSecondToRPM(left) * COUNTS_PER_REV / 1023 / 60;
		double rightSpeed = kFRight * inchesPerSecondToRPM(right) * COUNTS_PER_REV / 1023 / 60;
		
		setMotors(leftSpeed, rightSpeed);
	}
	
	public void setMotors(double left, double right) {
		left = scaleLeft(left);
		right = scaleRight(right);
		
		setMotorsRaw(left, right);
	}

	public void setMotorsRaw(double left, double right) {
		left = safetyTest(left);
		right = safetyTest(right);
		
		leftDrive1.set(left);
		leftDrive2.set(left);
		leftDrive3.set(left);
		rightDrive1.set(right);
		rightDrive2.set(right);
		rightDrive3.set(right);
				
	}
	
	private double safetyTest(double motorValue) {
	    motorValue = (motorValue < -1) ? -1 : motorValue;
	    motorValue = (motorValue > 1) ? 1 : motorValue;
	    
	    return motorValue;
	}
	*/
	
/*
	
	
	
	public boolean nearSetpoint() {
		double currentLeftPosition = leftMotorFront.getPosition();
		boolean nearLeft = Math.abs(leftSetpoint - currentLeftPosition) < tolerance;
		
		double currentRightPosition = rightMotorFront.getPosition();
		boolean nearRight = Math.abs(rightSetpoint - currentRightPosition) < tolerance;
		
		return nearLeft && nearRight;
	}
	
	private double scaleLeft(double left) {
		return left;
	}
	
	private double scaleRight(double right) {
		return right;
	}
	
	public void resetEncoders() {
		leftEncoderZero = leftEncMotor.getEncPosition();
		rightEncoderZero = rightEncMotor.getEncPosition();
	}
	
	public int getLeftEncoder() {
		return leftEncSign * (leftEncMotor.getEncPosition() - leftEncoderZero);
	}
	
	public int getRightEncoder() {
		return rightEncSign * (rightEncMotor.getEncPosition() - rightEncoderZero);
	}
	
	public double getLeftPositionInches() {
		double rotations = ((double) getLeftEncoder()) / (4 * COUNTS_PER_REV);
		
		return rotationsToInches(rotations);
	}
	
	public double getRightPositionInches() {
		double rotations = ((double) getRightEncoder()) / (4 * COUNTS_PER_REV);
		
		return rotationsToInches(rotations);
	}
	
	public double getLeftVelocity() {
		return leftEncMotor.getSpeed();
	} 
	
	public double getRightVelocity() {
		return rightEncMotor.getSpeed();
	}
	
	public double getLeftVelocityInchesPerSecond() {
		return rpmToInchesPerSecond(getLeftVelocity());
	}
	
	public double getRightVelocityInchesPerSecond() {
		return rpmToInchesPerSecond(getRightVelocity());
	}
	
	public boolean isLeftEncPresent() {
		return !(leftEncMotor.isSensorPresent(FeedbackDevice.QuadEncoder) == FeedbackDeviceStatus.FeedbackStatusPresent);
	}
	
	public boolean isRightEncPresent() {
		return !(rightEncMotor.isSensorPresent(FeedbackDevice.QuadEncoder) == FeedbackDeviceStatus.FeedbackStatusPresent);
	}
	
	
	
	

	
	
	
	
	
	
	
	private double rotationsToInches(double rotations) {
		return rotations * (Math.PI * WHEEL_DIAMETER_IN);
	}
	
	private double inchesToRotations(double inches) {
		return inches / (Math.PI * WHEEL_DIAMETER_IN);
	}
	
	private double rpmToInchesPerSecond(double rpm) {
		return rotationsToInches(rpm) / 60;
	}
	
	private double inchesPerSecondToRPM(double inchesPerSecond) {
		return inchesToRotations(inchesPerSecond * 60);
	}*/
	public Rotation2d getGyro() {
		SmartDashboard.putData("IMU", gyro);
		
		return Rotation2d.fromDegrees(gyro.getAngle());
	}
	
	public void resetGyro() {
		gyro.reset();
	}
}

