/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;

public class ManualLiftControl extends Command {
  double speed = 0;
  public ManualLiftControl() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    // requires(Robot.lift);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // if(OI.driveStick.getRawAxis(1)<0){
    //   Robot.lift.master.setInverted(true);
    //   Robot.lift.slave.setInverted(true);
    // }else{
    //   Robot.lift.master.setInverted(false);
    //   Robot.lift.slave.setInverted(false);
    // }
    // Robot.lift.master.set(Math.abs(OI.driveStick.getRawAxis(1))*1/10);
    // Robot.lift.master.set(OI.driveStick.getRawAxis(1)*1/10);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
