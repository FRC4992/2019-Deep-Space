/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ShootHatch extends Command {
  long startTime;
  int retractDelay = 500;//milliseconds the command waits until it retracts the pistons
  boolean finished = false;//whether or not the command has finished
  public ShootHatch() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.hatchShooter);
    
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    startTime = System.currentTimeMillis();
    // if(Robot.hatchShooter.getDistance()<24){
      Robot.hatchShooter.extend();
      System.out.println("Shoot");
    // } 
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(System.currentTimeMillis()-startTime>=retractDelay){
      System.out.println("Retract");
      Robot.hatchShooter.retract();
      finished = true;
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return finished;
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
