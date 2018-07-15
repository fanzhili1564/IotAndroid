package com.car.smart.clientapp.driver;

import android.support.annotation.IntRange;
import android.support.test.runner.AndroidJUnit4;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class TestWheelDrive {

    @BeforeClass
    public void setUp() {
        try {
            WheelDrive.getInstance().start();
        } catch (BaseDrive.DriveException e) {
            Assert.fail();
        }
    }

    @Test
    public void start_wheel() {
        try {
            WheelDrive.getInstance().start();
        } catch (BaseDrive.DriveException e) {
            Assert.fail();
        }
    }

    @Test
    public void forward_wheel_test() {
        forward_wheel(10);
        forward_wheel(20);
        forward_wheel(30);
        forward_wheel(40);
        forward_wheel(50);
        forward_wheel(60);
        forward_wheel(70);
        forward_wheel(80);
        forward_wheel(90);
        forward_wheel(100);
        forward_wheel(110);
    }

    @Test
    public void reversing_wheel_test() {
        reversing_wheel(10);
        reversing_wheel(20);
        reversing_wheel(30);
        reversing_wheel(40);
        reversing_wheel(50);
        reversing_wheel(60);
        reversing_wheel(70);
        reversing_wheel(80);
        reversing_wheel(90);
        reversing_wheel(100);
        reversing_wheel(110);
    }


    @Test
    public void turnLeftFront_wheel_test() {
        turnLeftFront_wheel(10);
        turnLeftFront_wheel(20);
        turnLeftFront_wheel(30);
        turnLeftFront_wheel(40);
        turnLeftFront_wheel(50);
        turnLeftFront_wheel(60);
        turnLeftFront_wheel(70);
        turnLeftFront_wheel(80);
        turnLeftFront_wheel(90);
        turnLeftFront_wheel(100);
        turnLeftFront_wheel(110);
    }

    @Test
    public void turnRightFront_wheel_test() {
        turnRightFront_wheel(10);
        turnRightFront_wheel(20);
        turnRightFront_wheel(30);
        turnRightFront_wheel(40);
        turnRightFront_wheel(50);
        turnRightFront_wheel(60);
        turnRightFront_wheel(70);
        turnRightFront_wheel(80);
        turnRightFront_wheel(90);
        turnRightFront_wheel(100);
        turnRightFront_wheel(110);
    }

    @Test
    public void turnRightBack_wheel_test() {
        turnRightBack_wheel(10);
        turnRightBack_wheel(20);
        turnRightBack_wheel(30);
        turnRightBack_wheel(40);
        turnRightBack_wheel(50);
        turnRightBack_wheel(60);
        turnRightBack_wheel(70);
        turnRightBack_wheel(80);
        turnRightBack_wheel(90);
        turnRightBack_wheel(100);
        turnRightBack_wheel(110);
    }

    @Test
    public void turnLeftBack_wheel_test() {
        turnLeftBack_wheel(10);
        turnLeftBack_wheel(20);
        turnLeftBack_wheel(30);
        turnLeftBack_wheel(40);
        turnLeftBack_wheel(50);
        turnLeftBack_wheel(60);
        turnLeftBack_wheel(70);
        turnLeftBack_wheel(80);
        turnLeftBack_wheel(90);
        turnLeftBack_wheel(100);
        turnLeftBack_wheel(110);
    }

    @Test
    public void stop_wheel() {
        try {
            WheelDrive.getInstance().stop();
        } catch (BaseDrive.DriveException exception) {
            Assert.fail();
        }
    }

    @AfterClass
    public void tearDown() {
        try {
            WheelDrive.getInstance().stop();
        } catch (BaseDrive.DriveException exception) {
            Assert.fail();
        }
    }

    /**
     * for test forward
     */
    private void forward_wheel(@IntRange(from = 1, to = 100) int mills) {
        try {
            WheelDrive.getInstance().forward(mills);
        } catch (BaseDrive.DriveException exception) {
            Assert.fail();
        }
    }

    /**
     * for test the car reversing
     */
    private void reversing_wheel(@IntRange(from = 1, to = 100) int mills) {
        try {
            WheelDrive.getInstance().reversing(mills);
        } catch (BaseDrive.DriveException exception) {
            Assert.fail();
        }
    }

    /**
     * for test turn left front with wheel
     */
    private void turnLeftFront_wheel(@IntRange(from = 1, to = 100) int mills) {
        try {
            WheelDrive.getInstance().turnLeftFront(mills);
        } catch (BaseDrive.DriveException exception) {
            Assert.fail();
        }
    }

    /**
     * for test turn right front with wheel
     */
    private void turnRightFront_wheel(@IntRange(from = 1, to = 100) int mills) {
        try {
            WheelDrive.getInstance().turnRightFront(mills);
        } catch (BaseDrive.DriveException exception) {
            Assert.fail();
        }
    }

    /**
     * for test turn right back with wheel
     */
    private void turnRightBack_wheel(@IntRange(from = 1, to = 100) int mills) {
        try {
            WheelDrive.getInstance().turnRightBack(mills);
        } catch (BaseDrive.DriveException exception) {
            Assert.fail();
        }
    }

    /**
     * for test turn left back with wheel
     */
    private void turnLeftBack_wheel(@IntRange(from = 1, to = 100) int mills) {
        try {
            WheelDrive.getInstance().turnLeftBack(mills);
        } catch (BaseDrive.DriveException exception) {
            Assert.fail();
        }
    }

}
