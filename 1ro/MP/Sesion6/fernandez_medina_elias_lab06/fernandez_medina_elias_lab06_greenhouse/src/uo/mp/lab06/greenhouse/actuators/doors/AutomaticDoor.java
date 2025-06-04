/**
 * 
 */
package uo.mp.lab06.greenhouse.actuators.doors;

import java.util.Random;

import uo.mp.lab06.greenhouse.electronicdevices.ElectronicDevices;

/**
 * 
 */
public class AutomaticDoor extends Door implements ElectronicDevices{

	public AutomaticDoor(int id) {
		super(id);
	}
	@Override
	public String open() {
		boolean opened = super.isOpened();
		if(!opened) {
			opened = true;
			return "Automatic door " + super.getId() + " is opening";
		}
		return "";
	}
	@Override
	public String close() {
		boolean opened = super.isOpened();
		if(opened) {
			opened = false;
			return "Automatic door " + super.getId() + " is closing";
		}
		return "";
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
	@Override
	public String toString() {
		return "[AutomaticDoor] " + super.getId();
	}

}
