package org.indra.claseNueve.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.text.MessageFormat;
import java.time.LocalDate;

@ToString
@NoArgsConstructor
public class Car extends BusinessObject {
    @Getter
    @Setter
    private String model;
    @Getter
    @Setter
    private int year;
    @Getter
    @Setter
    private String color;

    @Override
    public void validate() throws ModelValidationException {
        super.validate();

        if (model == null || model.trim().length() == 0) {
            throw new ModelValidationException("model", "Attribute can't be empty");
        }

        int currentYear = LocalDate.now().getYear();
        if (this.getYear() < 1920 || this.getYear() > 2024) {
            throw new ModelValidationException("year", MessageFormat.format("Range error. Min {0}, Max {1}", 1920, currentYear));
        }

        if (color == null || color.trim().isEmpty()) {
            throw new ModelValidationException("color", "Attribute can't be empty");
        }
    }
}
