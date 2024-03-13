package org.indra.claseTres.models;

import java.util.*;
import java.text.MessageFormat;

public class Estudiante extends Persona {
	private static int TOTAL_ALUMNOS = 0;
	private int numeroAlumno;
	// private String nombre;
	// private String apellido;
	int materiasAprobadas;

	public Estudiante(String nombre, String apellido) {
		super(nombre, apellido);
		this.numeroAlumno = TOTAL_ALUMNOS + 1;
		TOTAL_ALUMNOS++;
		// this.nombre = nombre;
		// this.apellido = apellido;
		this.materiasAprobadas = 0;
	}

	/**
	 * @return the materiasAprobadas
	 */
	public int getMateriasAprobadas() {
		return materiasAprobadas;
	}

	/**
	 * @param materiasAprobadas the materiasAprobadas to set
	 */
	public void setMateriasAprobadas(int materiasAprobadas) {
		this.materiasAprobadas = materiasAprobadas;
	}

	/**
	 * @return the numeroAlumno
	 */
	public int getNumeroAlumno() {
		return numeroAlumno;
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
				Soy el estudiante número {0} {1} {2}
				En total he aprobado {3} materias\n
				""", this.numeroAlumno, super.getNombre(), super.getApellido(), this.materiasAprobadas));
	}
}
