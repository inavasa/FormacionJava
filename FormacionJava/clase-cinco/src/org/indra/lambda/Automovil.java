package org.indra.lambda;

public class Automovil {
	private double velocidad;

	/**
	 * @param velocidad
	 */
	public Automovil(double velocidad) {
		this.velocidad = velocidad;
	}

	/**
	 * @return the velocidad
	 */
	public double getVelocidad() {
		return velocidad;
	}

	/**
	 * @param velocidad the velocidad to set
	 */
	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Soy un vehículo que circula a " + this.getVelocidad();
	}
}
