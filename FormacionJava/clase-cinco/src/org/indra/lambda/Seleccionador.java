package org.indra.lambda;

// Interfaz funcional genérica
public interface Seleccionador<T> {
	boolean elegir(T obj);
}
