package org.indra.claseNueve.persistence;

import lombok.SneakyThrows;
import org.indra.claseNueve.models.Car;
import org.indra.claseNueve.models.Mobile;

public class RepositorySqliteFactory_Classic implements RepositoryAbstractFactory_Classic {

    @Override
    @SneakyThrows
    public Repository<Car> createCarRepository() {
        return new CarSqliteRepository();
    }

    @Override
    @SneakyThrows
    public Repository<Mobile> createMobileRepository() {
        return new MobileSqliteRepository();
    }
}
