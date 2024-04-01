package org.indra.claseOnce.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class Personaje extends ObjetoDeNegocio {
    @Getter
    @Setter
    private String nombre;
}
