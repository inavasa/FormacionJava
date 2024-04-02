package org.indra.claseDoce.services;

import org.indra.claseDoce.models.Personaje;

public interface PersonajeServiceInterface {
    void registrarPersonaje(String nombre);

    Personaje recuperar(int id);
}
