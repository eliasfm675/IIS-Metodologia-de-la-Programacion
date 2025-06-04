package uo.mp.lab06.greenhouse.sensors;

import java.util.Random;

import uo.mp.lab06.greenhouse.electronicdevices.ElectronicDevices;


/**
 * <p>Title: Sensor</p>
 * <p>Description: Class that simulates a temperature sensor.</p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Computer Science Engineering School</p>
 * <p>Programming Methodology</p>
 * 
 * @author mp
 * @version 1.0
 */
public class TemperatureSensor extends Sensor implements ElectronicDevices{

	public TemperatureSensor(int id) {
		super(id);
	}

	/**
	 * Simula la obtencci�n de la temperatura 
	 * 
	 * Devuelve un valor en el rango [5, 40]
	 * @return la temperatura generada por el sensor
	 */
	public int getTemperature() {
		return new Random().nextInt(36) + 5;
	}

	
	
	@Override
	public String toString() {
		return "[TemperatureSensor] " + id ;
	}

	@Override
	public String scan() {
		Random  r = new Random();
		double fail = r.nextDouble();
		if(fail>0.005) {
			return "";
		}else {
			return toString() + " is not in a good condition";
		}
	}
	
}
