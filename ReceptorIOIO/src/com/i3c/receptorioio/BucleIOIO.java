package com.i3c.receptorioio;

import ioio.lib.api.DigitalOutput;
import ioio.lib.api.PwmOutput;
import ioio.lib.api.exception.ConnectionLostException;
import ioio.lib.util.BaseIOIOLooper;

public class BucleIOIO extends BaseIOIOLooper{
	
	private PwmOutput[] servos;
	private DigitalOutput led;

	@Override
	protected void setup() throws ConnectionLostException {
		servos = new PwmOutput[3];
		led = ioio_.openDigitalOutput(0, true);
		servos[0] = ioio_.openPwmOutput(4, 50); //3 y 50Hz Velocidad
		servos[1] = ioio_.openPwmOutput(13, 50); // Servo
	}

	@Override
	public void disconnected() {
		//MainActivity.cambiarEstado("Desconectado IOIO");
	}

	@Override
	public void loop() throws ConnectionLostException {
		led.write(false);
		try {
			servos[0].setPulseWidth(1000 + Main.mensaje_veloc);
			servos[1].setPulseWidth(1000 + Main.mensaje_giro);
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
