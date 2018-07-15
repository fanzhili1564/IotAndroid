package com.car.smart.clientapp.driver;

import java.io.IOException;

public abstract class BaseDrive {
    public abstract void start() throws DriveException;

    public abstract void forward(int mills) throws DriveException;

    public abstract void reversing(int mills) throws DriveException;

    public abstract void turnLeftFront(int mills) throws DriveException;

    public abstract void turnRightFront(int mills) throws DriveException;

    public abstract void turnRightBack(int mills) throws DriveException;

    public abstract void turnLeftBack(int mills) throws DriveException;

    public abstract void stop() throws DriveException;


    /**
     * DriveException
     */
    public class DriveException extends IOException {

        public DriveException(String message) {
            super(message);
        }
    }
}
