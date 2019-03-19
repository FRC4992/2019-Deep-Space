/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

// import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.ArcadeDrive;

/**
 * Add your docs here.
 */
public class Drive extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  CANSparkMax frontLeft, frontRight, backLeft, backRight;
  SpeedControllerGroup left, right;
  DifferentialDrive drive;
  // DoubleSolenoid leftGearShifter, rightGearShifter;
  DoubleSolenoid shifter;
  public static final int FULL_SPEED = 0;
  public static final int SLOW_SPEED = 1;

  public Drive(){
    frontLeft = new CANSparkMax(RobotMap.FRONT_LEFT_DRIVE_MOTOR, CANSparkMaxLowLevel.MotorType.kBrushless);
    backLeft = new CANSparkMax(RobotMap.BACK_LEFT_DRIVE_MOTOR, CANSparkMaxLowLevel.MotorType.kBrushless);
    frontRight = new CANSparkMax(RobotMap.FRONT_RIGHT_DRIVE_MOTOR, CANSparkMaxLowLevel.MotorType.kBrushless);
    backRight = new CANSparkMax(RobotMap.BACK_RIGHT_DRIVE_MOTOR, CANSparkMaxLowLevel.MotorType.kBrushless);
    //finish creating all TalonSRX objects
    left = new SpeedControllerGroup(frontLeft, backLeft);
    right = new SpeedControllerGroup(frontRight, backRight);
    //group speed controllers into speedcontrollergroup objects
    drive = new DifferentialDrive(left, right);
    //create drive object
    // leftGearShifter = new DoubleSolenoid(RobotMap.LEFT_SHIFTER_FORWARD, RobotMap.LEFT_SHIFTER_REVERSE);
    // rightGearShifter = new DoubleSolenoid(RobotMap.RIGHT_SHIFTER_FORWARD, RobotMap.RIGHT_SHIFTER_REVERSE);
    shifter = new DoubleSolenoid(RobotMap.SHIFTER_FORWARD, RobotMap.SHIFTER_REVERSE);
    //finish declaring the shifter solenoids
  }

  public void setSpeed(int speedValue){
    switch(speedValue){
      case FULL_SPEED:
        fullSpeed();
      break;
      case SLOW_SPEED:
        slowSpeed();
      break;
    }
  }

  private void fullSpeed(){
    // leftGearShifter.set(DoubleSolenoid.Value.kForward);
    // rightGearShifter.set(DoubleSolenoid.Value.kForward);
    shifter.set(DoubleSolenoid.Value.kForward);
  }
  private void slowSpeed(){
    // leftGearShifter.set(DoubleSolenoid.Value.kReverse);
    // rightGearShifter.set(DoubleSolenoid.Value.kReverse);
    shifter.set(DoubleSolenoid.Value.kReverse);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new ArcadeDrive(drive));
    //set the subsystem to arcade drive unless told otherwise
  }
}
