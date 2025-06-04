package uo.mp.lab06.greenhouse;


import uo.mp.lab06.greenhouse.actuators.doors.Door;
import uo.mp.lab06.greenhouse.actuators.doors.AutomaticDoor;
import uo.mp.lab06.greenhouse.controlpanel.GreenhouseController;
import uo.mp.lab06.greenhouse.sensors.TemperatureSensor;
import uo.mp.lab06.greenhouse.sensors.MoistureSensor;

/**
 * <p>Title: Application</p>
 * <p>Description: Class that executes the program.</p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Computer Science Engineering School</p>
 * <p>Programming Methodology</p>
 * 
 * @author mp
 * @version 2.0
 */
public class Main {
	
	private GreenhouseController greenhouse;

	/**
	 * M�todo principal que lanza la aplicaci�n
	 * 
	 * @param args	
	 */
	public static void main(String[] args) {
		new Main()
			.configure()
			.run();
	}

	/*
	 * Set doors, temperature and humidity sensors
	 */
	private Main configure() {
		greenhouse = new GreenhouseController();
		
		for (int i = 0; i < 10; i++) {
			greenhouse.add( new TemperatureSensor(i) );			
			greenhouse.add( new Door(i) );
			greenhouse.add( new AutomaticDoor(i) );
			greenhouse.add( new MoistureSensor(i) );
		}

		return this;
	}

	/**
	 * M�todo que ejecuta la aplicaci�n
	 */
	public void run() {
		greenhouse.start();
	}

}
