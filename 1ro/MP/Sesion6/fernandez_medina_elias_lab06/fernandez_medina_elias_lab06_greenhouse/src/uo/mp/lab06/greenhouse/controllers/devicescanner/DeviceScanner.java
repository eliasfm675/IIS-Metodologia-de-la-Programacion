/**
 * 
 */
package uo.mp.lab06.greenhouse.controllers.devicescanner;

import java.util.ArrayList;
import java.util.List;

import uo.mp.lab06.greenhouse.electronicdevices.ElectronicDevices;

/**
 * 
 */
public class DeviceScanner {
	private List<ElectronicDevices> devices;
	public DeviceScanner() {
		devices = new ArrayList<ElectronicDevices>();
	}
	public void add(ElectronicDevices ed) {
		this.devices.add(ed);
		
	}
	
	public List<String> scan(){
		List<String> messages = new ArrayList<String>();
		for(ElectronicDevices theDevice: devices) {
			messages.add(theDevice.scan());
		}
		return messages;
	}
}
