package org.indra.io;

import java.util.*;

public class Console {
	private static Scanner scanner = new Scanner(System.in);

	public static String readNonEmptyLine() {
		String nombre = scanner.nextLine();

		while (nombre.trim().length() == 0) {
			System.out.println("Entrada vacía. Vuelve a ingresar");
			nombre = scanner.nextLine();
		}

		return nombre;
	}

	public static String prompt(String mensaje) {
		System.out.println(mensaje);

		return readNonEmptyLine();
	}

	public static int readInt() {
		String entrada = Console.readNonEmptyLine();
		int edad = 0;

		try {
			edad = Integer.parseInt(entrada);
		} catch (Exception ex) {
			System.out.println("Error en la conversión a entero");
		}

		return edad;
	}

	public static int promptInt(String mensaje) {
		System.out.println(mensaje);

		return readInt();
	}
}
