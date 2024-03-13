package org.indra.claseTresFiguras.models;

public class Terreno implements AreaCalculable {
	double largo;
	double ancho;

	/**
	 * @param largo
	 * @param ancho
	 */
	public Terreno(double largo, double ancho) {
		this.largo = largo;
		this.ancho = ancho;
	}

	/**
	 * @return the largo
	 */
	public double getLargo() {
		return largo;
	}

	/**
	 * @param largo the largo to set
	 */
	public void setLargo(double largo) {
		this.largo = largo;
	}

	/**
	 * @return the ancho
	 */
	public double getAncho() {
		return ancho;
	}

	/**
	 * @param ancho the ancho to set
	 */
	public void setAncho(double ancho) {
		this.ancho = ancho;
	}

	public double calcularArea() {
		return getAncho() * getLargo();
	}
}
