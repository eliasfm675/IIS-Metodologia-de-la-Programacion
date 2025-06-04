package uo.mp.lab06.greenhouse.controllers;

import java.util.ArrayList;
import java.util.List;

import uo.mp.lab06.greenhouse.actuators.doors.IrrigationSystem;
import uo.mp.lab06.greenhouse.sensors.MoistureSensor;

public class MoistureController {
	private static final double MIN_MOISTURE = 0.4-(0.4*0.2);
	private static final double MAX_MOISTURE = 0.6+(0.6*0.2);
	private List<MoistureSensor> sensors = new ArrayList<MoistureSensor>();
	private IrrigationSystem system = new IrrigationSystem();
	public void add(MoistureSensor sensor) {
		this.sensors.add(sensor);
	}
	/**
	 * Método que devuelve la informacion de la humedad
	 */
	public List<String> monitor(){
		List<String> messages = new ArrayList<String>();
		if(getAverageMoisture()>MAX_MOISTURE) {
			messages.addAll(aboveLimit(getAverageMoisture()));
		}else if(getAverageMoisture()<MIN_MOISTURE) {
			messages.addAll(belowLimit(getAverageMoisture()));
		}else if(getAverageMoisture()<0.6 && getAverageMoisture()>0.4){
			messages.add(moistureIsRight());
		}else {
			messages.addAll(mildLimit(getAverageMoisture()));
		}
		return messages;
	}
	/**
	 * Método para cuando la humedad no está en el nivel de confort
	 */
	public List<String> mildLimit(double moisture){
		List<String> messages = new ArrayList<String>();
		messages.add(String.format("Current humidity: &2.2f"));
		if(moisture>0.6) {
			messages.add("It is a bit too damp");
			messages.add(String.format("Irrigator system is &d and is set to &d", system.getPosition(), system.getPosition()-1));
			system.changePosition(system.getPosition()-1);
		}else {
			messages.add("It is a bit too dry");
			messages.add(String.format("Irrigator system is &d and is set to &d", system.getPosition(), system.getPosition()+1));
			system.changePosition(system.getPosition()+1);
		}
		return messages;
		
	}
	/**
	 * Método para cuando la humedad sobrepasa el límite
	 */
	public List<String> aboveLimit(double moisture){
		List<String> messages = new ArrayList<String>();
		messages.add(String.format("Current humidity: &2.2f", moisture));
		messages.add("It is too damp");
		messages.add(String.format("Irrigator system is &d and is set to &d", system.getPosition(), system.OFF));
		system.changePosition(system.OFF);
		return messages;
		
		
	}
	/**
	 * Método para cuando la humedad no llega al límite inferior
	 */
	public List<String> belowLimit(double moisture){
		List<String> messages = new ArrayList<String>();
		messages.add(String.format("Current humidity: &2.2f", moisture));
		messages.add("It is too dry");
		messages.add(String.format("Irrigator system is &d and is set to &d", system.getPosition(), system.HIGH));
		system.changePosition(system.HIGH);
		return messages;
		
		
	}
	/**
	 * Método para cuando le humedad está bien
	 */
	public String moistureIsRight() {
		return "Humidity is right";
	}
	/**
	 * Método que devuelve la media de las humedades
	 * @return
	 */
	public double getAverageMoisture() {
		double addition = 0;
		for(MoistureSensor theSensor: sensors) {
			addition+=theSensor.getMoisture();
		}
		return addition/sensors.size();
	}
}
