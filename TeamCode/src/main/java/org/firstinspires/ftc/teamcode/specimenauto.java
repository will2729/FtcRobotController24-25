package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous (name = "SuperSpecimenAuto:3(park_HP)", group = "Robot")
public class specimenauto extends LinearOpMode {


        DcMotor backL;

        DcMotor frontL;

        DcMotor backR;

        DcMotor frontR;

DcMotor specmotor;
        double onepointfive = 1.5;
        double ticksperrev = 537.7; //ticks
        double circum = 301.44; //mm
        int fieldtile = (int) (620 * onepointfive); //mm og:609
        int halffieldtile = (int) (310 * onepointfive);
        double ticksper1mm = ticksperrev / circum;

        public void runOpMode() {
            backL = hardwareMap.get(DcMotor.class, "bl");
            frontL = hardwareMap.get(DcMotor.class, "fl");
            backR = hardwareMap.get(DcMotor.class, "br");
            frontR = hardwareMap.get(DcMotor.class, "fr");
            specmotor = hardwareMap.get(DcMotor.class, "spec");
            backL.setDirection(DcMotor.Direction.REVERSE);//-
            backR.setDirection(DcMotor.Direction.FORWARD);//+
            frontL.setDirection(DcMotor.Direction.REVERSE);//-
            frontR.setDirection(DcMotor.Direction.REVERSE);//+;
            specmotor.setDirection(DcMotorSimple.Direction.REVERSE);

            waitForStart();
            //straight(fieldtile, 0.5);
            //sleep(5000);
            //straight( halffieldtile, 0.5);
            //reverse (fieldtile, 0.5);
            //turn_left(fieldtile, 0.5);
            //turn_right(fieldtile, 0.5);
            strafeLeft(fieldtile+halffieldtile, 0.5);
            specmotor.setPower(0.4);
            sleep(2000);
            specmotor.setPower(0);
            strafeLeft(215, 0.5);
            specmotor.setPower(-0.4);
            sleep(2000);
            specmotor.setPower(-0);
            strafeRight(245, 0.5);
            straight(3*fieldtile, 0.5);
            strafeRight(fieldtile+halffieldtile, 0.5);
        }
// wheel cir 301.44
// ticks per rev 537.7


        void strafeRight(int mm, double power) {
            int distance = (int) mm * (int) ticksper1mm;
            backL.setTargetPosition(-distance + backL.getCurrentPosition());
            frontL.setTargetPosition(distance + frontL.getCurrentPosition());
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

            while (frontR.isBusy() || frontL.isBusy()) {
                idle();
            }
        }


        void straight(int mm, double power) {
            int distance = (int) mm * (int) ticksper1mm;

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
            while (frontR.isBusy() || frontL.isBusy()) {
                idle();
            }

        }


        void strafeLeft(int mm, double power) {
            int distance = (int) mm * (int) ticksper1mm;
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

            while (frontR.isBusy() || frontL.isBusy()) {
                idle();
            }
        }

        void reverse(int mm, double power) {
            int distance = (int) mm * (int) ticksper1mm;

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

            while (frontR.isBusy() || frontL.isBusy()) {
                idle();
            }

        }

        void turn_left(int mm, double power) {
            int distance = (int) mm * (int) ticksper1mm;

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

            while (frontR.isBusy() || frontL.isBusy()) {
                idle();
            }


        }

        void turn_right(int mm, double power) {
            int distance = (int) mm * (int) ticksper1mm;

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

            while (frontR.isBusy() || frontL.isBusy()) {
                idle();
            }

        }
    }








