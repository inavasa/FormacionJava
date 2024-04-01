package org.indra.claseNueve.services;

import lombok.SneakyThrows;
import org.indra.claseNueve.dto.RegistrationData;
import org.indra.claseNueve.models.Car;
import org.indra.claseNueve.models.Mobile;
import org.indra.claseNueve.persistence.Repository;
import org.indra.claseNueve.persistence.RepositoryAbstractFactory_Classic;

// IoC = Inversion of Control Container es una fábrica que crea objetos
// para la inyección de dependencias
public class RegistrationService_IoC_DependencyInjection {
    private RepositoryAbstractFactory_Classic repoFactory;

    /* Ventajas:
    1.- No tengo que modificar lo de afuera si en el futuro necesito otro repositorio
    2.- Puedo crear todos los repositorios que quiera
     */
    public RegistrationService_IoC_DependencyInjection(RepositoryAbstractFactory_Classic repoFactory) {
        this.repoFactory = repoFactory;
    }

    @SneakyThrows
    public void registerCarAndMobile(RegistrationData registrationData) {
        Repository<Car> repoCar = this.repoFactory.createCarRepository();
        Repository<Mobile> repoMobile = this.repoFactory.createMobileRepository();

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
