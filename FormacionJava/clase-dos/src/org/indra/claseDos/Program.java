package org.indra.claseDos;

import java.util.*;
import org.indra.io.*;
import org.indra.gaming.*;
import org.indra.claseDos.models.*;

public class Program {

	public static void main(String[] args) {
		/*
		 * // Ejemplo 1 Scanner scanner = new Scanner(System.in);
		 * System.out.println("Introduce tu nombre: ");
		 * 
		 * String nombre = new String(); while (nombre.isEmpty() == true) { nombre =
		 * scanner.nextLine(); }
		 * 
		 * System.out.format("Bienvenido %s", nombre);
		 * 
		 * // Ejemplo 2 nombre = Console.readNonEmptyLine();
		 * System.out.format("Bienvenido %s", nombre);
		 * 
		 * // Ejemplo 3 nombre = Console.prompt("Ingrese el nombre: ");
		 * System.out.format("Bienvenido %s", nombre);
		 * 
		 * scanner.close();
		 */
		/*
		 * // Ejemplo 4 String nombre = Console.prompt("Nombre: "); String apellido =
		 * Console.prompt("Apellido: "); int edad = Console.promptInt("Edad: ");
		 * 
		 * System.out.format(""" Bienvenido %s %s. Tienes %d años """, nombre, apellido,
		 * edad);
		 * 
		 * // Ejemplo 5 JuegoAdivinanzas juego = new JuegoAdivinanzas(); juego.jugar();
		 */

		// Ejemplo 5
		Persona p = new Persona();
		p.setNombre("Iván");
		p.setApellido("Navas");
		p.setEdad(26);
		System.out.format("Bienvenido %s %s. Tienes %d años", p.getNombre(), p.getApellido(), p.getEdad());

		Persona p2 = new Persona("Alvaro", "Moreno", 29);
		// p2.setNombre("");
		System.out.format("\nBienvenido %s %s. Tienes %d años", p2.getNombre(), p2.getApellido(), p2.getEdad());

		List<Persona> asistentes = new ArrayList<Persona>();
		asistentes.add(p);
		asistentes.add(p2);

		asistentes.forEach(a -> {
			System.out.format("\nBienvenido %s %s. Tienes %d años\n", a.getNombre(), a.getApellido(), a.getEdad());
		});
		asistentes.forEach(System.out::println);
	}

}
