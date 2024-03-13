package org.indra.claseTres;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.indra.claseTres.models.*;

public class Program {
	public static void main(String[] args) {
		// Ejemplo 1
		System.out.println("Sistema para la universidad\n");

		List<Estudiante> estudiantes = new ArrayList<Estudiante>();
		estudiantes.add(new Estudiante("Ivan", "Navas"));
		estudiantes.add(new Estudiante("Jiten", "Parwani"));
		estudiantes.add(new Estudiante("Rubén", "González"));

		estudiantes.forEach(e -> e.saludar());
		// estudiantes.forEach(Estudiante::saludar);

		// Ejemplo 2
		List<Persona> personas = new ArrayList<Persona>();
		personas.add(new Profesor("46576917E", "Ivan", "Navas"));
		personas.add(new Estudiante("Jiten", "Parwani"));
		personas.add(new Estudiante("Rubén", "González"));

		List<Persona> personas2 = List.of(new Profesor("46576917E", "Ivan", "Navas"), // Lista inmutable
				new Estudiante("Jiten", "Parwani"), new Estudiante("Rubén", "González"));

		personas.forEach(p -> p.saludar());
		// estudiantes.forEach(Persona::saludar);

		// Ejemplo 3
		List<Persona> curso = Stream.of(new Profesor("46576917E", "Ivan", "Navas"), new Estudiante("Jiten", "Parwani"),
				new Estudiante("Rubén", "González")).collect(Collectors.toList());

		for (Persona p : curso) {
			if (p instanceof Estudiante) {
				p.saludar();
			}
		}

		curso.stream().filter(p -> p instanceof Estudiante).forEach(Persona::saludar);

		curso.stream().filter(p -> p.getNombre().startsWith("A")).forEach(Persona::saludar);

		curso.stream().forEach(p -> System.out.println(p.getClass().getName()));
	}
}
