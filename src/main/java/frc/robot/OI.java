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
import frc.robot.commands.CancelIntake;
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
import frc.robot.commands.IntakeCargo;
import frc.robot.commands.StopIntake;
// import frc.robot.commands.ToggleLift;
import frc.robot.commands.SetElevatorHeight;
import frc.robot.commands.SetGamePiece;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  public static Joystick driveStick = new Joystick(RobotMap.DRIVE_JOYSTICK_ID);
  public static Joystick driver2 = new Joystick(1);

  // private Button intakeButton = new JoystickButton(driveStick,3);
  private Button cargoShooter = new JoystickButton(driveStick, 2);
  private Button conveyorButton = new JoystickButton(driveStick,1);
  public static Button followLineButton = new JoystickButton(driveStick,1);//A button
  public static Button driveSlowSpeed = new JoystickButton(driveStick, 5);//left bumper
  public static Button driveFullSpeed = new JoystickButton(driveStick, 6);//right bumper
  public static Button toggleDirection = new JoystickButton(driveStick,8);//start button

  Button hatchButton = new JoystickButton(driveStick,4);//assign the hatch to Y
  private Button cargoIntake = new JoystickButton(driveStick,3);//X button
  private Button cancelAll = new JoystickButton(driveStick,7);//back button
  Button liftButton = new JoystickButton(driveStick,2);
  /*Used for manual control of cargo intake
    private Button conveyorButton = new JoystickButton(driveStick,1);
    private Button intakeButton = new JoystickButton(driveStick,2);
  */


  // public static Button lowHatch = new JoystickButton(driver2,4);
	// public static Button midHatch = new JoystickButton(driver2,7);
	// public static Button highHatch = new JoystickButton(driver2,9);
	// public static Button lowCargo = new JoystickButton(driver2,15);
	// public static Button midCargo = new JoystickButton(driver2,14);
	// public static Button highCargo = new JoystickButton(driver2,3);
  // public static Button shipCargo = new JoystickButton(driver2,6);
  // public static Button secondaryShootHatch = new JoystickButton(driver2,16);
  
  public static Button lowElevator = new JoystickButton(driver2,1);
  public static Button mediumElevator = new JoystickButton(driver2,3);
  public static Button highElevator = new JoystickButton(driver2,4);
  public static Button cargoShipCargoElevator = new JoystickButton(driver2,2);
  public static Button cargoMode = new JoystickButton(driver2,5);
  public static Button hatchMode = new JoystickButton(driver2,6);
	
	

  public OI(){
    /*Used for manual control of cargo intake
        conveyorButton.whenPressed(new Cargo_Transporter_Start());
        conveyorButton.whenReleased(new CargoTransporter_Stop());

        intakeButton.whenPressed(new CargoIntake_Start());
        intakeButton.whenReleased(new CargoIntake_Stop());

    */ 
    setGamePiece(OI.HATCH_OI);
    //assign buttons their commands
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

    //cargo shooter buttons
    cargoIntake.whenPressed(new IntakeCargo());
    cargoIntake.whenReleased(new StopIntake());
    cancelAll.whenPressed(new CancelIntake());
    //cargo intake button

    hatchMode.whenPressed(new SetGamePiece(OI.HATCH_OI));
    cargoMode.whenPressed(new SetGamePiece(OI.CARGO_OI));
  




    // lowCargo.whenPressed(new SetElevatorHeight(RobotMap.ROCKET_CARGO_1));
		// midCargo.whenPressed(new SetElevatorHeight(RobotMap.ROCKET_CARGO_2));
		// highCargo.whenPressed(new SetElevatorHeight(RobotMap.ROCKET_CARGO_3));

		// lowHatch.whenPressed(new SetElevatorHeight(RobotMap.ROCKET_HATCH_1));
		// midHatch.whenPressed(new SetElevatorHeight(RobotMap.ROCKET_HATCH_2));
		// highHatch.whenPressed(new SetElevatorHeight(RobotMap.ROCKET_HATCH_3));
		// shipCargo.whenPressed(new SetElevatorHeight(RobotMap.CARGOSHIP_CARGO));



  }

  public static final int HATCH_OI = 0;
  public static final int CARGO_OI = 1;
  public void setGamePiece(int gamePiece){
    switch(gamePiece){
      case HATCH_OI:
        lowElevator.whenPressed(new SetElevatorHeight(RobotMap.ROCKET_HATCH_1));
        mediumElevator.whenPressed(new SetElevatorHeight(RobotMap.ROCKET_HATCH_2));
        highElevator.whenPressed(new SetElevatorHeight(RobotMap.ROCKET_HATCH_3));
      break;
      case CARGO_OI:
        lowElevator.whenPressed(new SetElevatorHeight(RobotMap.ROCKET_CARGO_1));
        mediumElevator.whenPressed(new SetElevatorHeight(RobotMap.ROCKET_CARGO_2));
        highElevator.whenPressed(new SetElevatorHeight(RobotMap.ROCKET_CARGO_3));
        cargoShipCargoElevator.whenPressed(new SetElevatorHeight(RobotMap.CARGOSHIP_CARGO));
      break;
    }
  }
 
}
