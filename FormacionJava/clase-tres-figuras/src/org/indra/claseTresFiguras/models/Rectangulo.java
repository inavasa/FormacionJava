package org.indra.claseTresFiguras.models;

public class Rectangulo extends Figura {
	private double ladoA;
	private double ladoB;

	public Rectangulo(Integer x, Integer y, double ladoA, double ladoB) {
		super(x, y);
		this.ladoA = ladoA;
		this.ladoB = ladoB;
	}

	@Override
	public double calcularArea() {
		return getLadoA() * getLadoB();
	}

	@Override
	public double calcularPerimetro() {
		return 2 * (getLadoA() + getLadoB());
	}

	/**
	 * @return the ladoA
	 */
	public double getLadoA() {
		return ladoA;
	}

	/**
	 * @param ladoA the ladoA to set
	 */
	public void setLadoA(double ladoA) {
		this.ladoA = ladoA;
	}

	/**
	 * @return the ladoB
	 */
	public double getLadoB() {
		return ladoB;
	}

	/**
	 * @param ladoB the ladoB to set
	 */
	public void setLadoB(double ladoB) {
		this.ladoB = ladoB;
	}
}
