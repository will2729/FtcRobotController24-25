/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;
// import com.qualcomm.robotcore.util.Range;

/*
 * This OpMode executes a Tank Drive control TeleOp a direct drive robot
 * The code is structured as an Iterative OpMode
 *
 * In this mode, the left and right joysticks control the left and right motors respectively.
 * Pushing a joystick forward will make the attached motor drive forward.
 * It raises and lowers the claw using the Gamepad Y and A buttons respectively.
 * It also opens and closes the claws slowly using the left and right Bumper buttons.
 *
 * Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this OpMode to the Driver Station OpMode list
 */

//
@TeleOp(name="robot: Driving the McTickler: Premium Edition", group="Robot")
// @Disabled
public class RobotTeleopTank_Iterative_after_1_tournament extends OpMode{

    /* Declare OpMode members. */
    public DcMotor  leftfront   = null;
    public DcMotor  rightfront  = null;
    public DcMotor  leftback  = null;
    public DcMotor  rightback  = null;
    public DcMotor  arm = null;
    public DcMotor  armextend = null;
     public CRServo    grabber    = null;
     public Servo    rotator   = null;

     // double clawOffset = 0;

   // public static final double MID_SERVO   =  0.5 ;
//    public static final double CLAW_SPEED  = 0.02 ;        // sets rate to move servo
//    public static final double ARM_UP_POWER    =  0.50 ;   // Run arm motor up at 50% power
//    public static final double ARM_DOWN_POWER  = -0.25 ;   // Run arm motor down at -25% power

    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        // Define and Initialize Motors
        leftfront  = hardwareMap.get(DcMotor.class, "fl");
        rightfront = hardwareMap.get(DcMotor.class, "fr");
        leftback  = hardwareMap.get(DcMotor.class, "bl");
        rightback = hardwareMap.get(DcMotor.class, "br");
        arm = hardwareMap.get(DcMotor.class, "arm");
        armextend = hardwareMap.get(DcMotor.class, "armextend");
//
        // To drive forward, most robots need the motor on one side to be reversed, because the axles point in opposite directions.
        // Pushing the left and right sticks forward MUST make robot go forward. So adjust these two lines based on your first test drive.
        // Note: The settings here assume direct drive on left and right wheels.  Gear Reduction or 90 Deg drives may require direction flips
        leftfront.setDirection(DcMotor.Direction.REVERSE);
        rightfront.setDirection(DcMotor.Direction.REVERSE);
        leftback.setDirection(DcMotor.Direction.REVERSE);
        rightback.setDirection(DcMotor.Direction.FORWARD);
        arm.setDirection(DcMotor.Direction.REVERSE);
        armextend.setDirection(DcMotor.Direction.REVERSE);


        arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        armextend.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//


        // If there are encoders connected, switch to RUN_USING_ENCODER mode for greater accuracy
        armextend.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armextend.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        arm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

//
        // setting up positions
        leftfront.setTargetPosition(0);
        leftback.setTargetPosition(0);
        rightfront.setTargetPosition(0);
        rightback.setTargetPosition(0);
        arm.setTargetPosition(0);
        armextend.setTargetPosition(0);

//

        // rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Define and initialize ALL installed servos.
         grabber  = hardwareMap.get(CRServo.class, "s_grab");
         rotator = hardwareMap.get(Servo.class, "s_rot");
       // leftClaw.setPosition(MID_SERVO);
       // rightClaw.setPosition(MID_SERVO);

        // Send telemetry message to signify robot waiting;
        telemetry.addData(">", "Robot Ready.  Press START.");    //
    }

//

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit START
     */

    @Override
    public void init_loop() {
    }

    /*
     * Code to run ONCE when the driver hits START
     */


    @Override
    public void start() {
    }
