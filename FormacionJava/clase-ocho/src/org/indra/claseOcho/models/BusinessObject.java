package org.indra.claseOcho.models;

import lombok.Getter;
import lombok.Setter;

public abstract class BusinessObject {
    @Getter
    @Setter
    private int id = 0;

    public boolean isNew() {
        return id == 0;
    }

    public void validate() throws ModelValidationException {

    }
}
