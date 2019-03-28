/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.CargoIntake;

public class IntakeCargo extends Command {
  CargoShooter_Start shooterCommand;
  boolean finished = false;
  public IntakeCargo() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.cargoIntake);
    requires(Robot.cargoShooter);
    requires(Robot.cargoTransporter);

    shooterCommand = new CargoShooter_Start();
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    finished = false;
    shooterCommand.start();
    new Cargo_Transporter_Start().start();
    new CargoIntake_Start().start();
    //TODO: bring lift down

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(shooterCommand.isFinished()){
      //stop everything
      new CargoTransporter_Stop().start();
      new CargoIntake_Stop().start();
      finished = true;
    }else{
      new Cargo_Transporter_Start().start();
      new CargoIntake_Start().start();
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