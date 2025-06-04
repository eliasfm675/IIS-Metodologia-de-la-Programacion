/**
 * 
 */
package uo.mp.lab01.plane.ui;

import uo.mp.lab01.plane.model.Person;
import uo.mp.lab01.plane.model.Plane;
import uo.mp.util.check.ArgumentChecks;

/**
 * @author UO299673
 *
 */
public class PlaneApp {
	private Person pilot;
	/**
	 * @return the pilot
	 */
	private Person getPilot() {
		return pilot;
	}
	/**
	 * @param pilot the pilot to set
	 */
	private void setPilot(Person pilot) {
		ArgumentChecks.isNotNull(pilot);
		this.pilot = pilot;
	}
	/**
	 * @return the plane
	 */
	private Plane getPlane() {
		return plane;
	}
	/**
	 * @param plane the plane to set
	 */
	private void setPlane(Plane plane) {
		ArgumentChecks.isNotNull(plane);
		this.plane = plane;
	}
	private Plane plane;
	public void run() {
		Person pilot = new Person("Fernando Alonso",42);
		Plane plane = new Plane(pilot, 'X', 1000);
		System.out.println("Datos del avión:\n" + plane.toString());
	}
}
