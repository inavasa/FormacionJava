package org.indra.lambda;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Program {
	public static void mostrarMayoresQue(List<Persona> personas, int edadMinima) {
		for (Persona p : personas) {
			if (p.getEdad() > edadMinima) {
				System.out.println(p.getNombre());
			}
		}
	}

	public static void mostrarPersonasFiltradas(List<Persona> personas, SeleccionadorPersona seleccionador) {
		for (Persona p : personas) {
			if (seleccionador.elegir(p)) {
				System.out.println(p.getNombre());
			}
		}
	}

	public static <T> void mostrarListaFiltrada(List<T> lista, Seleccionador<T> seleccionador) {
		for (T p : lista) {
			if (seleccionador.elegir(p)) {
				System.out.println(p);
			}
		}
	}

	public static void main(String[] args) {
		Accion saludar = () -> {
			System.out.println("Hola");
		};
		Accion despedir = () -> {
			System.out.println("Adiós");
		};

		saludar.ejecutar();
		despedir.ejecutar();

		OperacionBinaria suma = (a, b) -> (a + b); // Return implícito
		OperacionBinaria resta = (a, b) -> {
			return a - b;
		}; // Con llaves escribo el return

		System.out.println(suma.ejecutar(2, 2));
		System.out.println(resta.ejecutar(8, 4));

		List<Persona> personas = List.of(new Persona("Iván", 26), new Persona("Patricia", 25),
				new Persona("Anastasiya", 24), new Persona("Adrián", 26), new Persona("Eustaquio", 78));

		mostrarMayoresQue(personas, 18);
		mostrarPersonasFiltradas(personas, new SeleccionadorMayores30());
		mostrarPersonasFiltradas(personas, p -> (p.getEdad() > 50));

		personas.stream().filter(p -> p.getEdad() > 50).forEach(System.out::println); // Operador :: es puntero a
																						// función
		mostrarListaFiltrada(personas, (p) -> (p.getEdad() > 30));

		mostrarListaFiltrada(List.of(new Automovil(10), new Automovil(20), new Automovil(30)),
				(a) -> (a.getVelocidad() > 15));

		// mostrarListaFiltrada(List.of(new Automovil(10), new Automovil(20), new
		// Automovil(30)),
		// Program::autoRapido);

		List<Persona> clones = personas.stream().map((p) -> (new Persona("Clon de: " + p.getNombre(), p.getEdad())))
				.toList();

		List<Integer> numeros = List.of(3, 4, 6, 12, 3, 5, 6, 4);
		int sumatoria = numeros.stream().reduce(0, (subtotal, elemento) -> (elemento + subtotal));
		sumatoria = numeros.stream().mapToInt(i -> i).sum(); // Otra opción
		System.out.println(sumatoria);

		int mayor = numeros.stream().reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b);
		Persona masLongeva = personas.stream().reduce(personas.stream().findFirst().get(),
				(p1, p2) -> (p1.getEdad() > p2.getEdad() ? p1 : p2));

		String texto = "Palabras de prueba para operar con ellas";
		List<String> palabras = Arrays.asList(texto.split(" "));
		Map<String, Long> ocurrencias = palabras.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	}
}
