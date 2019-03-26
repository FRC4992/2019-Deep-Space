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
import frc.robot.commands.CargoIntake_Start;
import frc.robot.commands.CargoIntake_Stop;
import frc.robot.commands.CargoShooter_Start;
import frc.robot.commands.CargoShooter_Stop;
import frc.robot.commands.CargoTransporter_Stop;
import frc.robot.commands.Cargo_Transporter_Start;
import frc.robot.commands.SwitchDriveGear;
import frc.robot.commands.ToggleDirection;
import frc.robot.subsystems.Drive;
import frc.robot.commands.FollowLine;
import frc.robot.commands.StopFollowingLine;
import frc.robot.commands.ShootHatch;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  public static Joystick driveStick = new Joystick(RobotMap.DRIVE_JOYSTICK_ID);

  private Button intakeButton = new JoystickButton(driveStick,2);
  private Button cargoShooter = new JoystickButton(driveStick, 4);
  private Button conveyorButton = new JoystickButton(driveStick,1);
  public static Button followLineButton = new JoystickButton(driveStick,1);//A button
  public static Button driveSlowSpeed = new JoystickButton(driveStick, 5);//left bumper
  public static Button driveFullSpeed = new JoystickButton(driveStick, 6);//right bumper
  public static Button toggleDirection = new JoystickButton(driveStick,8);//start button

  Button hatchButton = new JoystickButton(driveStick,4);//assign the hatch to Y
  public OI(){
    intakeButton.whenPressed(new CargoIntake_Start());
    intakeButton.whenReleased(new CargoIntake_Stop());

    cargoShooter.whenPressed(new CargoShooter_Start());
    cargoShooter.whenReleased(new CargoShooter_Stop());

    conveyorButton.whenPressed(new Cargo_Transporter_Start());
    conveyorButton.whenReleased(new CargoTransporter_Stop());

    driveFullSpeed.whenPressed(new SwitchDriveGear(Drive.FULL_SPEED));
    driveSlowSpeed.whenPressed(new SwitchDriveGear(Drive.SLOW_SPEED));
    //gear switcher buttons
    followLineButton.whenPressed(new FollowLine());
    followLineButton.whenReleased(new StopFollowingLine());
    //follow a line while the button is pressed
    toggleDirection.whenPressed(new ToggleDirection());
    //switch the direction the robot considers forward

    hatchButton.whenPressed(new ShootHatch());//shoot the hatch when the button is pressed

  }
}
