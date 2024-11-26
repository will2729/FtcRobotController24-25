package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous (name = "AutoMcTickler: Premium Edition", group = "Robot")
public class autocodeadvanced extends LinearOpMode {

    DcMotor backL;

    DcMotor frontL;

    DcMotor backR;

    DcMotor frontR;
    DcMotor arm;
    DcMotor armextend;

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
//
         waitForStart();
         straight (2000, 0.5);
         sleepy(500);
         reverse (2000, 0.5);
         arm.setTargetPosition(250);
         arm.setPower(0.1);
         arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);

         armextend.setTargetPosition(-1000);
         armextend.setPower(-0.1);
         armextend.setMode(DcMotor.RunMode.RUN_TO_POSITION);

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

         void sleepy(int sleeptime) {
             backL.setPower(0);
             backL.setPower(0);
             backL.setPower(0);
             backL.setPower(0);
             sleep(sleeptime);
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








