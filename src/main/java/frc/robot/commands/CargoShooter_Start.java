/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class CargoShooter_Start extends Command {
  boolean initialSpikePassed = false;
  boolean initialSpike = false;
  boolean finished = false;
  public CargoShooter_Start() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.cargoShooter);
    
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    initialSpike = false;
    initialSpikePassed = false;
    finished = false;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // System.out.println("running shooter");
    Robot.cargoShooter.updateSpikeCheckers();
    initialSpike = Robot.cargoShooter.initialSpikeChecker.didSpike() ? true:initialSpike;
    initialSpikePassed = (!Robot.cargoShooter.initialSpikeChecker.didSpike() && initialSpike);
    if(initialSpikePassed && Robot.cargoShooter.intakeSpikeChecker.didSpike()){
      //stop the motors
      new CargoShooter_Stop();
      finished = true;
    }else{
      //shoot
      Robot.cargoShooter.leftMotor.set(.25);
      Robot.cargoShooter.rightMotor.set(-.25);
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
