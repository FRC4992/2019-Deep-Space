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
  public static final int CONTROL_PANEL_ID = 1;
  public static final int 
    TALON_SLOT_ID = 0,
    TALON_TIMEOUT_MS = 30
  ;
  public static final int
    HATCH_LEVEL_1 = 00,
    HATCH_LEVEL_2 = 5000,
    HATCH_LEVL_3 = 5000,
    CARGO_LEVEL_CARGOSHIP = 5000,
    CARGO_LEVEL_1 = 5000,
    CARGO_LEVEL_2 = CARGO_LEVEL_CARGOSHIP,
    CARGO_LEVEL_3 = 5000,
    //finish declaring the encoder heights for the elevator
    ELEVATOR_LEFT_MOTOR_ID = 50,
    ELEVATOR_RIGHT_MOTOR_ID = 51,
    //finish declaring elevator motor ids

    ELEVATOR_ACCELERATION = 500,
    ELEVATOR_MAX_VELOCITY = 500;
  ;
}
