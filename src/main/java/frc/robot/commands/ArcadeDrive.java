/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.Arrays;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.subsystems.Drive;

public class ArcadeDrive extends Command {
  DifferentialDrive drive;
  public ArcadeDrive(DifferentialDrive drive) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.drive);
    this.drive = drive;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // if(Robot.drive.followingLine){
    //   drive.arcadeDrive(Robot.drive.driveVals[0], Robot.drive.driveVals[1]);
    //   System.out.println("usinng vals: "+Arrays.toString(Robot.drive.driveVals));
    // }else{
    //   // Robot.drive.driveValues[0] = 0;
    //   // Robot.drive.driveValues[1] = 0;
      drive.arcadeDrive(-OI.driveStick.getRawAxis(1)*Robot.drive.directionMultiplier, OI.driveStick.getRawAxis(0));
    //   System.out.println("reg drive");
    // }

    switch(OI.driveStick.getPOV()){
      case 0://up on the dpad
        Robot.drive.setSpeed(Drive.FULL_SPEED);//go full speed
      break;
      case 180://down on the dpad
        Robot.drive.setSpeed(Drive.SLOW_SPEED);//go slow speed
      break;
    }
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
