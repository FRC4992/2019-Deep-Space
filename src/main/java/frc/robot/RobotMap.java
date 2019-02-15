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
  public static final int
  FRONT_LEFT_DRIVE_MOTOR = 0,
  BACK_LEFT_DRIVE_MOTOR = 1,
  FRONT_RIGHT_DRIVE_MOTOR = 2,
  BACK_RIGHT_DRIVE_MOTOR = 3,
  //Finish delcaring all drive-train talon IDs
  LEFT_SHIFTER_FORWARD = 0,
  LEFT_SHIFTER_REVERSE = 1,
  RIGHT_SHIFTER_FORWARD = 2,
  RIGHT_SHIFTER_REVERSE = 3
  //finish declaring all drive-train solenoid IDs
  ;

  public static final int DRIVE_JOYSTICK_ID = 0;//joystick for the main xbox controller
  public static final int
  LEFT_LINE_SENSOR_ID = 0,
  CENTER_LINE_SENSOR_ID = 1,
  RIGHT_LINE_SENSOR_ID = 2
  ;
}
