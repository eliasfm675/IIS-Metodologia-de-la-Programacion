package uo.mp.lab06.greenhouse.sensors;

import java.util.Random;

import uo.mp.lab06.greenhouse.electronicdevices.ElectronicDevices;

public class MoistureSensor extends Sensor implements ElectronicDevices{
	public MoistureSensor(int id) {
		super(id);

	}
	public double getMoisture() {
		return new Random().nextInt(0, 101)/100;
		
	}
	@Override
	public String toString() {
		return "[MoistureSensor] " + id ;
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
