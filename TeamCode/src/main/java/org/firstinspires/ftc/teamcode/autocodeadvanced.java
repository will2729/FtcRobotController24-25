package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
@Autonomous (name = "AutoMcTickler: Premium Edition", group = "Robot")
public class autocodeadvanced extends LinearOpMode {

    DcMotor backL;

    DcMotor frontL;

    DcMotor backR;

    DcMotor frontR;

    DcMotor arm;

    DcMotor armextend;

    CRServo grabber;

    Servo rotator;

    public void runOpMode() {
        backL = hardwareMap.get(DcMotor.class, "bl");
        frontL = hardwareMap.get(DcMotor.class, "fl");
        backR = hardwareMap.get(DcMotor.class, "br");
        frontR = hardwareMap.get(DcMotor.class, "fr");
        arm = hardwareMap.get(DcMotor.class, "arm");
        armextend = hardwareMap.get(DcMotor.class, "armextend");

        backL.setDirection(DcMotor.Direction.REVERSE);//-
        backR.setDirection(DcMotor.Direction.FORWARD);//+
        frontL.setDirection(DcMotor.Direction.REVERSE);//-
        frontR.setDirection(DcMotor.Direction.REVERSE);//+;
        arm.setDirection(DcMotor.Direction.REVERSE);
        armextend.setDirection(DcMotor.Direction.REVERSE);

        backL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        armextend.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        grabber = hardwareMap.get(CRServo.class, "s_grab");
        rotator = hardwareMap.get(Servo.class, "s_rot");

//
        waitForStart();
        armangle(500, 0.25);
        arm.setTargetPosition(arm.getCurrentPosition());
        rotator.setPosition(0.5);
        sleep(1000);
        // strafeLeft(200, 0.7);
        // sleepy(500);
        armangle(2000, 0.3);
        arm.setTargetPosition(arm.getCurrentPosition());
        armlength(2750, 0.3);
        armextend.setTargetPosition(armextend.getCurrentPosition());
      //  servrot(0.7);
        sleep(1000);
        grabber.setPower(-1);
        sleep(750);
        grabber.setPower(0);
        sleep(1000);
        armlength(100, 0.3);
        sleep(1000);
        armextend.setTargetPosition(armextend.getCurrentPosition());
       // servrot(0.5);
        armangle(100, 0.25);
        arm.setTargetPosition(arm.getCurrentPosition());
        // strafeRight(300, 0.7);
//        frontL.setPower(0.25);
//        backL.setPower(0.25);
//        frontR.setPower(-0.25);
//        backR.setPower(-0.25);
        //sleep(30000);
//
// every 7.1350849256900215 ticks = 1mm
    }

    void strafeRight(int distance, double power) {
        backL.setTargetPosition(-distance + frontR.getCurrentPosition());
        frontL.setTargetPosition(distance + frontL.getCurrentPosition());
        backR.setTargetPosition(distance + backR.getCurrentPosition());
        frontR.setTargetPosition(-distance + frontR.getCurrentPosition());

        backL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontL.setMode(DcMotor.RunMode.RUN_TO_POSITION);

<<<<<<< HEAD
             backL.setPower(power);
             backR.setPower(power);
             frontL.setPower(power);
             frontR.setPower(power);
             //LOLZ
         }
=======
        backL.setPower(power);
        backR.setPower(power);
        frontL.setPower(power);
        frontR.setPower(power);
    }

    void armlength(int distance, double power) {
        armextend.setTargetPosition(distance + armextend.getCurrentPosition());

        armextend.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        armextend.setPower(power);

        while (armextend.isBusy()) {
            idle();
        }
    }
    void armangle(int distance, double power) {
        arm.setTargetPosition(distance + arm.getCurrentPosition());

        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        arm.setPower(power);

        while (arm.isBusy()) {
            idle();
        }
    }
    void grabgo(double power) {
        grabber.setPower(power);
    }

    void servrot(double distance) {
        rotator.setPosition(distance);
    }
>>>>>>> f498d0205df4f8e0236071246a19488c125790b4

    void straight(int distance, double power) {

        backL.setTargetPosition(distance + backL.getCurrentPosition());
        frontL.setTargetPosition(distance + frontL.getCurrentPosition());
        backR.setTargetPosition(distance + backR.getCurrentPosition());
        frontR.setTargetPosition(distance + frontR.getCurrentPosition());

        backL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontL.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        backL.setPower(power);
        backR.setPower(power);
        frontL.setPower(power);
        frontR.setPower(power);
    }


    void strafeLeft(int distance, double power) {
        backL.setTargetPosition(distance + backL.getCurrentPosition());
        frontL.setTargetPosition(-distance + frontL.getCurrentPosition());
        backR.setTargetPosition(-distance + backR.getCurrentPosition());
        frontR.setTargetPosition(distance + frontR.getCurrentPosition());

        backL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontL.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        backL.setPower(power);
        backR.setPower(power);
        frontL.setPower(power);
        frontR.setPower(power);
    }

    void reverse(int distance, double power) {

        backL.setTargetPosition(-distance + backL.getCurrentPosition());
        frontL.setTargetPosition(-distance + frontL.getCurrentPosition());
        backR.setTargetPosition(-distance + backR.getCurrentPosition());
        frontR.setTargetPosition(-distance + frontR.getCurrentPosition());

        backL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontL.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        backL.setPower(power);
        backR.setPower(power);
        frontL.setPower(power);
        frontR.setPower(power);
    }

    void turn_left(int distance, double power) {

        backL.setTargetPosition(-distance + backL.getCurrentPosition());
        frontL.setTargetPosition(-distance + frontL.getCurrentPosition());
        backR.setTargetPosition(distance + backR.getCurrentPosition());
        frontR.setTargetPosition(distance + frontR.getCurrentPosition());

        backL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontL.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        backL.setPower(power);
        backR.setPower(power);
        frontL.setPower(power);
        frontR.setPower(power);
    }

    void turn_right(int distance, double power) {

        backL.setTargetPosition(distance + backL.getCurrentPosition());
        frontL.setTargetPosition(distance + frontL.getCurrentPosition());
        backR.setTargetPosition(-distance + backR.getCurrentPosition());
        frontR.setTargetPosition(-distance + frontR.getCurrentPosition());

        backL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontL.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        backL.setPower(power);
        backR.setPower(power);
        frontL.setPower(power);
        frontR.setPower(power);
    }
}