package org.indra.claseCuatro.models;

public class Movimiento extends ObjetoDeNegocio {
	private double valor;
	private TipoDeMovimiento tipoDeMovimiento;

	/**
	 * @param valor
	 * @param tipoDeMovimiento
	 */
	public Movimiento(double valor, TipoDeMovimiento tipoDeMovimiento) {
		super();
		this.valor = valor;
		this.tipoDeMovimiento = tipoDeMovimiento;
	}

	/**
	 * @return the valor
	 */
	public double getValor() {
		return valor;
	}

	/**
	 * @return the tipoDeMovimiento
	 */
	public TipoDeMovimiento getTipoDeMovimiento() {
		return tipoDeMovimiento;
	}
}
