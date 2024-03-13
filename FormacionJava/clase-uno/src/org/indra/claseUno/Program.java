package org.indra.claseUno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.indra.claseUno.Entero;

public class Program {

	public static void main(String[] args) {
		// Ejemplo 1
		System.out.println("Hola mundo");

		// Ejemplo 2
		int numeroUno = 2;
		int numeroDos = 4;
		int res = numeroUno + numeroDos;
		System.out.println("La suma es " + res);

		// Ejemplo 3
		double numeroTres = 2.0;
		double numeroCuatro = 3.0;
		int res2 = ((int) numeroTres) + ((int) numeroCuatro);
		System.out.println(res2);

		// Ejemplo 4
		String nombre = "Esteban";
		String otroNombre = new String("Ivan");
		String concatenacion = nombre + otroNombre;
		System.out.println(otroNombre);
		System.out.println(concatenacion);

		// Ejemplo 5
		int num = 5;
		int sumatoria = 0;
		for (int i = 1; i <= num; i++) {
			sumatoria += i;
		}
		System.out.println(sumatoria);

		if (sumatoria % 2 == 0) {
			System.out.println("Es par");
		} else {
			System.out.println("Es impar");
		}

		System.out.println((sumatoria % 2 == 0) ? "Es par" : "Es impar");

		// Ejemplo 6
		int valor = 800;
		while (valor % 2 == 0) {
			valor = valor / 2;
		}
		System.out.println(valor);

		// Ejemplo 7
		List<String> nombres = new ArrayList<String>();
		nombres.add("Ruben");
		nombres.add("Ivan");
		nombres.add("Jiten");
		nombres.add("Alvaro");

		System.out.println("En la lista tengo " + nombres.size() + " elementos");
		System.out.println("Los nombres que tengo son: ");
		for (String n : nombres) {
			System.out.println(n);
		}

		for (String n : nombres) {
			System.out.println(n.toUpperCase());
		}

		// Ejemplo 8
		String[] nombres2 = new String[3];
		nombres2[0] = "Esteban";
		nombres2[1] = "Cova";
		nombres2[2] = "Jose";

		for (String n2 : nombres2) {
			System.out.println(n2);
		}

		// Ejemplo 9
		Random generador = new Random();
		System.out.println(generador.nextInt(1, 100));

		List<Integer> lista = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) {
			lista.add(generador.nextInt(1, 100));
		}

		int aux = 0;
		for (Integer n : lista) {
			aux += lista.get(n);
		}
		System.out.println(aux);

		double media = (double) aux / (double) lista.size();
		System.out.println(media);

		System.out.println(Collections.max(lista));
		lista.forEach(n -> System.out.println(n));
		lista.forEach(System.out::println);

		// Ejemplo 10
		Entero e = new Entero();
		e.valor = 20;
		System.out.println(e.valor);

		Entero e2 = e;
		e2.valor = 30;
		System.out.println(e.valor);

		// Ejemplo 11
		String cadena = "Hola";
		cadena += " como";
		cadena += " estas";
		System.out.println(cadena);

		StringBuilder builder = new StringBuilder();
		builder.append("Hola");
		builder.append(" como");
		builder.append(" estas");
		System.out.println(builder);
		System.out.println(builder.toString());

		// Ejemplo 12
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduce tu nombre: ");
		String nom = scanner.nextLine();
		System.out.println("Bienvenido " + nom + " a Java interactivo");
		System.out.println(String.format("Bienvenido %s a Java interactivo", nom));
		System.out.format("Bienvenido %s a Java interactivo", nom);
	}

}
