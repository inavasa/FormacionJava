package org.indra.claseTres;

import org.indra.claseTresFiguras.models.*;

public class Program {
	public static void main(String[] args) {
		Circulo circulo = new Circulo(1, 1, 3.0);
		Rectangulo rectangulo = new Rectangulo(2, 2, 3.0, 3.0);
		TrianguloRectangulo trianguloRectangulo = new TrianguloRectangulo(3, 3, 3.0, 3.0);

		double areaCirculo = circulo.calcularArea();
		double perimetroCirculo = circulo.calcularPerimetro();

		double areaRectangulo = rectangulo.calcularArea();
		double perimetroRectangulo = rectangulo.calcularPerimetro();

		double areaTrianguloRectangulo = trianguloRectangulo.calcularArea();
		double perimetroTrianguloRectangulo = trianguloRectangulo.calcularPerimetro();

		System.out.println("Círculo:\n");
		System.out.println("Área: " + areaCirculo + ", perímetro: " + perimetroCirculo + "\n");

		System.out.println("Rectángulo:\n");
		System.out.println("Área: " + areaRectangulo + ", perímetro: " + perimetroRectangulo + "\n");

		System.out.println("Triángulo Rectángulo:\n");
		System.out.println("Área: " + areaTrianguloRectangulo + ", perímetro: " + perimetroTrianguloRectangulo + "\n");
	}
}
