/**
 * 
 */
package uo.mp.lab06.greenhouse.actuators.doors;

import uo.mp.util.check.ArgumentChecks;

/**
 * 
 */
public class IrrigationSystem {
	/**
	 * Constantes de posicion
	 */
	public static final int OFF = 0;
	public static final int LOW = 1;
	public static final int MEDIUM = 2;
	public static final int HIGH = 3;
	
	private int position;
	public IrrigationSystem() {
		setPosition(OFF);
	}

	/**
	 * @return the position
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	private void setPosition(int position) {
		ArgumentChecks.isTrue(position==OFF || position==LOW || position==MEDIUM || position==HIGH , "Position not valid");
		this.position = position;
	}
	/**
	 * Método para cambiar la posicion del sistema
	 */
	public String changePosition(int position) {
		switch(position) {
		case OFF:
			return "Irrigator set to OFF";
		case LOW:
			return "Irrigator set to LOW";
		case MEDIUM:
			return "Irrigator set to MEDIUM";
		case HIGH:
			return "Irrigator set to HIGH";
		default:
			return "ERROR";
		}
	}
}
