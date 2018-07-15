package com.car.smart.clientapp.driver;

public class NoneDrive extends BaseDrive {

    /**
     * for error message
     * */
    private static final String ERROR_MESSAGE = "There is no drive!";

    public String getMessage() {
        return ERROR_MESSAGE;
    }

    @Override
    public void start() {

    }

    @Override
    public void forward(int mills) {

    }

    @Override
    public void reversing(int mills) {

    }

    @Override
    public void turnLeftFront(int mills) throws DriveException {

    }

    @Override
    public void turnRightFront(int mills) throws DriveException {

    }

    @Override
    public void turnRightBack(int mills) throws DriveException {

    }

    @Override
    public void turnLeftBack(int mills) throws DriveException {

    }

    @Override
    public void stop() throws DriveException {

    }
}
