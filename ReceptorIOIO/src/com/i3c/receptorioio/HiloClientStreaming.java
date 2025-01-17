package com.i3c.receptorioio;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class HiloClientStreaming extends Thread {
	byte[] output;
	DatagramSocket s;

	HiloClientStreaming(byte[] out, DatagramSocket s) {
		this.output = out;
		this.s = s;
	}

	public void run() {
		try {
			DatagramPacket sendPacket = new DatagramPacket(output, output.length);
			s.send(sendPacket);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}