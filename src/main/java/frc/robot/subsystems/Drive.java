/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

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
  WPI_TalonSRX frontLeft, frontRight, backLeft, backRight;
  SpeedControllerGroup left, right;
  DifferentialDrive drive;

  public Drive(){
    frontLeft = new WPI_TalonSRX(RobotMap.FRONT_LEFT_DRIVE_MOTOR);
    backLeft = new WPI_TalonSRX(RobotMap.BACK_LEFT_DRIVE_MOTOR);
    frontRight = new WPI_TalonSRX(RobotMap.FRONT_RIGHT_DRIVE_MOTOR);
    backRight = new WPI_TalonSRX(RobotMap.BACK_RIGHT_DRIVE_MOTOR);

    left = new SpeedControllerGroup(frontLeft, backLeft);
    right = new SpeedControllerGroup(frontRight, backRight);

    drive = new DifferentialDrive(left, right);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new ArcadeDrive(drive));
  }
}
