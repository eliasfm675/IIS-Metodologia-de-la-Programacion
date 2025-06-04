package uo.mp.lab06.greenhouse.controllers;

import java.util.ArrayList;
import java.util.List;

import uo.mp.lab06.greenhouse.actuators.doors.Door;
import uo.mp.lab06.greenhouse.sensors.Sensor;
import uo.mp.lab06.greenhouse.sensors.TemperatureSensor;

/**
 * 
 * @author mp
 * @version 2.0
 */
public class TemperatureController {
	public static final double MAX_TEMPERATURE = 22;
	public static final double MIN_TEMPERATURE = 19;

	private List<TemperatureSensor> sensors = new ArrayList<>();	
	private List<Door> doors = new ArrayList<>();
		
		
	public void add(TemperatureSensor sensor) {
		this.sensors.add( sensor);
	}

	public void add(Door door) {
		this.doors.add(door);
	}

	/**
	 * Maneja las puertas para mantener la temperatura entre 19 y 22 grados
	 *
	 * @return Una lista de mensajes generados cuando se monitoriza
	 */
	public List<String> monitor() {
		
				
		/*
		 * Fuera hace fr�o, por lo que la apertura de las puertas siempre implica enfriar el interior.
		 * 
		 * Cuando getAverageTemperature() es mayor que MAX_TEMPERATURE) 
			� Deber�an abrirse algunas puertas para bajar la temperatura (si es posible)
			� Cada grado de diferencia (getAverageTemperature()-MAX_TEMPERATURE)) 
			     implica la apertura del 10% de las puertas (si es posible)
			� Mostrar un mensaje que indique cu�ntas puertas est�n a punto de abrirse (si es posible)
		 * 
		 Cuando getAverageTemperature() es menor que MIN_TEMPERATURE 
			� Deber�an cerrarse algunas puertas para aumentar la temperatura (si es posible)
			� Cada grado de diferencia (MIN_TEMPERATURE-getAverageTemperature()) 
			     implica el cierre del 10% de las puertas (si es posible)
			� Mostrar un mensaje que indique cu�ntas puertas est�n a punto de cerrarse (si es posible)
		 *
		 * En caso contrario, se mostrar� un mensaje  que indique simplemente la temperatura media
		 */

		/*
		 *  Las cadenas que se devolver�n al panel de control para informar al operario
		 *   despu�s de todas y cada una de las ejecuciones del m�todo monitor()
		 */
		List<String> messages = new ArrayList<>() ;	
		double temperature = getAverageTemperature();
		if(temperature > MAX_TEMPERATURE) {
			messages.addAll(coolDown(temperature));
		}else if(temperature < MIN_TEMPERATURE){
			messages.addAll(warmUp(temperature));
		}else {
			messages.add(rightTemperature(temperature));
		}
		return messages;
	}
	
	/**
	 * Calienta el invernadero
	 * @param temp la temperatura media
	 * @return una lista de mensajes para informar al operario, producidos al intentar
     *         calentar el invernadero
	 * 
	 */
	private List<String> warmUp(double temp) {
		List<String> messages = new ArrayList<String>();
		messages.add(String.format("Current temp is %2.2f. It is too cold /n", temp));
		double difference = MIN_TEMPERATURE - temp;
		int doorsToClose = (int) (difference* doors.size()*0.1) +1 ;
		messages.add(String.format("%d doors must be closed", doorsToClose));
		messages.addAll(closeDoors(doorsToClose));
		return messages;
	}
	
	/**
	 * Intenta cerrar doorsToClose puertas 
	 * @param doorsToClose n�mero de pertas a cerrar 
	 * @return una lista de mensajes para informar al operario, producidos al intentar
     *         cerrar tantas puertas como indica el par�metro
	 * 
	 */
	private List<String> closeDoors(int doorsToClose) {
		List<String> messages = new ArrayList<String>();
		int doorsClosed = 0;
		for(int i=0; doorsClosed<doorsToClose && i<doors.size(); i++) {
			Door door = doors.get(i);
			if(door.isOpened()) {
				messages.add(door.close());
				doorsClosed++;
			}
		}
		if(doorsClosed<doorsToClose) {
			messages.add(String.format("WARNING. Not enough doors could be opened. %d doors should be opened", doorsToClose - doorsClosed));
		}
		return messages;
	}
	
	/**
	 * Enfria el invernadero
	 * @param temp la temperatura media
	 * @return una lista de mensajes para informar al operario, producidos al intentar
     *         enfriar el invernadero
	 */
	private List<String> coolDown(double temp) {
		List<String> messages = new ArrayList<String>();
		messages.add(String.format("Current temp is %2.2f. It is too hot\n", temp));
		double difference = temp - MAX_TEMPERATURE;
		int doorsToOpen = (int) (difference * (doors.size()*0.10)) +1;// esto es porque el cast trunca;	
		messages.add(String.format("%d doors must be opened", doorsToOpen));
		messages.addAll(openDoors(doorsToOpen));
		return messages;
	}

	/**
	 * Intenta abrir doorsToOpen puertas
	 * @param doorsToOpen  n�mero de pertas a abrir
	 * @return una lista de mensajes para informar al operario, producidos al intentar
     *         abrir tantas puertas como indica el par�metro
	 */
	private List<String> openDoors(int doorsToOpen) {
		List<String> messages = new ArrayList<String>();
		int doorsOpened = 0;
		for(int i=0; doorsOpened < doorsToOpen && i<doors.size(); i++) {
			Door door  = doors.get(i);
			if(!door.isOpened()) {
				messages.add(door.open());
				doorsOpened++;
			}
		}
		if(doorsOpened<doorsToOpen) {
			messages.add(String.format("WARNING. Not enough doors could be opened. %d doors should be opened", doorsToOpen - doorsOpened));
		}
	
		return messages;
	}
	
	
	private String rightTemperature(double temp) {
		return "Average temperature " +  temp + " is right";
	}
	
	/**
	 * Obtiene la temperatura media en el invernadero
	 * 
	 * @return la temperatura media en el invernadero
	 */
	private double getAverageTemperature() {
		double addition = 0;
		for(TemperatureSensor sensor : sensors) {
			addition += sensor.getTemperature();
		}
		return addition / sensors.size();
	}
}
