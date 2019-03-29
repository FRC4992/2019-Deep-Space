/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class FollowLine extends Command {
  int linePos = -1;
  double sweepSpeed = 0.5;
  //defines the speed the robot goes at before it finds the line
  double turnSpeed = 0.5;
  //defines how fast the robot turns when it sees a line
  double forwardSpeed = 0.5;
  //defines how fast the robot goes when it is centered on the line
  double forwardTurnOffset = 0.3;
  //defines how fast the robot continues to go forward while turning
  final int leftTurnMultiplier = 1; 
  final int rightTurnMultiplier = -1;
  //defines which direction the robot needs to turn
  public FollowLine() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    // requires(Robot.drive);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    linePos = Robot.drive.getLinePos();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.drive.followingLine = true;
    linePos = Robot.drive.getLinePos();
    //update the position of the line
    if(linePos == -1){
      //no line detected
      Robot.drive.driveForward(sweepSpeed);
    }else if(linePos == 1 || linePos == 2){
      //the left line sensor sees the line
      Robot.drive.setSpeed(leftTurnMultiplier*turnSpeed, forwardTurnOffset);
    }else if(linePos == 3){
      //only the center sensor sees the line
      Robot.drive.driveForward(forwardSpeed);
    }else if(linePos == 4 || linePos == 5){
      //the right sensor sees the line
      Robot.drive.setSpeed(rightTurnMultiplier*turnSpeed, forwardTurnOffset);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    // return !Robot.drive.followingLine;
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.drive.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.drive.stop();
  }
}
