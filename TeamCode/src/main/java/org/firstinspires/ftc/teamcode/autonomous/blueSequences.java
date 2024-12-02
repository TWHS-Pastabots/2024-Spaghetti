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

    Trajectory strafeStart, initialForward;
    Trajectory align1A, align1B, align2, align3;
    Trajectory park1A, park1B, park2A, park2B, park3A, park3B;
    Trajectory toGoal;

    Pose2d startPose = new Pose2d(54,54,Math.toRadians(180));

    public blueSequences(HardwareMap hardwareMap, Utilities utility)
    {
        hardware = new RobotHardware();
        hardware.init(hardwareMap);
        //intakeLauncher = new RobotCode(hardwareMap);
        this.utility = utility;
        drive = new SampleMecanumDrive(hardwareMap);
        drive.setPoseEstimate(startPose);
        toGoal = drive.trajectorySequenceBuilder(startPose)
                .strafe
    }

    TrajectorySequence trajectory = drive.trajectorySequenceBuilder(startPose)
}
