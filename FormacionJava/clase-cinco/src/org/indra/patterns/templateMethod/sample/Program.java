package org.indra.patterns.templateMethod.sample;

public class Program {

	public static void main(String[] args) {
		RecetaDeCocina receta = new ArrozConPollo();
		receta.ejecutar();

		RecetaDeCocina receta2 = new Pizza();
		receta2.ejecutar();
	}

}
