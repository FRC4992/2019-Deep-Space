/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ManualElevatorControl;

/**
 * Add your docs here.
 */
public class Elevator extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public WPI_TalonSRX master,slave;
  public Elevator(){
    master = new WPI_TalonSRX(RobotMap.ELEVATOR_LEFT_MOTOR_ID);
    slave = new WPI_TalonSRX(RobotMap.ELEVATOR_RIGHT_MOTOR_ID);
    //create talons
    // master.configFactoryDefault();
    // slave.configFactoryDefault();
    //reset the talons
    master.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);
    //set the encoder type for the motor
    master.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, RobotMap.TALON_TIMEOUT_MS);
    master.configNominalOutputForward(0,RobotMap.TALON_TIMEOUT_MS);//set peak and minimum outputs in both directions
    master.configNominalOutputReverse(0,RobotMap.TALON_TIMEOUT_MS);
    master.configPeakOutputForward(1.00,RobotMap.TALON_TIMEOUT_MS);
    master.configPeakOutputReverse(-1.00,RobotMap.TALON_TIMEOUT_MS);

    master.config_kP(RobotMap.TALON_SLOT_ID, 0.1,RobotMap.TALON_TIMEOUT_MS);//set pidf values
    master.config_kI(RobotMap.TALON_SLOT_ID, 0,RobotMap.TALON_TIMEOUT_MS);
    master.config_kD(RobotMap.TALON_SLOT_ID, 0,RobotMap.TALON_TIMEOUT_MS);
    master.config_kF(RobotMap.TALON_SLOT_ID, 0,RobotMap.TALON_TIMEOUT_MS);

    master.configMotionAcceleration(RobotMap.ELEVATOR_ACCELERATION);
    master.configMotionCruiseVelocity(RobotMap.ELEVATOR_MAX_VELOCITY);    
    master.setSelectedSensorPosition(0);
    master.setSensorPhase(false);
    master.setInverted(true);
    slave.setInverted(true);
    //finish initializing talon pid + motion magic settings
    // slave.follow(master);
    //tell the right to follow the left
  }

  public void setTicks(int ticks){
    master.set(ControlMode.MotionMagic,ticks);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    // setDefaultCommand(new ManualElevatorControl());
  }

  public void updateSlave(){
    slave.set(ControlMode.PercentOutput,master.getMotorOutputPercent());
  }
}
