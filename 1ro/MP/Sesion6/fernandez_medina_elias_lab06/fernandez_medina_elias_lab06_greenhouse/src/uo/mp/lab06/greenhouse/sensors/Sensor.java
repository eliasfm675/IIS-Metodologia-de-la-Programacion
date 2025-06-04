package uo.mp.lab06.greenhouse.sensors;

import uo.mp.lab06.greenhouse.electronicdevices.ElectronicDevices;

public class Sensor {

	protected int id;

	public Sensor(int id) {
		setId(id);
	}

	/**
	 * @return the id
	 */
	private int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	private void setId(int id) {
		this.id = id;
	}

}