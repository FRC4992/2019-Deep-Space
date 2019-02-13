/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Hatch extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  DoubleSolenoid topPiston, bottomPiston;
  public Hatch(){
    topPiston = new DoubleSolenoid(RobotMap.HATCH_TOP_FORWARD, RobotMap.HATCH_TOP_REVERSE);
    bottomPiston = new DoubleSolenoid(RobotMap.HATCH_BOTTOM_FORWARD, RobotMap.HATCH_BOTTOM_REVERSE);
  }

  public void extend(){
    topPiston.set(DoubleSolenoid.Value.kForward);
    bottomPiston.set(DoubleSolenoid.Value.kForward);
  }
  public void retract(){
    topPiston.set(DoubleSolenoid.Value.kReverse);
    bottomPiston.set(DoubleSolenoid.Value.kReverse);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
