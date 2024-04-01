package org.indra.claseSeis.models;

import java.time.LocalDate;

public class ClienteBuilder {
	private int id;
	private int dni;
	private LocalDate fechaNacimiento;
	private String nombre;
	private String apellido;

	public ClienteBuilder withId(int id) {
		this.id = id;
		return this;
	}

	public ClienteBuilder withDni(int dni) {
		this.dni = dni;
		return this;
	}

	public ClienteBuilder withNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public ClienteBuilder withApellido(String apellido) {
		this.apellido = apellido;
		return this;
	}

	public ClienteBuilder withFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
		return this;
	}

	public Cliente build() {
		if (nombre == null || nombre.trim().length() == 0) {
			throw new Error("Falta el nombre");
		}

		Cliente c = new Cliente();
		c.setId(this.id);
		c.setDni(this.dni);
		c.setFechaNacimiento(this.fechaNacimiento);
		c.setNombre(this.nombre);
		c.setApellido(this.apellido);

		return c;
	}
}
