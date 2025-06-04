package uo.mp.lab06.greenhouse.controlpanel;

import java.util.List;

import uo.mp.lab06.greenhouse.actuators.doors.AutomaticDoor;
import uo.mp.lab06.greenhouse.actuators.doors.Door;
import uo.mp.lab06.greenhouse.controllers.MoistureController;
import uo.mp.lab06.greenhouse.controllers.TemperatureController;
import uo.mp.lab06.greenhouse.controllers.devicescanner.DeviceScanner;
import uo.mp.lab06.greenhouse.sensors.MoistureSensor;
import uo.mp.lab06.greenhouse.sensors.TemperatureSensor;

/**
 * <p>Title: GreenHouse</p>
 * <p>Description: Class that simulates a greenhouse.</p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Computer Science Engineering School</p>
 * <p>Programming Methodology</p>
 * 
 * @author mp
 * @version 2.0
 */
public class GreenhouseController {
	
	private TemperatureController tempCtrl = new TemperatureController();
	private DeviceScanner devScan = new DeviceScanner();
	private MoistureController moisCtrl = new MoistureController();	
	/**
	 * A�ade sensores de temperatura al controlador de temperatura
	 * @param sensor
	 */
	public void add(TemperatureSensor sensor) {
		tempCtrl.add( sensor );
		devScan.add(sensor);
	}
	/**
	 * A�ade sensores de temperatura al controlador de temperatura
	 * @param sensor
	 */
	public void add(MoistureSensor sensor) {
		moisCtrl.add( sensor );
		devScan.add(sensor);
	}

	/**
	 * A�ade puertas manejadas por el operario a el controlador de temperatura
	 * @param sensor
	 */
	public void add(Door door) {
		tempCtrl.add( door );	
		devScan.add(new AutomaticDoor(0));
	}

	/**
	 * Inicia todas las operaciones de control
	 * Muestra los mensajes devueltos por dichas operaciones
	 */
	public void start() {
		while (true) {
			/*
			 * Run temperature controller and diplays messages returned 
			 * to command the gardener
			 */
			display(tempCtrl.monitor());
			display(devScan.scan());
			display(moisCtrl.monitor());
			sleep(2000);
		}
	}

	private void display(List<String> arg) {
		for (String message: arg) {
			System.out.println(message);
		}		
	}

	private void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// Ignore it
		}
	}

}
