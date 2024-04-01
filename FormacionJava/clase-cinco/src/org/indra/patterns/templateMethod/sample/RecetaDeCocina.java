package org.indra.patterns.templateMethod.sample;

public abstract class RecetaDeCocina {
	protected abstract void listarIngredientes();

	protected abstract void prepararReceta();

	protected abstract void cocinarPreparacion();

	protected abstract void servirPreparacion();

	public final void ejecutar() {
		System.out.println("Los ingredientes son:");
		this.listarIngredientes();
		System.out.println("\nPara preparar hay que:");
		this.prepararReceta();
		System.out.println("\nCocine la preparación así:");
		this.cocinarPreparacion();
		System.out.println("\nFinalmente sirva así:");
		this.servirPreparacion();
	}
}
