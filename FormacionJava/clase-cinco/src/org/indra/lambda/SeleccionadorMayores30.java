package org.indra.lambda;

public class SeleccionadorMayores30 implements SeleccionadorPersona {
	@Override
	public boolean elegir(Persona p) {
		return p.getEdad() > 30;
	}

}
