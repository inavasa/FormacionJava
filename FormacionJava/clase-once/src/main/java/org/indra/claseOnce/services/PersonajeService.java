package org.indra.claseOnce.services;

import lombok.Getter;
import lombok.Setter;
import org.indra.claseOnce.models.Personaje;
import org.indra.claseOnce.persistence.Repository;

public class PersonajeService implements PersonajeServiceInterface{

    @Getter
    @Setter
    private Repository<Personaje> repository;

    public void registrarPersonaje(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new Error("Nombre del personaje vacío");
        }

        Personaje personaje = new Personaje();
        personaje.setNombre(nombre);
        repository.save(personaje);
    }

    public Personaje recuperar(int id) {
        return repository.findById(id);
    }
}
