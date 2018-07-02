package com.car.smart.clientapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.things.pio.Gpio;
import com.google.android.things.pio.PeripheralManager;

import java.io.IOException;

/**
 * Skeleton of an Android Things activity.
 * <p>
 * Android Things peripheral APIs are accessible through the class
 * PeripheralManagerService. For example, the snippet below will open a GPIO pin and
 * set it to HIGH:
 * <p>
 * <pre>{@code
 * PeripheralManagerService service = new PeripheralManagerService();
 * mLedGpio = service.openGpio("BCM6");
 * mLedGpio.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
 * mLedGpio.setValue(true);
 * }</pre>
 * <p>
 * For more complex peripherals, look for an existing user-space driver, or implement one if none
 * is available.
 *
 * @see <a href="https://github.com/androidthings/contrib-drivers#readme">https://github.com/androidthings/contrib-drivers#readme</a>
 */
public class SplashActivity extends Activity {

    private Gpio INPUT_ENA_A;
    private Gpio INPUT_ENB_A;
    private Gpio INPUT_IN1_A;
    private Gpio INPUT_IN2_A;
    private Gpio INPUT_IN3_A;
    private Gpio INPUT_IN4_A;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initGpio();
    }

    private void initGpio() {
        PeripheralManager pioService = PeripheralManager.getInstance();
        try {
            INPUT_IN1_A = pioService.openGpio("BCM17");
            INPUT_IN2_A = pioService.openGpio("BCM18");
            INPUT_IN3_A = pioService.openGpio("BCM27");
            INPUT_IN4_A = pioService.openGpio("BCM22");
            INPUT_ENA_A = pioService.openGpio("BCM23");
            INPUT_ENB_A = pioService.openGpio("BCM24");

            INPUT_ENA_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_HIGH);
            INPUT_ENB_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_HIGH);

            INPUT_IN1_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_HIGH);
            INPUT_IN2_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
            INPUT_IN3_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_HIGH);
            INPUT_IN4_A.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);

            Gpio INPUT_IN1_B = pioService.openGpio("BCM6");
            Gpio INPUT_IN2_B = pioService.openGpio("BCM13");
            Gpio INPUT_IN3_B = pioService.openGpio("BCM16");
            Gpio INPUT_IN4_B = pioService.openGpio("BCM19");
            Gpio INPUT_ENA_B = pioService.openGpio("BCM26");
            Gpio INPUT_ENB_B = pioService.openGpio("BCM20");

            INPUT_ENA_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_HIGH);
            INPUT_ENB_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_HIGH);

            INPUT_IN1_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_HIGH);
            INPUT_IN2_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
            INPUT_IN3_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_HIGH);
            INPUT_IN4_B.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
        } catch (IOException e) {
            Log.e("SplashActivity", e.getMessage());
        }
    }
}
