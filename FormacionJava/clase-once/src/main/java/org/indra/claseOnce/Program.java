package org.indra.claseOnce;

import org.indra.claseOnce.models.Personaje;
import org.indra.claseOnce.persistence.Repository;
import org.indra.claseOnce.services.PersonajeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {

    public static void main(String[] args) {
        // SpringApplication.run(ClaseDiezApplication.class, args);
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Repository repository = (Repository) applicationContext.getBean("repositoryPersonaje");

        Personaje personaje = new Personaje("Magneto");
        repository.save(personaje);

        Personaje personaje2 = (Personaje) repository.findById(1);
        System.out.println(personaje2.getNombre());

        PersonajeService personajeService = (PersonajeService) applicationContext.getBean("service");
        personajeService.registrarPersonaje("Xavier");
    }
}
