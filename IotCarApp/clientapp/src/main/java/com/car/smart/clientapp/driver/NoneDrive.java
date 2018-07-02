package com.car.smart.clientapp.driver;

public class NoneDrive extends BaseDrive {

    /**
     * for error message
     * */
    private static final String ERROR_MESSAGE = "There is no drive!";

    public String getMessage() {
        return ERROR_MESSAGE;
    }
}
