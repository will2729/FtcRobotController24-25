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

         backL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
         backR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
         frontL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
         frontR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

         arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
         armextend.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

         grabber  = hardwareMap.get(CRServo.class, "s_grab");
         rotator = hardwareMap.get(Servo.class, "s_rot");



//
         waitForStart();
         strafeLeft(200, 0.7);
         sleepy(500);



//

     }
         void strafeRight(int distance,double power){
              backL.setTargetPosition(-distance + backL.getCurrentPosition());
             frontL.setTargetPosition(distance + frontL.getCurrentPosition() );
             backR.setTargetPosition(distance + backR.getCurrentPosition());
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

         void armlength(int distance, double power){
         armextend.setTargetPosition(distance + armextend.getCurrentPosition());

         armextend.setPower(power);
         }
         void armangle(int distance, double power){
         arm.setTargetPosition(distance + arm.getCurrentPosition());

         arm.setPower(power);
         }
         void grabgo(double power){
         grabber.setPower(power);
         }
         void servrot(int distance){
         rotator.setPosition(distance + rotator.getPosition());
         }

         void sleepy(int sleeptime) {
             boolean sleepcheck;
             sleepcheck = true;
             if (sleeptime > 0 && sleepcheck){
                 sleeptime = (sleeptime - 1 );
                 backL.setPower(0);
                 backR.setPower(0);
                 frontL.setPower(0);
                 frontR.setPower(0);
             }
             else if (sleeptime < 1){
                 sleepcheck = false;
             }
         }


         void straight(int distance,double power){

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


            void strafeLeft(int distance,double power) {
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
            void reverse (int distance,double power){

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

                void turn_left(int distance, double power){

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

                    void turn_right(int distance, double power){

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








