package com.car.smart.clientapp.driver;

import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.things.pio.Gpio;
import com.google.android.things.pio.PeripheralManager;

import java.io.IOException;

public class WheelDrive extends BaseDrive {

    private Gpio INPUT_ENA_A;
    private Gpio INPUT_ENB_A;
    private Gpio INPUT_IN1_A;
    private Gpio INPUT_IN2_A;
    private Gpio INPUT_IN3_A;
    private Gpio INPUT_IN4_A;

    private Gpio INPUT_IN1_B;
    private Gpio INPUT_IN2_B;
    private Gpio INPUT_IN3_B;
    private Gpio INPUT_IN4_B;
    private Gpio INPUT_ENA_B;
    private Gpio INPUT_ENB_B;

    @Nullable
    private static BaseDrive mDrive = null;

    private WheelDrive() throws WheelDriveException {
        initDrive();
    }

    @NonNull
    public static BaseDrive getInstance() {
        if (mDrive == null) {
            try {
                mDrive = new WheelDrive();
            } catch (WheelDriveException e) {
                mDrive = new NoneDrive();
            }
        }
        return mDrive;
    }

    private void initDrive() throws WheelDriveException {
        PeripheralManager pioService = PeripheralManager.getInstance();
        try {
            INPUT_IN1_A = pioService.openGpio("BCM17");
            INPUT_IN2_A = pioService.openGpio("BCM18");
            INPUT_IN3_A = pioService.openGpio("BCM27");
            INPUT_IN4_A = pioService.openGpio("BCM22");
            INPUT_ENA_A = pioService.openGpio("BCM23");
            INPUT_ENB_A = pioService.openGpio("BCM24");

            INPUT_IN1_B = pioService.openGpio("BCM6");
            INPUT_IN2_B = pioService.openGpio("BCM13");
            INPUT_IN3_B = pioService.openGpio("BCM16");
            INPUT_IN4_B = pioService.openGpio("BCM19");
            INPUT_ENA_B = pioService.openGpio("BCM26");
            INPUT_ENB_B = pioService.openGpio("BCM20");

        } catch (IOException e) {
            throw new WheelDriveException("Can not init");
        }
    }

    /**
     * start car, but car is not move.
     */
    public void start() throws WheelDriveException {
        try {
            INPUT_ENA_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_HIGH);
            INPUT_ENB_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_HIGH);

