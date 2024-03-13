package org.indra.claseDos.models;

import java.text.MessageFormat;

public class Persona {
	private String nombre;
	private String apellido;
	private int edad;

	public Persona(String nombre, String apellido, int edad) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}

	public Persona() {

	}

	public void setNombre(String nombre) {
		if (nombre == null || nombre.isEmpty()) {
			throw new Error("El nombre no puede ser vacío");
		}

		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		if (apellido == null || apellido.isEmpty()) {
			throw new Error("El apellido no puede ser vacío");
		}

		this.apellido = apellido;
	}

	public void setEdad(int edad) {
		if (edad <= 0 || edad > 140) {
			throw new Error("Edad no válida");
		}

		this.edad = edad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public int getEdad() {
		return this.edad;
	}
	
	@Override
	public String toString() {
		return MessageFormat.format("Soy {0} {1} de {2} años",
				this.getNombre(),
				this.getApellido(),
				this.getEdad());
	}
}
