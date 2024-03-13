package org.indra.claseTres.models;

import java.text.MessageFormat;

public class Profesor extends Persona {
	private String dni;
	private String nombre;
	private String apellido;
	private int cursosImpartidos;

	/**
	 * @param dni
	 * @param nombre
	 * @param apellido
	 */
	public Profesor(String dni, String nombre, String apellido) {
		super(nombre, apellido);
		this.dni = dni;
		// this.nombre = nombre;
		// this.apellido = apellido;
		this.cursosImpartidos = 0;
	}

	/**
	 * @return the cursosImpartidos
	 */
	public int getCursosImpartidos() {
		return this.cursosImpartidos;
	}

	/**
	 * @param cursosImpartidos the cursosImpartidos to set
	 */
	public void setCursosImpartidos(int cursosImpartidos) {
		this.cursosImpartidos = cursosImpartidos;
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return this.dni;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return super.getNombre();
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return super.getApellido();
	}

	@Override
	public void saludar() {
		System.out.println(MessageFormat.format("""
				Bienvenido {0} {1} con DNI {2}
				Usted ha impartido {3} cursos en total
				""", super.getNombre(), super.getApellido(), getDni(), getCursosImpartidos()));
	}
}
