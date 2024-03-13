package org.indra.claseTresFiguras.models;

public class TrianguloRectangulo extends Figura implements AreaCalculable {
	private double base;
	private double altura;

	public TrianguloRectangulo(Integer x, Integer y, double base, double altura) {
		super(x, y);
		this.base = base;
		this.altura = altura;
	}

	public TrianguloRectangulo(double base, double altura) {
		super(0, 0);
		this.base = base;
		this.altura = altura;
	}

	@Override
	public double calcularArea() {
		return (getBase() * getAltura()) / 2;
	}

	@Override
	public double calcularPerimetro() {
		double hipotenusa = Math.sqrt(Math.pow(getBase(), 2) + Math.pow(getAltura(), 2));

		return hipotenusa + getBase() + getAltura();
	}

	/**
	 * @return the base
	 */
	public double getBase() {
		return base;
	}

	/**
	 * @param base the base to set
	 */
	public void setBase(double base) {
		this.base = base;
	}

	/**
	 * @return the altura
	 */
	public double getAltura() {
		return altura;
	}

	/**
	 * @param altura the altura to set
	 */
	public void setAltura(double altura) {
		this.altura = altura;
	}
}
