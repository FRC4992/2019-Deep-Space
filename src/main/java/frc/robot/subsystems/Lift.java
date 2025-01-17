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
import frc.robot.commands.ManualLiftControl;

/**
 * Add your docs here.
 */
public class Lift extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public WPI_TalonSRX master,slave;
  public static final double LIFT_DOWN_SPEED = -1.0;
  public static final double LIFT_UP_SPEED = 1.0;
  public Lift() {
    master = new WPI_TalonSRX(RobotMap.LIFT_LEFT_MOTOR_ID);
    // slave = new WPI_TalonSRX(RobotMap.LIFT_RIGHT_MOTOR_ID);
    //create talons
    // master.configFactoryDefault();
    // slave.configFactoryDefault();
    //reset the talons
    master.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
    //set the encoder type for the motor
    master.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, RobotMap.TALON_TIMEOUT_MS);
    master.configNominalOutputForward(0,RobotMap.TALON_TIMEOUT_MS);//set peak and minimum outputs in both directions
    master.configNominalOutputReverse(0,RobotMap.TALON_TIMEOUT_MS);
    master.configPeakOutputForward(0.25,RobotMap.TALON_TIMEOUT_MS);
    master.configPeakOutputReverse(-0.25,RobotMap.TALON_TIMEOUT_MS);

    master.config_kP(RobotMap.TALON_SLOT_ID, 20,RobotMap.TALON_TIMEOUT_MS);//set pidf values
    master.config_kI(RobotMap.TALON_SLOT_ID, 0,RobotMap.TALON_TIMEOUT_MS);
    master.config_kD(RobotMap.TALON_SLOT_ID, 0,RobotMap.TALON_TIMEOUT_MS);
    master.config_kF(RobotMap.TALON_SLOT_ID, 0,RobotMap.TALON_TIMEOUT_MS);

    master.configMotionAcceleration(RobotMap.LIFT_ACCELERATION);
    master.configMotionCruiseVelocity(RobotMap.LIFT_MAX_VELOCITY);    
    master.setSelectedSensorPosition(0);
    //finish initializing talon pid + motion magic settings
    // slave.follow(master);
    //tell the right to follow the left
  }

  public void setTicks(int ticks){
    master.set(ControlMode.MotionMagic,ticks);
  }

  public void updateSlaves(){
    // slave.set(ControlMode.PercentOutput,master.getMotorOutputPercent());
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    // setDefaultCommand(new ManualLiftControl());
  }
}