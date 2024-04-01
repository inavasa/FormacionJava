package org.indra.claseSeis.models;

import java.time.LocalDate;

public class Cliente extends ObjetoDeNegocio {
	private int dni;
	private LocalDate fechaNacimiento;
	private String nombre;
	private String apellido;

	/**
	 * @return the dni
	 */
	public int getDni() {
		return dni;
	}

	/**
	 * @return the fechaNacimiento
	 */
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
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
	 * @param dni the dni to set
	 */
	void setDni(int dni) {
		this.dni = dni;
	}

	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @param nombre the nombre to set
	 */
	void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @param apellido the apellido to set
	 */
	void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public static ClienteBuilder builder() {
		return new ClienteBuilder();
	}

	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		cadena.append("\nEl cliente se llama: " + this.nombre + "\n");
		cadena.append("Con apellido: " + this.apellido + "\n");
		cadena.append("Con DNI: " + this.dni + "\n");
		cadena.append("Con fecha de nacimiento: " + this.fechaNacimiento + "\n");
		return cadena.toString();
	}
}
