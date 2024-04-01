package org.indra.claseNueve.services;

import org.indra.claseNueve.dto.RegistrationData;
import org.indra.claseNueve.models.Car;
import org.indra.claseNueve.models.Mobile;
import org.indra.claseNueve.models.ModelValidationException;
import org.indra.claseNueve.persistence.MockRepository;
import org.indra.claseNueve.persistence.PersistenceException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationService_ConstructorDependencyInjectionTest {
    @Test
    public void testConstructorDependencyInjection() throws ModelValidationException, PersistenceException {
        RegistrationData registrationData = new RegistrationData();

        registrationData.setColor("Gris");
        registrationData.setMarca("OnePlus Nord 2");
        registrationData.setModel("Lamborghini Aventador SVJ");
        registrationData.setTamanio(8);
        registrationData.setYear(2000);

        MockRepository<Car> repoCar = new MockRepository<>();
        MockRepository<Mobile> repoMobile = new MockRepository<>();
        RegistrationService_ConstructorDependencyInjection service = new RegistrationService_ConstructorDependencyInjection(repoCar, repoMobile);

        service.registerCarAndMobile(registrationData);

        assertEquals(1, repoCar.findAll().size());
        assertEquals(1, repoMobile.findAll().size());
    }
}