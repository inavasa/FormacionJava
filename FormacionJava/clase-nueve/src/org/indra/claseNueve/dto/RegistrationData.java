package org.indra.claseNueve.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class RegistrationData {
    @Getter
    @Setter
    private String model;
    @Getter
    @Setter
    private int year;
    @Getter
    @Setter
    private String color;
    @Getter
    @Setter
    private String marca;
    @Getter
    @Setter
    private int tamanio;
}
