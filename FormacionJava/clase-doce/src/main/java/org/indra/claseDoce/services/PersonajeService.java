package org.indra.claseDoce.services;

import lombok.Getter;
import lombok.Setter;
import org.indra.claseDoce.logging.Logger;
import org.indra.claseDoce.models.Personaje;
import org.indra.claseDoce.persistence.Repository;

public class PersonajeService implements PersonajeServiceInterface {
    @Getter
    @Setter
    private Repository<Personaje> repository;
    // @Setter
    // private Logger logger = null;

    public void registrarPersonaje(String nombre) {
        // logger.log("PersonajeService: Antes del registro");

        if (nombre == null || nombre.isEmpty()) {
            throw new Error("Nombre del personaje vacío");
        }

        Personaje personaje = new Personaje();
        personaje.setNombre(nombre);
        repository.save(personaje);

        // logger.log("PersonajeService: Después del registro");
    }

    public Personaje recuperar(int id) {
        // logger.log("PersonajeService: Antes de recuperar");
        return repository.findById(id);
    }
}
