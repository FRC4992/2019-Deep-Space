/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  public static final int DRIVE_JOYSTICK_ID = 0;
  public static final int 
    TALON_SLOT_ID = 0,
    TALON_TIMEOUT_MS = 30
  ;
  public static final int
  BACK_RIGHT_DRIVE_MOTOR = 0,
  FRONT_RIGHT_DRIVE_MOTOR = 1,
  BACK_LEFT_DRIVE_MOTOR = 2,
  FRONT_LEFT_DRIVE_MOTOR = 3,
  //Finish delcaring all drive-train talon IDs
  // LEFT_SHIFTER_FORWARD = 0,
  // LEFT_SHIFTER_REVERSE = 1,
  // // RIGHT_SHIFTER_FORWARD = 2,
  // RIGHT_SHIFTER_REVERSE = 3
  SHIFTER_FORWARD = 0,
  SHIFTER_REVERSE = 1
  //finish declaring all drive-train solenoid IDs
  ;
  public static final int
  CARGO_INTAKE_MOTOR_ID = 21
  ;

  public static final int
  CARGO_SHOOTER_LEFT_MOTOR = 30,
  CARGO_SHOOTER_RIGHT_MOTOR = 31;
  ;
  public static final int
  
    CONVEYOR_MOTOR_ID = 20,

    LIFT_LEFT_MOTOR_ID = 41,
    LIFT_RIGHT_MOTOR_ID = 40,
    //finish declaring LIFT motor ids

    LIFT_ACCELERATION = 500,
    LIFT_MAX_VELOCITY = 500,
    //set motion magic values

    LIFT_GROUND_HEIGHT = 280,
    LIFT_RAISED_HEIGHT = 0
  ;
}

