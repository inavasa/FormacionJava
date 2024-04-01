package org.indra.claseOnce.persistence;

import org.indra.claseOnce.models.ObjetoDeNegocio;

import java.util.List;

public interface Repository<T extends ObjetoDeNegocio> {
    public void save(T t);

    void delete(T t);

    void update(T t);

    void delete(int id);

    T findById(int id);

    List findAll();
}
