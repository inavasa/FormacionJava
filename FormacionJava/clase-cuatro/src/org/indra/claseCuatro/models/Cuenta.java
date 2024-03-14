package org.indra.claseCuatro.models;

import java.time.LocalDate;
import java.util.*;

public abstract class Cuenta extends ObjetoDeNegocio {
	private static int ULTIMO_NUMERO_CUENTA = 0;
	private int numeroDeCuenta;
	private Cliente cliente;
	private LocalDate fechaCreacion;
	protected List<Movimiento> movimientos;

	/**
	 * @param cliente
	 */
	public Cuenta(Cliente cliente) {
		super();
		this.cliente = cliente;
		this.fechaCreacion = LocalDate.now();
		this.movimientos = new ArrayList<Movimiento>();
		this.numeroDeCuenta = ULTIMO_NUMERO_CUENTA + 1;
		ULTIMO_NUMERO_CUENTA++;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @return the fechaCreacion
	 */
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * @return the movimientos
	 */
	public List<Movimiento> getMovimientos() {
		return movimientos;
	}

	public double getSaldo() {
		double saldo = 0;
		for (Movimiento m : movimientos) {
			if (m.getTipoDeMovimiento() == TipoDeMovimiento.Entrada) {
				saldo += m.getValor();
			} else if (m.getTipoDeMovimiento() == TipoDeMovimiento.Salida) {
				saldo -= m.getValor();
			}
		}
		return saldo;
	}

	public abstract void depositar(double valor);

	public abstract void extraer(double valor) throws SaldoInsuficienteException;
}
