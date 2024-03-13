package org.indra.claseTresFiguras.models;

public abstract class Figura {
	private Integer x;
	private Integer y;

	/**
	 * @param x
	 * @param y
	 */
	public Figura(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}

	public Figura() {
		this.x = 0;
		this.y = 0;
	}

	/**
	 * @return the x
	 */
	public Integer getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(Integer x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public Integer getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(Integer y) {
		this.y = y;
	}

	public double calcularArea() {
		return getX() * getY();
	}

	public double calcularPerimetro() {
		return getX() + getY();
	}
}
