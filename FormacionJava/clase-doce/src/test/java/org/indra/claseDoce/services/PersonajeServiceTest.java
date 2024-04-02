package org.indra.claseDoce.services;

import org.indra.claseDoce.models.Personaje;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonajeServiceTest {
    @Test
    void testPersonajeService() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        PersonajeService personajeService = (PersonajeService) applicationContext.getBean("service");
        personajeService.registrarPersonaje("Xavier");

        Personaje personaje = personajeService.recuperar(1);
        assertEquals("Xavier", personaje.getNombre());
    }

    @Test
    void testPersonajeService_ConstructorDependencyInjection() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        PersonajeServiceInterface personajeService = (PersonajeServiceInterface) applicationContext.getBean("serviceConstructor");
        personajeService.registrarPersonaje("Xavier");

        Personaje personaje = personajeService.recuperar(1);
        assertEquals("Xavier", personaje.getNombre());
    }
}