/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.OI;
import frc.robot.Robot;

public class SetGamePiece extends Command {
  int gamePiece;
  public SetGamePiece(int gamePiece) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    this.gamePiece = gamePiece;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.m_oi.setGamePiece(gamePiece);
    if(gamePiece == OI.CARGO_OI){
      SmartDashboard.putBoolean("CARGO MODE", true);
      SmartDashboard.putBoolean("HATCH MODE", false);
    }else if(gamePiece == OI.HATCH_OI){
      SmartDashboard.putBoolean("HATCH MODE", true);
      SmartDashboard.putBoolean("CARGO MODE", false);
    }else{
      SmartDashboard.putBoolean("CARGO MODE", true);
      SmartDashboard.putBoolean("HATCH MODE", true);
    }
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
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
