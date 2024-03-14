package org.indra.claseCuatro.models;

public class CajaDeAhorros extends Cuenta {

	public CajaDeAhorros(Cliente cliente) {
		super(cliente);
	}

	@Override
	public void depositar(double valor) {
		if (valor <= 0) {
			throw new Error("Cantidad introducida no válida");
		} else {
			this.movimientos.add(new Movimiento(valor, TipoDeMovimiento.Entrada));
		}
	}

	@Override
	public void extraer(double valor) throws SaldoInsuficienteException {
		if (valor <= 0) {
			throw new Error("Cantidad introducida no válida");
		}

		if (super.getSaldo() < valor) {
			throw new SaldoInsuficienteException("Saldo insuficiente");
		} else {
			this.movimientos.add(new Movimiento(valor, TipoDeMovimiento.Salida));
		}
	}

}
