package org.indra.claseDoce.services;

import lombok.AllArgsConstructor;
import org.indra.claseDoce.models.Personaje;
import org.indra.claseDoce.persistence.Repository;

@AllArgsConstructor
public class PersonajeService_ConstructorInjection implements PersonajeServiceInterface {
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
