package org.indra.claseNueve.services;

import lombok.SneakyThrows;
import org.indra.claseNueve.dto.RegistrationData;
import org.indra.claseNueve.models.Car;
import org.indra.claseNueve.models.Mobile;
import org.indra.claseNueve.persistence.Repository;
import org.indra.claseNueve.persistence.RepositoryAbstractFactory_Reflection;

public class RegistrationService_IoC_Static_DependencyInjection {
    @SneakyThrows
    public void registerCarAndMobile(RegistrationData registrationData) {
        Repository<Car> repoCar = RepositoryAbstractFactory_Reflection.createCarRepository();
        Repository<Mobile> repoMobile = RepositoryAbstractFactory_Reflection.createMobileRepository();

        Car car = new Car();
        car.setModel(registrationData.getModel());
        car.setYear(registrationData.getYear());
        car.setColor(registrationData.getColor());
        car.validate();

        Mobile mobile = new Mobile();
        mobile.setMarca(registrationData.getMarca());
        mobile.setTamanio(registrationData.getTamanio());
        mobile.validate();

        repoCar.save(car);
        repoMobile.save(mobile);
    }
}
