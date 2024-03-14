package org.indra.claseCuatro.models;

import java.time.*;

public class Cliente extends ObjetoDeNegocio {
	private int dni;
	private String nombre;
	private String apellido;
	private LocalDate fechaNacimiento;

	/**
	 * @param dni
	 * @param nombre
	 * @param apellido
	 * @param fechaNacimiento
	 */
	public Cliente(int dni, String nombre, String apellido, LocalDate fechaNacimiento) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return the dni
	 */
	public int getDni() {
		return dni;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @return the fechaNacimiento
	 */
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
}
