/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsytems;

import javax.naming.InitialContext;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.SpikeChecker;

/**
 * Add your docs here.
 */
public class CargoShooter extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public SpikeChecker initialSpikeChecker = new SpikeChecker(0.8,10,10);
  public SpikeChecker intakeSpikeChecker = new SpikeChecker(0.8,10,10);
  public WPI_TalonSRX leftMotor, rightMotor;
  public CargoShooter(){
    leftMotor = new WPI_TalonSRX(RobotMap.CARGO_SHOOTER_LEFT_MOTOR);
    rightMotor = new WPI_TalonSRX(RobotMap.CARGO_SHOOTER_RIGHT_MOTOR);
  }

  public double getLeftCurrent(){
    return leftMotor.getOutputCurrent();
  }
  public double getRightCurrent(){
    return rightMotor.getOutputCurrent();
  }
  public double getAverageCurrent(){
    return (1/2)*(getLeftCurrent()+getRightCurrent());
  }
  public void updateSpikeCheckers(){
    intakeSpikeChecker.addValue(getAverageCurrent());
    intakeSpikeChecker.addValue(getAverageCurrent());
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
