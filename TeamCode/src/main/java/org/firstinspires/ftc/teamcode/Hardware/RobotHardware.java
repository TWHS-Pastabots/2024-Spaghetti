package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoController;
import com.qualcomm.hardware.bosch.BNO055IMU;

import org.firstinspires.ftc.robotcore.internal.system.Assert;

public class RobotHardware {
    public DcMotorEx frontLeft = null;
    public DcMotorEx rearLeft = null;
    public DcMotorEx frontRight = null;
    public DcMotorEx rearRight = null;
    public DcMotorEx intake = null;
    public DcMotorEx launcher = null;
    public DcMotorEx climber = null;
    public Servo transition = null;
    public Servo angler = null;

    public BNO055IMU imu;



    public DcMotorEx[] motors;

    public RobotHardware() {}

    public void init(HardwareMap hardwareMap){
        Assert.assertNotNull(hardwareMap);
        initializeDriveMotors(hardwareMap);
        initializeIntakeMotors(hardwareMap);
        initializeOutTakeMotors(hardwareMap);
        initializeClimberMotor(hardwareMap);
        initializeServos(hardwareMap);
    }

public void initializeDriveMotors(HardwareMap hardwareMap){
        //getting the motor ids from the hardwaremap you will create
    frontLeft = hardwareMap.get(DcMotorEx.class, RobotIDS.LEFT_FRONT_MOTOR);
    frontRight = hardwareMap.get(DcMotorEx.class, RobotIDS.RIGHT_FRONT_MOTOR);
    rearLeft = hardwareMap.get(DcMotorEx.class, RobotIDS.LEFT_REAR_MOTOR);
    rearRight = hardwareMap.get(DcMotorEx.class, RobotIDS.RIGHT_REAR_MOTOR);


    //this is the list of the motors you will use for the drivetrain
    motors = new DcMotorEx[]{frontLeft, frontRight, rearLeft, rearRight}; 

    //setting the directions specific to the mecanum drive train. If you have a different drive train come ask.
    frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
    rearLeft.setDirection(DcMotorSimple.Direction.REVERSE);
    frontRight.setDirection(DcMotorSimple.Direction.FORWARD);
    rearRight.setDirection(DcMotorSimple.Direction.FORWARD);


    for(DcMotorEx motor : motors ){
        motor.setPower(0.0);
        motor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        motor.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
    }
    // Set up IMU
    imu = hardwareMap.get(BNO055IMU.class, RobotIDS.IMU);
    BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
    parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
    parameters.mode = BNO055IMU.SensorMode.IMU;
    parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
    parameters.loggingEnabled = false;
    imu.initialize(parameters);
}

public void initializeIntakeMotors(HardwareMap hardwareMap){
    //this will be where your intake code goes eventually
    intake = hardwareMap.get(DcMotorEx.class, RobotIDS.INTAKE_MOTOR);
    intake.setPower(0.0);
    intake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    intake.setDirection(DcMotorSimple.Direction.REVERSE);

}

public void initializeOutTakeMotors(HardwareMap hardwareMap){
        //this is where your shooter code will go eventually
    launcher = hardwareMap.get(DcMotorEx.class, RobotIDS.LAUNCHER_MOTOR);
    launcher.setPower(0.0);
    launcher.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
}
public void initializeClimberMotor(HardwareMap hardwareMap)
{
    climber = hardwareMap.get(DcMotorEx.class, RobotIDS.CLIMB_MOTOR);
    climber.setPower(0.0);
    climber.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

}

public void initializeServos(HardwareMap hardwareMap){
//    //this is where all of your servos will go eventually
//    transition = hardwareMap.get(Servo.class, RobotIDS.TRANSITION_SERVO_MOTOR);
//    transition.setPosition(0.0);

    angler = hardwareMap.get(Servo.class, RobotIDS.ANGLE_SERVO_MOTOR);
    angler.setPosition(0.0);

}
}