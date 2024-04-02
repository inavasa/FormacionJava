package org.indra.claseDoce.services;

import lombok.Setter;
import org.indra.claseDoce.logging.Logger;
import org.indra.claseDoce.models.Personaje;

public class PersonajeServiceLoggingProxy implements PersonajeServiceInterface {
    @Setter
    private PersonajeServiceInterface objetoConcreto;
    @Setter
    private Logger logger = null;

    @Override
    public void registrarPersonaje(String nombre) {
        logger.log("PersonajeService: Antes del registro");
        try {
            objetoConcreto.registrarPersonaje(nombre);
            logger.log("PersonajeService: Después del registro");
        } catch (Exception e) {
            logger.log("Error Personaje Service registro: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public Personaje recuperar(int id) {
        logger.log("PersonajeService: Antes del recuperar");
        try {
            Personaje p = objetoConcreto.recuperar(id);
            logger.log("PersonajeService: Antes del recuperar");
            return p;
        } catch (Exception e) {
            logger.log("Error Personaje Service recuperar: " + e.getMessage());
            throw e;
        }
    }
}
