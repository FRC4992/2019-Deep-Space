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
  public static final int CONTROL_PANEL_ID = 1;
  public static final int 
    TALON_SLOT_ID = 0,
    TALON_TIMEOUT_MS = 30
  ;
  public static final int
  BACK_RIGHT_DRIVE_MOTOR = 2,
  FRONT_RIGHT_DRIVE_MOTOR = 4,
  BACK_LEFT_DRIVE_MOTOR = 3,
  FRONT_LEFT_DRIVE_MOTOR = 1,
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
  CENTER_LINE_SENSOR_ID = 0,
  RIGHT_LINE_SENSOR_ID = 1,
  LEFT_LINE_SENSOR_ID = 2
  ;

  public static final int
    HATCH_FORWARD = 3,
    HATCH_REVERSE = 2,
    //finish declaring all solenoid ids
    ULTRASONIC_TRIGGER_PIN = 9,
    ULTRASONIC_ECHO_PIN = 8
    ;
  public static final int
  
    CONVEYOR_MOTOR_ID = 20,

    LIFT_LEFT_MOTOR_ID = 41,
    LIFT_RIGHT_MOTOR_ID = 40,
    //finish declaring LIFT motor ids

    LIFT_ACCELERATION = 500,
    LIFT_MAX_VELOCITY = 500,
    //set motion magic values

    LIFT_GROUND_HEIGHT = 100,//280
    LIFT_RAISED_HEIGHT = 50,
    
    //finish declaring the encoder heights for the elevator
    ELEVATOR_LEFT_MOTOR_ID = 50,
    ELEVATOR_RIGHT_MOTOR_ID = 51,
    //finish declaring elevator motor ids

    ELEVATOR_ACCELERATION = 3100,
    ELEVATOR_MAX_VELOCITY = 3100;
  ;

  public static final int TICKS_PER_INCH = 879;
  public static final int MINIMUM_HEIGHT_INCHES = 19;
  public static final int MAXIMUM_ELEVATOR_HEIGHT_TICKS = 58000;

  public static final int
    ROCKET_HATCH_1 = (19-MINIMUM_HEIGHT_INCHES)*TICKS_PER_INCH,
    ROCKET_HATCH_2 = (47+2-MINIMUM_HEIGHT_INCHES)*TICKS_PER_INCH,
    ROCKET_HATCH_3 = (79-MINIMUM_HEIGHT_INCHES)*TICKS_PER_INCH,//supposed to be 75 inches but needed an offset

    ROCKET_CARGO_1 = 5000,
    ROCKET_CARGO_2 = 15000,
    ROCKET_CARGO_3 = 25000,	

    CARGOSHIP_CARGO = (43-MINIMUM_HEIGHT_INCHES)*TICKS_PER_INCH;
  ;
  
}

