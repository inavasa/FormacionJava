package org.indra.claseOcho.persistence;

import org.indra.claseOcho.models.BusinessObject;

import java.util.List;

public interface Repository<T extends BusinessObject> {
    void save(T model) throws PersistenceException;

    void update(T model) throws PersistenceException;

    void delete(T model) throws PersistenceException;

    void delete(int id) throws PersistenceException;

    T findById(int id) throws PersistenceException;

    List<T> findAll() throws PersistenceException;
}
