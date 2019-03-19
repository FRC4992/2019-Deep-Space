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
import frc.robot.commands.IntakeCargo;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  public static Joystick driveStick = new Joystick(RobotMap.DRIVE_JOYSTICK_ID);
  private Button cargoShooter = new JoystickButton(driveStick, 3);//B button
  private Button cargoIntake = new JoystickButton(driveStick,4);//Y button
  /*Used for manual control of cargo intake
    private Button conveyorButton = new JoystickButton(driveStick,1);
    private Button intakeButton = new JoystickButton(driveStick,2);
  */
  public OI(){
    /*Used for manual control of cargo intake
        conveyorButton.whenPressed(new Cargo_Transporter_Start());
        conveyorButton.whenReleased(new CargoTransporter_Stop());

        intakeButton.whenPressed(new CargoIntake_Start());
        intakeButton.whenReleased(new CargoIntake_Stop());

    */ 
    //assign buttons their commands
    cargoShooter.whenPressed(new CargoShooter_Start());
    cargoShooter.whenReleased(new CargoShooter_Stop());
    //cargo shooter buttons
    cargoIntake.whenPressed(new IntakeCargo());
    //cargo intake button
  }
}
