package org.indra.claseCuatro.models;

public class CuentaCorriente extends Cuenta {
	private double maximo;
	private double saldoDescubierto;

	public CuentaCorriente(Cliente cliente) {
		super(cliente);
		this.maximo = 0;
		this.saldoDescubierto = 0;
	}

	public CuentaCorriente(Cliente cliente, double maximo, double saldoDescubierto) {
		super(cliente);
		this.maximo = maximo;
		this.saldoDescubierto = saldoDescubierto;
	}

	/**
	 * @return the maximo
	 */
	public double getMaximo() {
		return maximo;
	}

	/**
	 * @return the saldoDescubierto
	 */
	public double getSaldoDescubierto() {
		return saldoDescubierto;
	}

	@Override
	public void depositar(double valor) {
		if (valor <= 0) {
			throw new Error("Cantidad introducida no válida");
		} else if (valor + super.getSaldo() > getMaximo()) {
			throw new Error("Saldo excedido");
		} else {
			this.movimientos.add(new Movimiento(valor, TipoDeMovimiento.Entrada));
		}
	}

	@Override
	public void extraer(double valor) throws SaldoInsuficienteException {
		if (valor <= 0) {
			throw new Error("Cantidad introducida no válida");
		}

		if (super.getSaldo() - valor <= this.getSaldoDescubierto()) {
			throw new SaldoInsuficienteException("Saldo insuficiente");
		} else {
			this.movimientos.add(new Movimiento(valor, TipoDeMovimiento.Salida));
		}
	}

}
