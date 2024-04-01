package org.indra.claseNueve.persistence;

import lombok.SneakyThrows;
import org.indra.claseNueve.models.Car;
import org.indra.claseNueve.models.Mobile;

public class RepositoryAbstractFactory_Reflection {
    private static Class<Repository<Car>> carRepositoryClass;
    private static Class<Repository<Mobile>> mobileRepositoryClass;

    public static void registerCarRepositoryClass(Class<Repository<Car>> carRepoClass) {
        carRepositoryClass = carRepoClass;
    }

    public static void registerMobileRepositoryClass(Class<Repository<Mobile>> mobileRepoClass) {
        mobileRepositoryClass = mobileRepoClass;
    }

    @SneakyThrows
    @SuppressWarnings("unchecked")
    public static Repository<Car> createCarRepository() {
        assert carRepositoryClass != null;
        return (Repository<Car>) carRepositoryClass.getDeclaredConstructors()[0].newInstance();
    }

    @SneakyThrows
    @SuppressWarnings("unchecked")
    public static Repository<Mobile> createMobileRepository() {
        assert mobileRepositoryClass != null;
        return (Repository<Mobile>) mobileRepositoryClass.getDeclaredConstructors()[0].newInstance();
    }
}
