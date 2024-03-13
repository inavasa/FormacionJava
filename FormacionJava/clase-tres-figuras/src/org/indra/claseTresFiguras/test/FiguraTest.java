package org.indra.claseTresFiguras.test;

import static org.junit.jupiter.api.Assertions.*;

import org.indra.claseTresFiguras.models.*;
import org.junit.jupiter.api.Test;

class FiguraTest {
	@Test
	void testCirculo() {
		Circulo circulo = new Circulo(1, 1, 3.0);
		assertEquals(28.27, circulo.calcularArea(), 0.01);
		assertEquals(18.84, circulo.calcularPerimetro(), 0.01);
	}

	@Test
	void testRectangulo() {
		Rectangulo rectangulo = new Rectangulo(2, 2, 3.0, 3.0);
		assertEquals(9.0, rectangulo.calcularArea(), 0.01);
		assertEquals(12.0, rectangulo.calcularPerimetro(), 0.01);
	}

	@Test
	void testTrianguloRectangulo() {
		TrianguloRectangulo trianguloRectangulo = new TrianguloRectangulo(3, 3, 3.0, 3.0);
		assertEquals(4.5, trianguloRectangulo.calcularArea(), 0.01);
		assertEquals(10.24, trianguloRectangulo.calcularPerimetro(), 0.01);
	}
}
