package org.indra.claseNueve.services;

import lombok.SneakyThrows;
import org.indra.claseNueve.dto.RegistrationData;
import org.indra.claseNueve.models.Car;
import org.indra.claseNueve.models.Mobile;
import org.indra.claseNueve.persistence.MockRepository;
import org.indra.claseNueve.persistence.Repository;
import org.indra.claseNueve.persistence.RepositoryAbstractFactory_Reflection;
import org.junit.jupiter.api.Test;

public class RegistrationServiceTest {
    // Si en el futuro el servicio necesita un repositorio nuevo, no hay que modificar este código
    @Test
    @SneakyThrows
    public void testIocAbstractFactoryClassicDependencyInjection() {
        /* --- Da fallo ---
        RegistrationData registrationData = new RegistrationData();
        RepositoryMockFactory_Classic repoMockFactory = new RepositoryMockFactory_Classic();

        registrationData.setColor("Gris");
        registrationData.setMarca("OnePlus Nord 2");
        registrationData.setModel("Lamborghini Aventador SVJ");
        registrationData.setTamanio(8);
        registrationData.setYear(2000);

        MockRepository<Car> repoCar = new MockRepository<>();
        MockRepository<Mobile> repoMobile = new MockRepository<>();
        RegistrationService_IoC_DependencyInjection service = new RegistrationService_IoC_DependencyInjection(repoMockFactory);

        service.registerCarAndMobile(registrationData);

        assertEquals(1, );
        assertEquals(1, );
         */
    }

    @Test
    @SuppressWarnings("unchecked")
    void testIocAbstractFactoryClassicDependencyInjection_Static() {
        //Tiempo de configuracion
        RepositoryAbstractFactory_Reflection.registerCarRepositoryClass((Class<Repository<Car>>) (new MockRepository<Car>()).getClass());
        RepositoryAbstractFactory_Reflection.registerMobileRepositoryClass((Class<Repository<Mobile>>) (new MockRepository<Mobile>()).getClass());
        //Fin Tiempo configuracion

        RegistrationData data = new RegistrationData();
        data.setColor("Gris");
        data.setMarca("Samnsung");
        data.setModel("Fiesta");
        data.setTamanio(8);
        data.setYear(2000);

        RegistrationService_IoC_Static_DependencyInjection service = new RegistrationService_IoC_Static_DependencyInjection();
        service.registerCarAndMobile(data);
        ;
    }
}