            INPUT_ENA_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_HIGH);
            INPUT_ENB_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_HIGH);

            INPUT_IN1_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
            INPUT_IN2_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
            INPUT_IN3_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
            INPUT_IN4_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);

            INPUT_IN1_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
            INPUT_IN2_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
            INPUT_IN3_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
            INPUT_IN4_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
        } catch (IOException e) {
            throw new WheelDriveException(e.getMessage());
        }
    }

    /**
     * Start to let the car go ahead
     */
    public void forward(@IntRange(from = 0, to = 100) int mills) throws WheelDriveException {
        while (true) {
            try {
                INPUT_IN1_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_HIGH);
                INPUT_IN2_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
                INPUT_IN3_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_HIGH);
                INPUT_IN4_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);

                INPUT_IN1_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_HIGH);
                INPUT_IN2_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
                INPUT_IN3_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_HIGH);
                INPUT_IN4_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
                Thread.sleep(mills);

                INPUT_IN1_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
                INPUT_IN3_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);

                INPUT_IN1_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
                INPUT_IN3_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
                Thread.sleep(100 - mills);
            } catch (IOException | InterruptedException e) {
                throw new WheelDriveException(e.getMessage());
            }
        }
    }

    /**
     * Start to reverse the car
     */
    public void reversing(@IntRange(from = 0, to = 100) int mills) throws WheelDriveException {
        while (true) {
            try {
                INPUT_IN1_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
                INPUT_IN2_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_HIGH);
                INPUT_IN3_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
                INPUT_IN4_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_HIGH);

                INPUT_IN1_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
                INPUT_IN2_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_HIGH);
                INPUT_IN3_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
                INPUT_IN4_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_HIGH);
                Thread.sleep(mills);

                INPUT_IN2_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
                INPUT_IN4_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
                INPUT_IN2_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
                INPUT_IN4_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
                Thread.sleep(100 - mills);

            } catch (IOException | InterruptedException e) {
                throw new WheelDriveException(e.getMessage());
            }
        }

    }

    /**
     * turn the car of front left
     */

    public void turnLeftFront(@IntRange(from = 0, to = 100) int mills) throws WheelDriveException {

        while (true) {
            try {
                INPUT_IN1_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_HIGH);
                INPUT_IN2_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
                INPUT_IN1_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_HIGH);
                INPUT_IN2_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);

                INPUT_IN3_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
                INPUT_IN4_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
                INPUT_IN3_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
                INPUT_IN4_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);

                Thread.sleep(mills);

                INPUT_IN3_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_HIGH);
                INPUT_IN3_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_HIGH);

                Thread.sleep(100 - mills);
            } catch (IOException | InterruptedException e) {
                throw new WheelDriveException(e.getMessage());
            }
        }
    }

    /**
     * turn the car of right front
     */
    public void turnRightFront(@IntRange(from = 0, to = 100) int mills) throws WheelDriveException {

        while (true) {
            try {
                INPUT_IN1_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
                INPUT_IN2_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
                INPUT_IN1_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
                INPUT_IN2_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);

                INPUT_IN3_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_HIGH);
                INPUT_IN4_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
                INPUT_IN3_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_HIGH);
                INPUT_IN4_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);

                Thread.sleep(mills);

                INPUT_IN1_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_HIGH);
                INPUT_IN1_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_HIGH);

                Thread.sleep(100 - mills);
            } catch (IOException | InterruptedException e) {
                throw new WheelDriveException(e.getMessage());
            }
        }
    }

    /**
     * turn the car of front right
     */
    public void turnRightBack(@IntRange(from = 0, to = 100) int mills) throws WheelDriveException {

        while (true) {
            try {
                INPUT_IN1_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
                INPUT_IN2_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_HIGH);
                INPUT_IN1_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
                INPUT_IN2_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_HIGH);

                INPUT_IN3_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
                INPUT_IN4_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
                INPUT_IN3_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
                INPUT_IN4_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
                Thread.sleep(mills);

                INPUT_IN4_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_HIGH);
                INPUT_IN4_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_HIGH);
                Thread.sleep(100 - mills);
            } catch (IOException | InterruptedException e) {
                throw new WheelDriveException(e.getMessage());
            }
        }
    }

    /**
     * turn the car of front right
     */
    public void turnLeftBack(@IntRange(from = 0, to = 100) int mills) throws WheelDriveException {

        while (true) {
            try {
                INPUT_IN1_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
                INPUT_IN2_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
                INPUT_IN1_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
                INPUT_IN2_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);

                INPUT_IN3_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
                INPUT_IN4_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_HIGH);
                INPUT_IN3_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
                INPUT_IN4_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_HIGH);
                Thread.sleep(mills);

                INPUT_IN2_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_HIGH);
                INPUT_IN2_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_HIGH);
                Thread.sleep(100 - mills);
            } catch (IOException | InterruptedException e) {
                throw new WheelDriveException(e.getMessage());
            }
        }
    }
    /**
     * stop the car
     * */
    public void stop() throws WheelDriveException {
        try {
            INPUT_ENA_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
            INPUT_ENB_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);

            INPUT_ENA_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
            INPUT_ENB_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);

            INPUT_IN1_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
            INPUT_IN2_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
            INPUT_IN3_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
            INPUT_IN4_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);

            INPUT_IN1_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
            INPUT_IN2_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
            INPUT_IN3_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
            INPUT_IN4_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
        } catch (IOException e) {
            throw new WheelDriveException(e.getMessage());
        }
    }

    /**
     * WheelDriveException
     */
    public class WheelDriveException extends DriveException {

        public WheelDriveException(String message) {
            super(message);
        }
    }
}