package org.indra.claseNueve.persistence;

import lombok.Getter;

public class PersistenceException extends Exception {
    @Getter
    private Exception innerException;

    public PersistenceException(String message, Exception innerException) {
        super(message);
        this.innerException = innerException;
    }
}
