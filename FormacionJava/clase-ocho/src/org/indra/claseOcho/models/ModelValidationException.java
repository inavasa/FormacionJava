package org.indra.claseOcho.models;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ModelValidationException extends Exception {
    private String attribute;
    private String reason;
}
