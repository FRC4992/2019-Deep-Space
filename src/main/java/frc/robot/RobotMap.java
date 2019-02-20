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
    LIFT_LEFT_MOTOR_ID = 40,
    LIFT_RIGHT_MOTOR_ID = 41,
    //finish declaring LIFT motor ids

    LIFT_ACCELERATION = 500,
    LIFT_MAX_VELOCITY = 1000,
    //set motion magic values

    LIFT_GROUND_HEIGHT = 100,
    LIFT_RAISED_HEIGHT = 1000
  ;
}