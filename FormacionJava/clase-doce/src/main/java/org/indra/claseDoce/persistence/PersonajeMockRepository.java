package org.indra.claseDoce.persistence;

import org.indra.claseDoce.models.Personaje;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonajeMockRepository implements Repository<Personaje> {
    private Map<Integer, Personaje> personajes;

    public PersonajeMockRepository() {
        this.personajes = new HashMap<>();
    }

    @Override
    public void save(Personaje personaje) {
        if (personaje.getId() == 0) {
            int id = personajes.keySet().stream().mapToInt(p -> p).max().orElse(0) + 1;
            personaje.setId(id);
        }
        personajes.put(personaje.getId(), personaje);
    }

    @Override
    public void delete(Personaje personaje) {

    }

    @Override
    public void update(Personaje personaje) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Personaje findById(int id) {
        return personajes.get(id);
    }

    @Override
    public List findAll() {
        return null;
    }
}
