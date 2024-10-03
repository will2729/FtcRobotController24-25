package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous
public class autocode extends LinearOpMode {

    DcMotor backL;

    DcMotor frontL;

    DcMotor backR;

    DcMotor frontR;

     public void runOpMode() {
         backL = hardwareMap.get(DcMotor.class, "backLeft");
         frontL = hardwareMap.get(DcMotor.class, "backRight");
         backR = hardwareMap.get(DcMotor.class, "frontLeft");
         frontR = hardwareMap.get(DcMotor.class, "frontRight");

         backL.setDirection(DcMotor.Direction.REVERSE);//-
         backR.setDirection(DcMotor.Direction.FORWARD);//+
         frontL.setDirection(DcMotor.Direction.REVERSE);//-
         frontR.setDirection(DcMotor.Direction.REVERSE);//+;

             strafeRight(57,0.5,500);
     }
         void strafeRight(int distance,double power,long sleeptime){
              backL.setTargetPosition(distance + backL.getCurrentPosition());
             frontL.setTargetPosition(-distance + frontL.getCurrentPosition() );
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

    

}
