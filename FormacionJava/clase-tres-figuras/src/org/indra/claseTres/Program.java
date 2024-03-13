package org.indra.claseTres;

import java.text.MessageFormat;
import java.util.*;

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

		List<Figura> dibujo = new ArrayList<Figura>();
		Random generadorRandom = new Random();
		int contador = 0;
		for (int i = 0; i < 20; i++) {
			int random = generadorRandom.nextInt(1, 4);
			switch (random) {
			case 1:
				Rectangulo rectangulo2 = new Rectangulo(generadorRandom.nextDouble(1, 100),
						generadorRandom.nextDouble(1, 100));
				dibujo.add(rectangulo2);
				break;
			case 2:
				TrianguloRectangulo triangulo2 = new TrianguloRectangulo(generadorRandom.nextDouble(1, 100),
						generadorRandom.nextDouble(1, 100));
				dibujo.add(triangulo2);
				break;
			case 3:
				Circulo circulo2 = new Circulo(generadorRandom.nextDouble(1, 100));
				dibujo.add(circulo2);
				break;
			}
		}

		Figura conMayorArea = dibujo.stream().max(Comparator.comparingDouble(f -> f.calcularArea())).orElse(null);
		System.out.println(MessageFormat.format("{0} de área máxima {1}", conMayorArea.getClass().getSimpleName(),
				conMayorArea.calcularArea()));

		Figura conMenorPerimetro = dibujo.stream().min(Comparator.comparingDouble(f -> f.calcularPerimetro()))
				.orElse(null);
		System.out.println(MessageFormat.format("{0} de perímetro mínimo {1}",
				conMenorPerimetro.getClass().getSimpleName(), conMenorPerimetro.calcularPerimetro()));

		AreaCalculable a = new Rectangulo(10, 10);
		a = new Terreno(122, 200);
	}
}
