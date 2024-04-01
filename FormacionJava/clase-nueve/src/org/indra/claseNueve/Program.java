package org.indra.claseNueve;

import org.indra.claseNueve.models.Car;
import org.indra.claseNueve.models.Mobile;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Program {
    /* Reflection (casos de uso):
    1.- Tener una referencia a una clase y crear objetos a partir de la misma
    2.- Crear una clase a partir de un String
    3.- Listar los atributos de una clase o un objeto
    4.- Listar los métodos de una clase
    5.- Listar los métodos de un objeto
    6.- Invocar un método a partir de un String
    7.- Listar las clases que hay dentro de un paquete
     */

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        // 1.- Tener una referencia a una clase y crear objetos a partir de la misma

        Class<?> clase = Mobile.class;
        Object o = clase.getDeclaredConstructor().newInstance();
        System.out.println("Creando una variable a partir de tipo Class");
        System.out.println(o);

        // 2.- Crear una clase a partir de un String

        Object o2 = Class.forName("org.indra.claseNueve.models.Car").getDeclaredConstructors()[0].newInstance();

        System.out.println("\nCreando una clase a partir de un String");
        System.out.println(o2);

        // 3.- Listar los atributos de una clase o un objeto

        System.out.println("\nVamos a mostrar los atributos  de la clase Car:");

        for (Field campo : Car.class.getDeclaredFields()) {
            System.out.println(campo.getName() + ": " + campo.getType().getName());
        }

        // 4.- Listar los métodos de una clase

        System.out.println("\nVamos a mostrar los métodos de la clase File:");

        for (Method method : File.class.getDeclaredMethods()) {
            System.out.println(method.getName());
        }

        // 5.- Listar los métodos de un objeto

        Car car = new Car();
        System.out.println("\nVamos a mostrar los metodos del objeto Car");
        for (Method metodo : car.getClass().getDeclaredMethods()) {
            System.out.println(metodo.getName());
        }

        // 6.- Invocar un método a partir de un String

        System.out.println("\nInvocamos el método toString a partir de un String");
        String texto = (String) car.getClass().getDeclaredMethod("toString", null).invoke(car, (Object[]) null);
        System.out.println(texto);
    }
}
