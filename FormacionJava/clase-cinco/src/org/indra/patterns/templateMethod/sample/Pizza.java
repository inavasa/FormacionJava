package org.indra.patterns.templateMethod.sample;

public class Pizza extends RecetaDeCocina {

	@Override
	protected void listarIngredientes() {
		System.out.println("Harina");
		System.out.println("Agua");
		System.out.println("Sal");
		System.out.println("Queso");
	}

	@Override
	protected void prepararReceta() {
		System.out.println("Amasar harina con agua y sal");
		System.out.println("Dejar reposar");
	}

	@Override
	protected void cocinarPreparacion() {
		System.out.println("Cocinar al horno 10 minutos con queso encima");
	}

	@Override
	protected void servirPreparacion() {
		System.out.println("Servir en una bandeja redonda inmediatamente");
	}

}
