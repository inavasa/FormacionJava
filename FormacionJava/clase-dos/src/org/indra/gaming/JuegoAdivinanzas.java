package org.indra.gaming;

import java.util.Random;

import org.indra.io.Console;

public class JuegoAdivinanzas {
	private static final int CANTIDAD_OPORTUNIDADES = 5;

	public void jugar() {
		Random generadorNumeros = new Random();
		int contador = CANTIDAD_OPORTUNIDADES;
		int valor = generadorNumeros.nextInt(1, 100);
		boolean adivinado = false;
		int intentar = 0;

		do {
			intentar = Console.promptInt("Intenta adivinar el número");

			if (intentar == valor) {
				adivinado = true;
			} else if (intentar > valor) {
				System.out.println("El número es menor");
			} else if (intentar < valor) {
				System.out.println("El número es mayor");
			}

			--contador;
		} while ((adivinado == false) && (contador > 0));

		if (adivinado) {
			System.out.println("Número acertado");
		} else {
			System.out.println("Número no acertado. El número era " + valor);
		}
	}
}
