/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segmento.iot.nodos;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

/**
 *
 * @author Andres Sanchez
 */
public class ControlGpioLed {

    GpioController gpio;
    GpioPinDigitalOutput ledPin;

    public ControlGpioLed() {
        gpio = GpioFactory.getInstance();
        ledPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, "LED", PinState.LOW);
    }

    public void teminar() {
        gpio.shutdown();
    }

    public void encender() {        
        ledPin.high();
    }

    public void apagar() {
        ledPin.low();
    }

}
