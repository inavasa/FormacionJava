package org.indra.claseTresFiguras.models;

public class Circulo extends Figura {
	private double radio;

	public Circulo(Integer x, Integer y, double radio) {
		super(x, y);
		this.radio = radio;
	}

	@Override
	public double calcularArea() {
		return Math.PI * (Math.pow(getRadio(), 2));
	}

	@Override
	public double calcularPerimetro() {
		return 2 * Math.PI * getRadio();
	}

	/**
	 * @return the radio
	 */
	public double getRadio() {
		return radio;
	}

	/**
	 * @param radio the radio to set
	 */
	public void setRadio(double radio) {
		this.radio = radio;
	}
}
