/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.SetElevatorHeight;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
 public static Joystick controlPanelJoystick = new Joystick(RobotMap.CONTROL_PANEL_ID);
 public static Joystick driveStick = new Joystick(0);
 Button hatchLevel1 = new JoystickButton(controlPanelJoystick, 1);
 Button hatchLevel2 = new JoystickButton(controlPanelJoystick, 2);
 Button hatchLevel3 = new JoystickButton(controlPanelJoystick, 3);
 Button cargoLevel1 = new JoystickButton(controlPanelJoystick, 4);
 Button cargoLevel2 = new JoystickButton(controlPanelJoystick, 6);
 Button cargoLevel3 = new JoystickButton(controlPanelJoystick, 7);
 Button cargoLevelCargoship = new JoystickButton(controlPanelJoystick, 8);

 
 //declare all elevator buttons

 public OI(){
   hatchLevel1.whenPressed(new SetElevatorHeight(RobotMap.HATCH_LEVEL_1));
   hatchLevel2.whenPressed(new SetElevatorHeight(RobotMap.HATCH_LEVEL_1));
   hatchLevel3.whenPressed(new SetElevatorHeight(RobotMap.HATCH_LEVEL_1));
   cargoLevel1.whenPressed(new SetElevatorHeight(0));
   cargoLevel2.whenPressed(new SetElevatorHeight(RobotMap.CARGO_LEVEL_1));
   cargoLevel3.whenPressed(new SetElevatorHeight(5000));
   cargoLevelCargoship.whenPressed(new SetElevatorHeight(RobotMap.CARGO_LEVEL_CARGOSHIP));
 }
 
}
