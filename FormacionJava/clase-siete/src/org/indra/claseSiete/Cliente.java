package org.indra.claseSiete;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
@ToString
public class Cliente {
    @Getter
    @Setter
    @NonNull
    private String nombre;
    @Getter
    @Setter
    @NonNull
    private int edad;
    private int estatura;   // Añadido para probar @RequiredArgsConstructor

    /*
    public Cliente(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    */

    @Override
    public String toString() {
        StringBuilder cadena = new StringBuilder();
        cadena.append("\nEl cliente se llama: " + this.nombre + "\n");
        cadena.append("Con edad: " + this.edad + "\n");
        return cadena.toString();
    }
}
