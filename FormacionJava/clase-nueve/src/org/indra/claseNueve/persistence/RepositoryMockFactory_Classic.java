package org.indra.claseNueve.persistence;

import org.indra.claseNueve.models.Car;
import org.indra.claseNueve.models.Mobile;

public class RepositoryMockFactory_Classic implements RepositoryAbstractFactory_Classic {

    @Override
    public Repository<Car> createCarRepository() {
        return new MockRepository<Car>();
    }

    @Override
    public Repository<Mobile> createMobileRepository() {
        return new MockRepository<Mobile>();
    }
}
