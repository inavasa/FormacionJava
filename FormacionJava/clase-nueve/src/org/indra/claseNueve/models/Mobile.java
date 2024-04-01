package org.indra.claseNueve.models;

import lombok.*;

import java.text.MessageFormat;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Mobile extends BusinessObject {
    @Getter
    @Setter
    private String marca;
    @Getter
    @Setter
    private int tamanio;

    @Override
    public void validate() throws ModelValidationException {
        super.validate();

        if ((marca == null) || (marca.trim().isEmpty())) {
            throw new ModelValidationException("marca", "Attribute cannot be empty.");
        }
        if ((tamanio <= 5) || (tamanio > 10)) {
            throw new ModelValidationException("year", MessageFormat.format("Range error. Min {0} Max {1}", 5, 10));
        }
    }
}
