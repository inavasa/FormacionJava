package org.indra.claseNueve.persistence;

import org.indra.claseNueve.models.Car;
import org.indra.claseNueve.models.Mobile;

public interface RepositoryAbstractFactory_Classic {
    public Repository<Car> createCarRepository() throws PersistenceException;

    Repository<Mobile> createMobileRepository() throws PersistenceException;
}