//
    /*
     * Code to run REPEATEDLY after the driver hits START but before they hit STOP
     */
    @Override
    public void loop() {
        double front;
        double turn;
        double strafe;

        double armud;
        boolean armup;
        boolean armdown;
        boolean armmid;

        boolean armforward;
        boolean armback;

        boolean servrotpos;
        boolean servrotneg;

        double servgrabtrue;
        double servgrabfalse;

        boolean divider_gamepad1;
        boolean divider_gamepad2;



        String telementrybreak1;
        telementrybreak1 = ("raw imput");

        String telementrybreak2;
        telementrybreak2 = ("gamepad 2");

//

        // Run wheels in tank mode (note: The joystick goes negative when pushed forward, so negate it)
        front = -gamepad1.left_stick_y;
        turn = -gamepad1.right_stick_x;
        strafe = -gamepad1.left_stick_x;

        armud = Range.clip(gamepad2.left_stick_y, -0.65, 0.65);
        armforward = gamepad2.dpad_up;
        armback = gamepad2.dpad_down;
        armup = gamepad2.y;
        armdown = gamepad2.a;
        armmid = gamepad2.x;

        servrotpos = gamepad2.right_bumper;
        servrotneg = gamepad2.left_bumper;
        servgrabtrue = gamepad2.right_trigger;
        servgrabfalse = gamepad2.left_trigger;
//
        divider_gamepad1 = gamepad1.left_bumper;
        divider_gamepad2 = gamepad2.b;





        if (!divider_gamepad1) {
            leftfront.setPower(front - turn - strafe);
            leftback.setPower(front - turn + strafe);
            rightfront.setPower(front + turn + strafe);
            rightback.setPower(front + turn - strafe);
        }
        else if (divider_gamepad1) {
            leftfront.setPower((front - turn - strafe) / 2);
            leftback.setPower((front - turn + strafe) / 2);
            rightfront.setPower((front + turn + strafe) / 2);
            rightback.setPower((front + turn - strafe) / 2);
        }



//





//        leftfront.setPower(-turn);
//        leftback.setPower(-turn);
//        rightfront.setPower(turn);
//        rightback.setPower(turn);
//
//        leftfront.setPower(-strafe);
//        leftback.setPower(strafe);
//        rightfront.setPower(strafe);
//        rightback.setPower(-strafe);

//


        if (armup) {
            arm.setTargetPosition(2750);
            arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            arm.setPower(0.8);

//
        }


        else if (armdown) {
            arm.setTargetPosition(100);
            arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            arm.setPower(0.8);

        }
//

        else if (armmid) {
            arm.setTargetPosition(1000);
            arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            arm.setPower(0.8);

        }
        else if (armud < 0.1 && armud > -0.1 && !armup && !armdown && !armmid){
            arm.setTargetPosition(arm.getCurrentPosition());
            arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        }
        else if (!divider_gamepad2){
            arm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            arm.setPower(-armud);
        }
        else if (divider_gamepad2){
            arm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            arm.setPower((-armud) / 2);
        }




//





        if (armforward && armextend.getCurrentPosition() < 2750 && !divider_gamepad2){
            armextend.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            armextend.setPower(0.45);
        }
        else if (armextend.getCurrentPosition() > 2750) {
            armextend.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            armextend.setPower(-1);
        }
        else if (armback && !divider_gamepad2) {
            armextend.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            armextend.setPower(-0.45);
        }
        else if (!armforward && !armback){
            armextend.setTargetPosition(armextend.getCurrentPosition());
            armextend.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
        else if (armforward && divider_gamepad2){
            armextend.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            armextend.setPower(0.2);
        }
        else if (armback && divider_gamepad2){
            armextend.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            armextend.setPower(-0.2);
        }



        grabber.setPower(servgrabtrue - servgrabfalse);

        // Use gamepad left & right Bumpers to open and close the clam

        if (servrotpos) {
            rotator.setPosition(rotator.getPosition() + 0.004);
        }
        else if (!servrotpos && !servrotneg){
            rotator.setPosition(rotator.getPosition());
        }
        else if (servrotneg){
            rotator.setPosition(rotator.getPosition() - 0.004);
        }
        //else
         //   rotator.setPosition



//



        // Move both servos to new position.  Assume servos are mirror image of each other.
        // clawOffset = Range.clip(clawOffset, -0.5, 0.5);
       // leftClaw.setPosition(MID_SERVO + clawOffset);
       // rightClaw.setPosition(MID_SERVO - clawOffset);

        // Use gamepad buttons to move the arm up (Y) and down (A)
//        if (gamepad1.y)
//            leftArm.setPower(ARM_UP_POWER);
//        else if (gamepad1.a)
//            leftArm.setPower(ARM_DOWN_POWER);
//        else
//            leftArm.setPower(0.0);

        // Send telemetry message to signify robot running;
//        telemetry.addData("claw",  "Offset = %.2f", clawOffset);
        telemetry.addData("direction_move",  "%.2f", front);
        telemetry.addData("direction_turn", "%.2f", turn);
        telemetry.addData("direction_strafe", "%.2f", strafe);
        telemetry.addData("armpower", "%.2f", armud);
        telemetry.addData("arm_f", armforward);
        telemetry.addData("arm_b", armback);
        telemetry.addData("armextend_position", armextend.getCurrentPosition());
        telemetry.addData("arm_position", arm.getCurrentPosition());
        telemetry.addData("armgraber_rotation" , rotator.getPosition());
        telemetry.addData("", telementrybreak1);
        telemetry.addData("gamepad1_leftstick_y", "%.2f", gamepad1.left_stick_y);
        telemetry.addData("gamepad1_rightstick_y", "%.2f", gamepad1.right_stick_y);
        telemetry.addData("gamepad1_leftstick_x", "%.2f", gamepad1.left_stick_x);
        telemetry.addData("gamepad1_lefttrigger", "%.2f", gamepad1.left_trigger);
        telemetry.addData("", telementrybreak2);
        telemetry.addData("gamepad2_leftstick_y", "%.2f", gamepad2.left_stick_y);
        telemetry.addData("gamepad2_lefttrigger", "%.2f", gamepad2.left_trigger);
        telemetry.addData("gamepad2_righttrigger", "%.2f", gamepad2.right_trigger);
        telemetry.addData("gamepad2_leftbumper", gamepad2.left_bumper);
        telemetry.addData("gamepad2_rightbumper", gamepad2.right_bumper);
        telemetry.addData("gamepad2_dpad_up", gamepad2.dpad_up);
        telemetry.addData("gamepad2_dpad_down", gamepad2.dpad_down);
        telemetry.addData("gamepad2_y", gamepad2.y);
        telemetry.addData("gamepad2_b", gamepad2.b);
        telemetry.addData("gamepad2_a", gamepad2.a);
        telemetry.addData("gamepad2_a", gamepad2.x);

//\



    }



    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
    }}

