/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.Drive;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.CancelIntake;
import frc.robot.commands.CargoShooter_Stop;
import frc.robot.commands.ManualLiftControl;
// import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.CargoIntake;
import frc.robot.subsystems.CargoShooter;
import frc.robot.subsystems.CargoTransporter;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.Hatch;
import frc.robot.subsystems.Lift;
import frc.robot.subsystems.Elevator;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  
  public static OI m_oi;
  public static Drive drive = new Drive();
  public static CargoIntake cargoIntake = new CargoIntake();
  public static CargoShooter cargoShooter = new CargoShooter();
  public static CargoTransporter cargoTransporter = new CargoTransporter();
  public static Hatch hatchShooter = new Hatch();
  Compressor compressor = new Compressor();
  public static Lift lift = new Lift();
  public static Elevator elevator = new Elevator();

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    m_oi = new OI();
    CameraServer.getInstance().startAutomaticCapture();
    drive.resetAngle();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  //  System.out.println(hatchShooter.ultrasonic.getRangeInches());
    // System.out.println(lift.master.getSelectedSensorPosition());
    // System.out.println(elevator.master.getSelectedSensorPosition());
    // System.out.println("P: "+drive.getLinePos());
    drive.getLinePos();
    SmartDashboard.putBoolean("Pressure Switch",compressor.getPressureSwitchValue());
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    elevator.master.setSelectedSensorPosition(0);
    drive.setSpeed(Drive.SLOW_SPEED);
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    // lift.master.setSelectedSensorPosition(0);
    // elevator.master.setSelectedSensorPosition(0);
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    // if(!drive.followingLine){
    //   new ArcadeDrive(drive.drive);
    // }
    lift.updateSlaves();
    // SmartDashboard.putNumber("Elevator Encoder", elevator.master.getSelectedSensorPosition());
    elevator.updateSlave();
    SmartDashboard.putNumber("Hatch Encoder", hatchShooter.ultrasonic.getRangeInches());
    // System.out.println(elevator.master.getSelectedSensorPosition());
    // System.out.println("Lift Value: "+lift.master.getSelectedSensorPosition());
  }

  @Override
  public void testInit(){
    new CargoShooter_Stop().start();
    new CancelIntake().start();
  }
  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
    // new ManualLiftControl().start();
    // lift.master.set(OI.driveStick.getRawAxis(1)/4);
    // lift.updateSlaves();
    cargoIntake.motor.set(ControlMode.PercentOutput,OI.driveStick.getRawAxis(5)*0.6);
    cargoTransporter.cargoTransportMotor.set(ControlMode.PercentOutput,-OI.driveStick.getRawAxis(5));
    
  }
}
