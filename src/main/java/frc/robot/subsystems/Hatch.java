/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Hatch extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  DoubleSolenoid piston;
  Ultrasonic ultrasonic;
  public Hatch(){
    piston = new DoubleSolenoid(RobotMap.HATCH_FORWARD, RobotMap.HATCH_REVERSE);
    ultrasonic = new Ultrasonic(RobotMap.ULTRASONIC_TRIGGER_PIN, RobotMap.ULTRASONIC_ECHO_PIN);
    ultrasonic.setAutomaticMode(true);
    ultrasonic.setDistanceUnits(Ultrasonic.Unit.kInches);
    retract();
  }

  public void extend(){
    piston.set(DoubleSolenoid.Value.kForward);
  }
  public void retract(){
    piston.set(DoubleSolenoid.Value.kReverse);
  }

  public double getDistance(){
    /**
     * returns range in inches
     */
    return ultrasonic.getRangeInches();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
