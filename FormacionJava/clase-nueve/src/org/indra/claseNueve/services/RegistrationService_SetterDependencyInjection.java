package org.indra.claseNueve.services;

import org.indra.claseNueve.dto.RegistrationData;
import org.indra.claseNueve.models.Car;
import org.indra.claseNueve.models.Mobile;
import org.indra.claseNueve.models.ModelValidationException;
import org.indra.claseNueve.persistence.PersistenceException;
import org.indra.claseNueve.persistence.Repository;

public class RegistrationService_SetterDependencyInjection {
    private Repository<Car> repoCar = null;
    private Repository<Mobile> repoMobile = null;

    void setRepoCar(Repository<Car> repoCar) {
        this.repoCar = repoCar;
    }

    void setRepoMobile(Repository<Mobile> repoMobile) {
        this.repoMobile = repoMobile;
    }

    public void registerCarAndMobile(RegistrationData registrationData) throws PersistenceException, ModelValidationException {
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
