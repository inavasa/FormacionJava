package org.indra.patterns.templateMethod.sample;

public class ArrozConPollo extends RecetaDeCocina {

	@Override
	protected void listarIngredientes() {
		System.out.println("Arroz");
		System.out.println("Agua");
		System.out.println("Pollo");
		System.out.println("Sal");
		System.out.println("Ajo");
		System.out.println("Pimienta negra");
		System.out.println("Aceite");
	}

	@Override
	protected void prepararReceta() {
		System.out.println("Poner el agua a hervir");
		System.out.println("Calentar aceite");
		System.out.println("Cortar ajo");

	}

	@Override
	protected void cocinarPreparacion() {
		System.out.println("Agregar sal y arroz al agua");
		System.out.println("Introducir y freir ajo");
		System.out.println("Introducir pollo y sazonar con sal y pimienta negra");
	}

	@Override
	protected void servirPreparacion() {
		System.out.println("Una vez que todo esté cocinado, servir en plato grande");
	}

}
