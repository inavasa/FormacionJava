package org.indra.claseNueve.persistence;

import org.indra.claseNueve.models.BusinessObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockRepository<T extends BusinessObject> implements Repository<T> {
    private final Map<Integer, T> tMap;
    private int nextId;

    public MockRepository() {
        tMap = new HashMap<>();
        nextId = 1;
    }

    @Override
    public void save(T t) {
        tMap.put(nextId, t);
        t.setId(nextId++);
    }

    @Override
    public void update(T t) {
        tMap.put(t.getId(), t);
    }

    @Override
    public void delete(T t) {
        tMap.remove(t.getId());
    }

    @Override
    public void delete(int id) {
        tMap.remove(id);
    }

    @Override
    public T findById(int id) {
        return tMap.get(id);
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(tMap.values());
    }
}