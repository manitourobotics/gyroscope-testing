package com.github.manitourobotics.gyroscopetesting;


import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/*
 * Used to test a gyroscope and the Gyro WPILIB class.
 * the getAngle() method gets the angle of the current heading since teleopInit()
 * when the gyro.reset(); is called
 */
public class GyroscopeTesting extends IterativeRobot {

    public void robotInit() {

    }

    // Can only be used on channels 1 and 2 for the analog breakout
    final int ANALOG_GYRO_SIGNAL = 2;
    Gyro gyro = new Gyro(ANALOG_GYRO_SIGNAL);
    public void teleopInit() {
        gyro.reset();
    }

    public void teleopPeriodic() {
        double gyroAngle = gyro.getAngle();
        SmartDashboard.putNumber("Gyro angle", gyroAngle);
        Scheduler.getInstance().run();
    }
}
