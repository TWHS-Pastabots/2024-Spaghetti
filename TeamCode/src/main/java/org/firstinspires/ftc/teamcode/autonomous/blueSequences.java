package org.firstinspires.ftc.teamcode.autonomous;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.Hardware.RobotHardware;
import org.firstinspires.ftc.teamcode.teleOp.RobotCode;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

public class blueSequences {
    SampleMecanumDrive drive;
    RobotHardware hardware;
    RobotCode intakeLauncher;
    Utilities utility;

    TrajectorySequence startToOne, startToTwo, startToThree;
    TrajectorySequence align1A, align1B, align2, align3;
    TrajectorySequence park1A, park1B, park2A, park2B, park3A, park3B;
    TrajectorySequence toGoal;

    Pose2d startPose = new Pose2d(54,54,Math.toRadians(180));

    public blueSequences(HardwareMap hardwareMap, Utilities utility)
    {
        hardware = new RobotHardware();
        hardware.init(hardwareMap);
        this.utility = utility;
        drive = new SampleMecanumDrive(hardwareMap);
        drive.setPoseEstimate(startPose);

        startToOne = drive.trajectorySequenceBuilder(startPose)
                .strafeLeft(36)
                .forward(36)
                .turn(Math.toRadians(90)).build();

        startToTwo = drive.trajectorySequenceBuilder(startToOne.end())
                .strafeLeft(55)
                .forward(36)
                .turn(Math.toRadians(90))
                .build();
        startToThree = drive.trajectorySequenceBuilder(startToTwo.end())
                .strafeLeft(74)
                .forward(36)
                .turn(Math.toRadians(90))
                .build();


    }
    public void blue1()
    {
        drive.followTrajectorySequence(startToOne);
        hardware.launcher.setPower(1.0);
        hardware.intake.setPower(1.0);
        hardware.intake.setPower(0.0);
        hardware.launcher.setPower(0.0);
    }

    public void blue2()
    {
        drive.followTrajectorySequence(startToTwo);
        hardware.launcher.setPower(1.0);
        hardware.intake.setPower(1.0);
        hardware.intake.setPower(0.0);
        hardware.launcher.setPower(0.0);
    }
    public void blue3()
    {
        hardware.launcher.setPower(1.0);
        hardware.intake.setPower(1.0);
        hardware.intake.setPower(0.0);
        hardware.launcher.setPower(0.0);
    }


}
