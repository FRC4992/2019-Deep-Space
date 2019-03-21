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
import frc.robot.commands.ToggleEndgame;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  public static Joystick driveStick = new Joystick(RobotMap.DRIVE_JOYSTICK_ID);
  private Button intakeButton = new JoystickButton(driveStick,2);
  private Button cargoShooter = new JoystickButton(driveStick, 4);
  private Button conveyorButton = new JoystickButton(driveStick,1);
  private Button toggleEndgame = new JoystickButton(driveStick,10);//push right stick
  public static final int INGAME_MODE = -1;
  public static final int ENDGAME_MODE = 1;
  public static int currentMode = -1;

  public OI(){
    updateButtons(INGAME_MODE);
  }
  public void updateButtons(int buttonMode){
    currentMode = buttonMode;
    switch(buttonMode){
      case OI.INGAME_MODE:
      intakeButton.whenPressed(new CargoIntake_Start());
      intakeButton.whenReleased(new CargoIntake_Stop());

      cargoShooter.whenPressed(new CargoShooter_Start());
      cargoShooter.whenReleased(new CargoShooter_Stop());

      conveyorButton.whenPressed(new Cargo_Transporter_Start());
      conveyorButton.whenReleased(new CargoTransporter_Stop());
      toggleEndgame.whenPressed(new ToggleEndgame());
      break;
      case OI.ENDGAME_MODE:

      
      // Bring elevator down and potentially disable it
      // Change Lift down value
      // set cargo intake to front
      // map intake button to bring lift down
      intakeButton.whileHeld(new CargoIntake_Start());
      intakeButton.whenReleased(new CargoIntake_Stop());
      // map HOLD lift button to run rollers
      // map shoot button to bring lift back
      

      break;
      default:
      intakeButton.whenPressed(new CargoIntake_Start());
      intakeButton.whenReleased(new CargoIntake_Stop());

      cargoShooter.whenPressed(new CargoShooter_Start());
      cargoShooter.whenReleased(new CargoShooter_Stop());

      conveyorButton.whenPressed(new Cargo_Transporter_Start());
      conveyorButton.whenReleased(new CargoTransporter_Stop());
      break;
    }
    
  }

}
